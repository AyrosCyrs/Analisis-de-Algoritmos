# Programa 3 – Análisis de Algoritmos
### Claudia Yarinet Osorio Lopez -- 316256098

Este proyecto implementa el algoritmo para encontrar el **núcleo de una digráfica acíclica**, como parte de la materia Análisis de Algoritmos.

## ¿Qué es el núcleo de una digráfica?

Dado un conjunto de vértices y las flechas (aristas dirigidas) entre ellos, el núcleo es un subconjunto de vértices que cumple dos condiciones: ningún vértice del subconjunto tiene flecha hacia otro vértice del mismo subconjunto, y cualquier vértice fuera del subconjunto tiene flecha hacia algún vértice dentro de él.

## Funcionalidad

- Construcción de una digráfica a partir de un archivo de texto
- Cálculo del núcleo de la digráfica (algoritmo visto en clase, Nota 8)
- Método `esNucleo`, que verifica si un subconjunto dado realmente es núcleo de la digráfica
- Impresión de la digráfica y su núcleo en terminal

## Formato del archivo de entrada

La primera línea contiene los vértices de la digráfica, separados por coma. Las siguientes líneas representan las flechas (de un vértice a otro):

```bash
a,b,c,d,e,f,g,h,i,j
b,a
b,c
c,j
i,h
h,g
g,f
e,h
d,c
d,e
```

## Estructura del proyecto

```bash
Programa3/
│
├── README.md
└── Digrafica.java
```

## Cómo ejecutarlo

### 1. Requisitos
- Tener instalado el JDK de Java

### 2. Pasos
- Abrir la terminal
- Ubicarse en la carpeta `Programa3`
- Compilar:
```bash
javac Digrafica.java
```
- Ejecutar:
```bash
java Digrafica
```
- El programa mostrará la digráfica creada, calculará su núcleo, y comprobará que el resultado sí es un núcleo válido

## Documentación del código
El código está documentado con **Javadoc** en cada método.

## Nota
Solo se utilizó la clase `Conjunto` proporcionada por el profesor, tal como lo pedía la práctica.