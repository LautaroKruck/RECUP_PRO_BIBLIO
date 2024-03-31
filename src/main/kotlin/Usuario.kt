package org.example

class Usuario(val id: String, val nombre: String) {
    private val librosPrestados = mutableListOf<Libro>()

    fun agregarLibroPrestado(libro: Libro) {
        librosPrestados.add(libro)
    }

    fun quitarLibroPrestado(libro: Libro) {
        librosPrestados.remove(libro)
    }

    fun librosPrestados(): List<Libro> = librosPrestados
}
