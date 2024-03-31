package org.example

class Libro(id: String, titulo: String, private val autor: String, private val añoPublicacion: Int, private val tematica: String, estado: EstadoLibro = EstadoLibro.DISPONIBLE) : ElementoBiblioteca(id, titulo, estado), Prestable {

    init {
        require(titulo.isNotEmpty()) { "El título no puede estar vacío" }
        require(autor.isNotEmpty()) { "El autor no puede estar vacío" }
        require(tematica.isNotEmpty()) { "La temática no puede estar vacía" }
    }

    fun estaDisponible() = estado == EstadoLibro.DISPONIBLE

    override fun prestar() {
        if (estado == EstadoLibro.DISPONIBLE) {
            estado = EstadoLibro.PRESTADO
        }
    }

    override fun devolver() {
        estado = EstadoLibro.DISPONIBLE
    }

    fun consultarDatos(): String = "ID: $id, Título: $titulo, Autor: $autor, Año: $añoPublicacion, Temática: $tematica, Estado: ${estado.descripcion}"

}