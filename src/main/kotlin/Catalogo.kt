package org.example

class Catalogo {
    private val gestorLibros = GestorElementos<Libro>()

    fun agregarLibro(libro: Libro) = gestorLibros.agregarElemento(libro)

    fun eliminarLibroPorId(id: String) = gestorLibros.eliminarElementoPorId(id)

    fun buscarLibroPorId(id: String): Libro? = gestorLibros.buscarElementoPorId(id)

    fun librosPorEstado(estado: EstadoLibro): List<Libro> = gestorLibros.elementosPorEstado(estado)

    fun todosLosLibros(): List<Libro> = gestorLibros.todosLosElementos()
}

