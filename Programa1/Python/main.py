"""
Archivo principal del programa.

Desde aquí se ejecuta el programa y el usuario puede
elegir qué problema desea resolver.
"""

from modelos import Persona, BolsaVaquitas
from problema1 import problema1
from problema2 import problema2


def leer_archivo(nombre_archivo):
    """
    Lee un archivo de texto con información de personas.

    Formato esperado por línea:
    nombre,edad,leGustanVaquitas

    Regresa una lista de objetos Persona.
    """
    personas = []
    with open(nombre_archivo, "r") as f:
        for linea in f:
            nombre, edad, gusta = linea.strip().split(",")
            personas.append(
                Persona(nombre, int(edad), gusta == "1")
            )
    return personas


def main():
    """
    Función principal del programa.
    Muestra un menú y ejecuta el problema seleccionado.
    """
    print("1. Resolver Problema 1")
    print("2. Resolver Problema 2")
    opcion = int(input("Selecciona una opción: "))

    if opcion == 1:
        # Problema 1: repartir vaquitas
        personas = leer_archivo("archivo.txt")
        bolsa = BolsaVaquitas(10)
        problema1(personas, bolsa)

    elif opcion == 2:
        # Problema 2: mostrar nombres y edades
        personas = leer_archivo("archivo.txt")
        for p in personas:
            print(p.nombre, p.edad)


main()
