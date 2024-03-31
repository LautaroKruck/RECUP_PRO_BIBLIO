package org.example

class Catalogo {
    private val elementos = mutableListOf<ElementoBiblioteca>()

    fun agregarElemento(elemento: ElementoBiblioteca) {
        elementos.add(elemento)
    }

    fun eliminarElemento(id: String) {
        elementos.removeIf { it.id == id }
    }

    fun buscarElementoPorId(id: String): ElementoBiblioteca? {
        return elementos.find { it.id == id }
    }

    fun elementosPorEstado(estado: EstadoLibro): List<ElementoBiblioteca> {
        return elementos.filter { it.estado == estado }
    }

    fun todosLosElementos(): List<ElementoBiblioteca> {
        return elementos.toList()
    }
}

