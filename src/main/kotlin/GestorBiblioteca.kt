package org.example

class GestorBiblioteca(private val catalogo: Catalogo, private val gestorPrestamos: IGestorPrestamos) {
    private val usuarios = mutableListOf<Usuario>()
    private val registroPrestamos = RegistroPrestamos()

    fun agregarLibro(titulo: String, autor: String, añoPublicacion: Int, tematica: String) {
        val idUnico = UtilidadesBiblioteca.generarIdentificadorUnico()
        val nuevoLibro = Libro(idUnico, titulo, autor, añoPublicacion, tematica)
        catalogo.agregarLibro(nuevoLibro)
    }

    fun eliminarLibro(id: String) {
        catalogo.eliminarLibro(id)
    }

    fun registrarPrestamo(idLibro: String, idUsuario: String) {
        val libro = catalogo.buscarLibro(idLibro)
        val usuario = usuarios.find { it.id == idUsuario }

        if (libro != null && usuario != null && libro.estado == EstadoLibro.DISPONIBLE) {
            libro.prestar()
            registroPrestamos.registrarPrestamo(libro, usuario) // Asumiendo que este método ya está implementado para manejar el registro
        } else {
            println("No se puede registrar el préstamo.")
        }
    }

    fun registrarUsuario(usuario: Usuario) {
        usuarios.add(usuario)
    }

    fun prestarLibro(libro: Libro, usuario: Usuario) {
        if (libro.estaDisponible()) {
            registroPrestamos.registrarPrestamo(libro, usuario)
            libro.prestar()
        }
    }

    fun devolverLibro(libro: Libro, usuario: Usuario) {
        registroPrestamos.devolverLibro(libro, usuario)
        libro.devolver()
    }

    fun consultarDisponibilidad(id: String): String {
        val libro = catalogo.buscarLibro(id)
        return libro?.estado?.descripcion ?: "Libro no encontrado"
    }


    fun librosPorEstado(estado: EstadoLibro): List<Libro> {
        return catalogo.librosPorEstado(estado)
    }

    fun todosLosLibros() {
        catalogo.todosLosLibros().forEach { libro ->
            println(libro.consultarDatos())
        }
    }

}
