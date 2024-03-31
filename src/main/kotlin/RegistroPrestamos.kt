package org.example

interface IGestorPrestamos {
    fun registrarPrestamo(libro: Libro, usuario: Usuario)
    fun devolverLibro(libro: Libro, usuario: Usuario)
    // Métodos adicionales según sea necesario
}

class RegistroPrestamos : IGestorPrestamos{
    private val prestamosActuales = mutableListOf<Libro>()
    private val historialPrestamos = mutableListOf<Pair<Libro, Usuario>>()

    override fun registrarPrestamo(libro: Libro, usuario: Usuario) {
        prestamosActuales.add(libro)
        historialPrestamos.add(libro to usuario)
        usuario.agregarLibroPrestado(libro)
    }

    override fun devolverLibro(libro: Libro, usuario: Usuario) {
        prestamosActuales.remove(libro)
        usuario.quitarLibroPrestado(libro)
    }

    fun historialDeUnLibro(libro: Libro): List<Pair<Libro, Usuario>> = historialPrestamos.filter { it.first == libro }

    fun historialDeUnUsuario(usuario: Usuario): List<Libro> = usuario.librosPrestados()
}
