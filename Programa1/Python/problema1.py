"""
Solución del Problema 1.

Dado un arreglo de personas y una bolsa de vaquitas,
se determina quiénes alcanzan vaquitas, considerando
solo a las personas a las que sí les gustan.
"""

from modelos import Persona, BolsaVaquitas


def problema1(personas, bolsa):
    """
    Resuelve el problema 1.

    Recorre la lista de personas y entrega vaquitas
    mientras haya disponibles. Imprime los nombres
    de las personas que sí alcanzaron.

    Complejidad: O(n)
    """
    print("Personas que recibieron vaquitas:")
    for persona in personas:
        if persona.le_gustan_vaquitas:
            if bolsa.dar_vaquita():
                print(persona.nombre)
            else:
                break
