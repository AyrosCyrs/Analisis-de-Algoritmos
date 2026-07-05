"""
Archivo de modelos.

Aquí se definen las clases principales que se usan en ambos problemas:
- Persona
- BolsaVaquitas
"""

class Persona:
    """
    Clase que modela a una persona.

    Atributos:
    - nombre: nombre de la persona
    - edad: edad de la persona (opcional, se usa en el problema 2)
    - le_gustan_vaquitas: indica si a la persona le gustan las vaquitas
    """

    def __init__(self, nombre, edad=None, le_gustan_vaquitas=False):
        self.nombre = nombre
        self.edad = edad
        self.le_gustan_vaquitas = le_gustan_vaquitas


class BolsaVaquitas:
    """
    Clase que representa una bolsa de vaquitas.
    Controla cuántas vaquitas hay disponibles.
    """

    def __init__(self, cantidad):
        self.cantidad = cantidad

    def dar_vaquita(self):
        """
        Intenta dar una vaquita.

        Regresa True si aún había vaquitas disponibles.
        Regresa False si la bolsa ya está vacía.
        """
        if self.cantidad > 0:
            self.cantidad -= 1
            return True
        return False
