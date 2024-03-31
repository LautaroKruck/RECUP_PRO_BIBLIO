package org.example

class GestorBiblioteca {
    private val catalogo = Catalogo()
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

    fun registrarPrestamo(id: String) {
        val libro = catalogo.buscarLibro(id)
        if (libro != null && libro.estado == "disponible") {
            libro.estado = "prestado"
            registroPrestamos.add(libro)
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
        return catalogo.buscarLibro(id)?.estado ?: "Libro no encontrado"
    }

    fun librosPorEstado(estado: String): List<Libro> {
        return catalogo.librosPorEstado(estado)
    }

    fun todosLosLibros() {
        catalogo.todosLosLibros().forEach { libro ->
            println("ID: ${libro.id}, Título: ${libro.titulo}, Autor: ${libro.autor}, Año: ${libro.añoPublicacion}, Temática: ${libro.tematica}, Estado: ${libro.estado}")
        }
    }
}
