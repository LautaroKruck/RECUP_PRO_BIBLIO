package org.example

class GestorBiblioteca(private val catalogo: Catalogo, private val gestorPrestamos: IGestorPrestamos) {
    private val usuarios = mutableListOf<Usuario>()

    fun agregarElemento(elemento: ElementoBiblioteca) = catalogo.agregarElemento(elemento)

    fun registrarPrestamo(idElemento: String, idUsuario: String) {
        val elemento = catalogo.buscarElementoPorId(idElemento)
        val usuario = usuarios.find { it.id == idUsuario }

        if (elemento != null && usuario != null && elemento is Prestable) {
            gestorPrestamos.registrarPrestamo(elemento, usuario)
        }
    }

    fun devolverElemento(idElemento: String, idUsuario: String) {
        val elemento = catalogo.buscarElementoPorId(idElemento)
        val usuario = usuarios.find { it.id == idUsuario }

        if (elemento != null && usuario != null && elemento is Prestable) {
            gestorPrestamos.devolverLibro(elemento, usuario)
        }
    }

    fun mostrarTodosLosElementos() = catalogo.todosLosElementos().forEach { println(it.consultarDatos()) }

    fun registrarUsuario(usuario: Usuario) = usuarios.add(usuario)
}