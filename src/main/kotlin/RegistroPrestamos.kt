package org.example

interface IGestorPrestamos {
    fun registrarPrestamo(elemento: ElementoBiblioteca, usuario: Usuario)
    fun devolverLibro(elemento: ElementoBiblioteca, usuario: Usuario)
}

class RegistroPrestamos : IGestorPrestamos {
    private val prestamosActuales = mutableListOf<Pair<ElementoBiblioteca, Usuario>>()

    override fun registrarPrestamo(elemento: ElementoBiblioteca, usuario: Usuario) {
        if (elemento.estado == EstadoLibro.DISPONIBLE) {
            elemento.estado = EstadoLibro.PRESTADO
            prestamosActuales.add(elemento to usuario)
        }
    }

    override fun devolverLibro(elemento: ElementoBiblioteca, usuario: Usuario) {
        if (elemento.estado == EstadoLibro.PRESTADO) {
            elemento.estado = EstadoLibro.DISPONIBLE
            prestamosActuales.removeIf { it.first == elemento && it.second == usuario }
        }
    }
}
