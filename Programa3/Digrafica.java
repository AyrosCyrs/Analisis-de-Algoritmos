/**
 * Clase que representa una digráfica.
 * @author Claudia Yarinet Osorio Lopez
 * @Github Clausyari
 * @Date 2026.01.24
 */

import java.io.*;

// Si por aqui sale un import que diga `import EDD20241.Practicas.Practica02.Conjunto;` por favor borrelo, se mete de espia pero no tiene cabida aqui

public class Digrafica<T>{
    
    private class Vertice{
        
        T elemento;
        int inGrado;
        int exGrado;
        
        public Vertice(T elemento){
            this.elemento = elemento;
            this.inGrado = 0;
            this.exGrado = 0;
        }
        
        public void aumentarInGrado(){
            this.inGrado++;
        }
        
        public void aumentarExGrado(){
            this.exGrado++;
        }
        
        @SuppressWarnings("unchecked")
        @Override
        public boolean equals(Object obj) {
            if (this == obj){
                return true;
            }
            
            if (obj == null || getClass() != obj.getClass()){
                return false;
            }
            
            Vertice otro = (Vertice) obj;
            return this.elemento.equals(otro.elemento);
        }
        
        @Override
        public String toString() {
            return elemento.toString();
        }
    }
    
    private class Flecha{
        
        Vertice inicio;
        Vertice fin;
        
        public Flecha(Vertice inicio, Vertice fin){
            this.inicio = inicio;
            this.fin = fin;
            inicio.aumentarExGrado();
            fin.aumentarInGrado();
        }
        
        public boolean esFlecha(T in, T fi){
            return (this.inicio.elemento.equals(in)) && (this.fin.elemento.equals(fi));
        }
        
        @SuppressWarnings("unchecked")
        @Override
        public boolean equals(Object obj) {
            if (this == obj){
                return true;
            }
            
            if (obj == null || getClass() != obj.getClass()){
                return false;
            }
            
            Flecha otra = (Flecha) obj;
            return (otra.inicio.equals(this.inicio)) && (otra.fin.equals(this.fin));
        }
    }
    
    Conjunto<Vertice> vertices = new Conjunto<Vertice>();
    Conjunto<Flecha> flechas = new Conjunto<Flecha>();
    
    public Digrafica(){}
    
    /**
     * Agrega un vértice a la digráfica.
     * Si el vértice ya existe, el conjunto evita duplicados.
     */
    public void agregarVertice(T elemento) {
        Vertice v = new Vertice(elemento);
        if (!vertices.pertenece(v)) { // Verificamos antes por si las dudas
            vertices.agregar(v);
        }
    }
    
    /**
     * Agrega una flecha entre dos vértices ya existentes.
     * Actualiza automáticamente los grados.
     */
    public void agregarFlecha(T inicio, T fin) {
        Vertice vInicio = null;
        Vertice vFin = null;

        for (Vertice v : vertices) {
            if (v.elemento.equals(inicio)) vInicio = v;
            if (v.elemento.equals(fin)) vFin = v;
        }

        if (vInicio != null && vFin != null) {
            Flecha f = new Flecha(vInicio, vFin);
            if (!flechas.pertenece(f)) {
                flechas.agregar(f);
            }
        }
    }
    
    /**
     * Obtiene el núcleo de una digráfica acíclica.
     * Basado en la Nota 8.
     */
    public Conjunto<Vertice> obtenerNucleoAciclica() {

        Conjunto<Vertice> nucleo = new Conjunto<>();
        Conjunto<Vertice> restantes = new Conjunto<>();

        for (Vertice v : vertices) {
            restantes.agregar(v);
        }

        while (!restantes.esVacio()) {

            Vertice candidato = null;

            // Buscamos un vértice que sea sumidero EN EL SUBGRAFO ACTUAL
            for (Vertice v : restantes) {
                boolean esSumidero = true;
                
                // Revisamos si tiene flechas hacia alguien que TODAVÍA esté en 'restantes'
                for (Flecha f : flechas) {
                    if (f.inicio.equals(v) && restantes.pertenece(f.fin)) {
                        esSumidero = false;
                        break;
                    }
                }

                if (esSumidero) {
                    candidato = v;
                    break; 
                }
            }

            if (candidato == null) break; 

            // Lo agregamos al núcleo y eliminamos
            nucleo.agregar(candidato);
            restantes.eliminar(candidato);

            // Eliminamos in-vecinos (N-(X))
            Conjunto<Vertice> aEliminar = new Conjunto<>();
            for (Flecha f : flechas) {
                if (f.fin.equals(candidato) && restantes.pertenece(f.inicio)) {
                    aEliminar.agregar(f.inicio);
                }
            }
            for (Vertice v : aEliminar) {
                restantes.eliminar(v);
            }
        }
        return nucleo;
    }

    /**
     * Verifica si un subconjunto S es núcleo de D.
     * Núcleo = Independiente + Absorbente.
     * @param S El conjunto de vértices a verificar.
     * @return true si es núcleo, false en otro caso.
     */
    public boolean esNucleo(Conjunto<Vertice> S) {
        // 1. Independencia: No debe haber flechas entre elementos de S
        for (Flecha f : flechas) {
            if (S.pertenece(f.inicio) && S.pertenece(f.fin)) {
                return false;
            }
        }

        // 2. Absorbencia: Todo nodo fuera de S debe apuntar a S
        for (Vertice v : vertices) {
            if (!S.pertenece(v)) { 
                boolean esAbsorbido = false;
                for (Flecha f : flechas) {
                    if (f.inicio.equals(v) && S.pertenece(f.fin)) {
                        esAbsorbido = true;
                        break;
                    }
                }
                if (!esAbsorbido) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Método principal para probar el código con un archivo.
     */
    public static void main(String[] args) {
        Digrafica<String> g = new Digrafica<>();
        String nombreArchivo = "grafo.txt"; 

        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            // Leemos la primera línea (Vértices)
            String linea = br.readLine();
            if (linea != null) {
                String[] partes = linea.split(",");
                for (String s : partes) {
                    g.agregarVertice(s.trim());
                }
            }

            // Leemos las flechas
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(",");
                if (partes.length >= 2) {
                    g.agregarFlecha(partes[0].trim(), partes[1].trim());
                }
            }

            System.out.println("--- Digráfica Cargada ---");

            System.out.print("Vértices: { ");
            for (Digrafica<String>.Vertice v : g.vertices) {
                System.out.print(v + " ");
            }
            System.out.println("}");

            System.out.println("Flechas:");
            for (Digrafica<String>.Flecha f : g.flechas) {
                System.out.println(f.inicio + " -> " + f.fin);
            }

            System.out.println("\n--- Calculando Núcleo ---");
            Conjunto<Digrafica<String>.Vertice> nucleo = g.obtenerNucleoAciclica();
            
            System.out.print("Núcleo: { ");
            for (Digrafica<String>.Vertice v : nucleo) {
                System.out.print(v + " ");
            }
            System.out.println("}");

            System.out.println("\n--- Verificación ---");
            if (g.esNucleo(nucleo)) {
                System.out.println("Resultado: ¡Es un núcleo válido!");
            } else {
                System.out.println("Resultado: Algo falló, no es núcleo.");
            }

        } catch (IOException e) {
            System.out.println("Error: No se pudo leer el archivo 'grafo.txt'");
        }
    }
}