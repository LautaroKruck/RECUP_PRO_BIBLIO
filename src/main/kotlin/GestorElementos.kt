package org.example

class GestorElementos<T: ElementoBiblioteca> {
    val elementos = mutableListOf<T>()

    fun agregarElemento(elemento: T) {
        elementos.add(elemento)
    }

    fun eliminarElementoPorId(id: String) {
        elementos.removeIf { it.id == id }
    }

    fun buscarElementoPorId(id: String): T? {
        return elementos.find { it.id == id }
    }

    fun elementosPorEstado(estado: EstadoLibro): List<T> {
        return elementos.filter { it.estado == estado }
    }

    fun todosLosElementos(): List<T> {
        return elementos.toList()
    }
}

