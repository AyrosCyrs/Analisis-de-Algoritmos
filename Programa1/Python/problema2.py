"""
Solución del Problema 2.

A partir de dos arreglos (nombres y edades),
se crea un arreglo de objetos Persona.
"""

from modelos import Persona


def problema2(nombres, edades):
    """
    Crea una lista de personas usando dos arreglos:
    uno de nombres y otro de edades.

    Complejidad: O(n)
    """
    personas = []
    for i in range(len(nombres)):
        personas.append(Persona(nombres[i], edades[i]))
    return personas
