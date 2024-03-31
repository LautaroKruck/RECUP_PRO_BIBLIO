package org.example

class GestorBiblioteca {
    private val catalogo = Catalogo()
    private val registroPrestamos = mutableListOf<Libro>()

    fun agregarLibro(libro: Libro) {
        catalogo.agregarLibro(libro)
    }

    fun eliminarLibro(id: String) {
        catalogo.eliminarLibro(id)
    }

    fun registrarPrestamo(id: String) {
        val libro = catalogo.buscarLibro(id)
        if (libro != null && libro.estado == "disponible") {
            libro.estado = "prestado"
            registroPrestamos.add(libro)
        }
    }

    fun devolverLibro(id: String) {
        val libro = registroPrestamos.find { it.id == id }
        libro?.let {
            it.estado = "disponible"
            registroPrestamos.remove(it)
        }
    }

    fun consultarDisponibilidad(id: String): String {
        return catalogo.buscarLibro(id)?.estado ?: "Libro no encontrado"
    }

    fun librosPorEstado(estado: String): List<Libro> {
        return catalogo.librosPorEstado(estado)
    }
}
