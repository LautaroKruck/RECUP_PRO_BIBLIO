package org.example

class Catalogo {
    val libros = mutableListOf<Libro>()

    fun agregarLibro(libro: Libro) {
        libros.add(libro)
    }

    fun eliminarLibro(id: String) {
        libros.removeIf { it.id == id }
    }

    fun buscarLibro(id: String): Libro? {
        return libros.find { it.id == id }
    }

    fun librosPorEstado(estado: EstadoLibro): List<Libro> {
        return libros.filter { it.estado == estado }
    }

    fun todosLosLibros(): List<Libro> {
        return libros.toList()
    }
}
