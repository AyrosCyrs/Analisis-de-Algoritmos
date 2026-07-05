import random
# @author Claudia Yarinet Osorio Lopez
# @Github Clausyari
# @Date 2025.01.20

def intercambiar(arr, i, j):
    """Intercambia dos elementos del arreglo."""
    arr[i], arr[j] = arr[j], arr[i]


def encontrar_indice_menor(arr, i, j):
    """Encuentra el índice del menor elemento en el rango [i, j]."""
    indice_menor = i
    for k in range(i + 1, j + 1):
        if arr[k] < arr[indice_menor]:
            indice_menor = k
    return indice_menor


def insertion_sort(arr):
    """Ordena el arreglo usando Insertion Sort."""
    for i in range(1, len(arr)):
        actual = arr[i]
        j = i - 1
        while j >= 0 and arr[j] > actual:
            arr[j + 1] = arr[j]
            j -= 1
        arr[j + 1] = actual


def selection_sort(arr):
    """Ordena el arreglo usando Selection Sort."""
    for i in range(len(arr) - 1):
        indice_menor = encontrar_indice_menor(arr, i, len(arr) - 1)
        intercambiar(arr, i, indice_menor)


def bubble_sort(arr):
    """Ordena el arreglo usando Bubble Sort."""
    for i in range(len(arr) - 1):
        for j in range(len(arr) - i - 1):
            if arr[j] > arr[j + 1]:
                intercambiar(arr, j, j + 1)


def encontrar_maximo(arr):
    """Encuentra el valor máximo del arreglo."""
    maximo = arr[0]
    for num in arr:
        if num > maximo:
            maximo = num
    return maximo


def counting_sort(arr):
    """Ordena el arreglo usando Counting Sort."""
    maximo = encontrar_maximo(arr)
    conteo = [0] * (maximo + 1)

    for num in arr:
        conteo[num] += 1

    index = 0
    for i in range(len(conteo)):
        while conteo[i] > 0:
            arr[index] = i
            index += 1
            conteo[i] -= 1


def merge_sort(arr):
    """Ordena el arreglo usando Merge Sort."""
    if len(arr) < 2:
        return

    mitad = len(arr) // 2
    izq = arr[:mitad]
    der = arr[mitad:]

    merge_sort(izq)
    merge_sort(der)
    mezclar(izq, der, arr)


def mezclar(izq, der, resultado):
    """Mezcla dos arreglos ordenados."""
    i = j = k = 0

    while i < len(izq) and j < len(der):
        if izq[i] <= der[j]:
            resultado[k] = izq[i]
            i += 1
        else:
            resultado[k] = der[j]
            j += 1
        k += 1

    while i < len(izq):
        resultado[k] = izq[i]
        i += 1
        k += 1

    while j < len(der):
        resultado[k] = der[j]
        j += 1
        k += 1


def quick_sort(arr):
    """Ordena el arreglo usando Quick Sort."""
    quick_sort_aux(arr, 0, len(arr) - 1)


def quick_sort_aux(arr, inicio, fin):
    if inicio < fin:
        pivote = particionar(arr, inicio, fin)
        quick_sort_aux(arr, inicio, pivote - 1)
        quick_sort_aux(arr, pivote + 1, fin)


def particionar(arr, inicio, fin):
    pivote = arr[fin]
    i = inicio - 1

    for j in range(inicio, fin):
        if arr[j] <= pivote:
            i += 1
            intercambiar(arr, i, j)

    intercambiar(arr, i + 1, fin)
    return i + 1

def main():
    n = int(input("Tamaño del arreglo: "))
    arr = [random.randint(0, 99) for _ in range(n)]

    print("Arreglo original:")
    print(arr)

    print("Elige el algoritmo:\n")
    print("    1.- Insertion Sort")
    print("    2.- Selection Sort")
    print("    3.- Bubble Sort")
    print("    4.- Counting Sort")
    print("    5.- Merge Sort")
    print("    6.- Quick Sort")

    opcion = int(input("\nRespuesta: "))

    if opcion == 1: insertion_sort(arr)
    elif opcion == 2: selection_sort(arr)
    elif opcion == 3: bubble_sort(arr)
    elif opcion == 4: counting_sort(arr)
    elif opcion == 5: merge_sort(arr)
    elif opcion == 6: quick_sort(arr)
    else: print("Opción inválida")

    print("Arreglo ordenado:")
    print(arr)


if __name__ == "__main__":
    main()