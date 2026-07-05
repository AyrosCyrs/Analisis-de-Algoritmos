# Programa 1 – Análisis de Algoritmos  
### Claudia Yarinet Osorio Lopez -- 316256098

Este proyecto implementa la solución a dos problemas utilizando programación orientada a objetos y recorridos lineales, como parte de la materia Análisis de Algoritmos.

El entregado contiene dos implementaciones del mismo programa:

- Una en Python
- Una en Java

## Problemas resueltos
### Problema 1
Dado un arreglo de personas y una bolsa de vaquitas, determinar si es posible dar vaquitas a las personas considerando que:
- No a todas las personas les gustan las vaquitas.
- La bolsa tiene una cantidad limitada de vaquitas.
- Solo reciben vaquitas las personas a las que sí les gustan.
- El programa imprime los nombres de las personas que alcanzaron vaquitas.

### Problema 2
Dado:
- Un arreglo de cadenas con nombres.
- Un arreglo de enteros con edades.

El programa construye un arreglo de personas donde cada persona tiene su nombre y edad correspondientes.

## Estructura del proyecto
```bash
Programa1/
│
├── README.md
│
├── Java/
│   ├── archivo.txt
│   ├── BolsaVaquitas.java
│   ├── LectorArchivo.java
│   ├── Main.java
│   ├── Persona.java
│   ├── Problema1.java
│   └── Problema2.java
│
└── Python/
    ├── archivo.txt
    ├── main.py
    ├── modelos.py
    ├── problema1.py
    └── problema2.py

```
## Formato del archivo de entrada (archivo.txt)

El archivo archivo.txt se utiliza en ambos lenguajes y tiene el siguiente formato por línea:

```bash
nombre, edad, leGustanVaquitas
```
donde:
- `1` indica que le gustan las vaquitas
- `0` indica que no le gustan

## Cómo ejecutar el programa (Python)
### 1. Requisitos
- Tener **Python 3** instalado.

### 2. Pasos
- Abrir la terminal
- Ubicarse en la carpeta donde se encuentra el archivo main.py.
- Ejecutar el programa
En la terminal, escribir:
```bash
python main.py
```
### 4. Uso del programa
Al ejecutarse, el programa mostrará un menú:
```bash
1. Resolver Problema 1
2. Resolver Problema 2
```
El usuario deberá ingresar el número correspondiente al problema que desea resolver.

## Cómo ejecutar el programa – Java
### 1. Requisitos
- Tener instalado el JDK de Java.
- Verificar con:
```bash
javac --version
```
### 2. Pasos
- Abrir una terminal.
- Ubicarse en la carpeta Java:
```bash
cd Programa1/Java
```
- Compilar todos los archivos:
```bash
javac *.java
```
- Ejecutar el programa principal:
```bash
java Main
```
- El programa mostrará un menú para seleccionar el problema a resolver.