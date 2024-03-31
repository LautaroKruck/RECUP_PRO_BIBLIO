package org.example

class GestorBiblioteca(private val catalogo: Catalogo, private val registroPrestamos: RegistroPrestamos) {
    private val usuarios = mutableListOf<Usuario>()

    fun agregarLibro(libro: Libro) {
        catalogo.agregarLibro(libro)
    }

    fun eliminarLibroPorId(id: String) {
        catalogo.eliminarLibroPorId(id)
    }

    fun registrarUsuario(usuario: Usuario) {
        usuarios.add(usuario)
    }

    fun registrarPrestamo(idLibro: String, idUsuario: String) {
        val libro = catalogo.buscarLibroPorId(idLibro)
        val usuario = usuarios.find { it.id == idUsuario }

        if (libro != null && usuario != null && libro.estado == EstadoLibro.DISPONIBLE) {
            libro.prestar()
            registroPrestamos.registrarPrestamo(libro, usuario)
            println("Prestamo registrado para el libro '${libro.titulo}' al usuario ${usuario.nombre}")
        } else {
            println("No se puede registrar el préstamo. El libro puede no estar disponible o no existir.")
        }
    }

    fun devolverLibro(idLibro: String, idUsuario: String) {
        val libro = catalogo.buscarLibroPorId(idLibro)
        val usuario = usuarios.find { it.id == idUsuario }

        if (libro != null && usuario != null && libro.estado == EstadoLibro.PRESTADO) {
            libro.devolver()
            registroPrestamos.devolverLibro(libro, usuario)
            println("Libro '${libro.titulo}' devuelto por ${usuario.nombre}")
        } else {
            println("No se puede devolver el libro. El libro puede no estar prestado o no existir.")
        }
    }

    fun mostrarTodosLosLibros() {
        println("Catálogo completo de libros:")
        catalogo.todosLosLibros().forEach { libro ->
            println(libro.consultarDatos())
        }
    }
}
