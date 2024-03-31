package org.example

class Libro(val id: String, private val titulo: String, private val autor: String, private val añoPublicacion: Int, private val tematica: String, var estado: EstadoLibro = EstadoLibro.DISPONIBLE) {

    init {
        require(titulo.isNotEmpty()) { "El título no puede estar vacío" }
        require(autor.isNotEmpty()) { "El autor no puede estar vacío" }
        require(tematica.isNotEmpty()) { "La temática no puede estar vacía" }
    }

    fun consultarDatos(): String = "ID: $id, Título: $titulo, Autor: $autor, Año: $añoPublicacion, Temática: $tematica, Estado: ${estado.descripcion}"

    fun estaDisponible() = estado == EstadoLibro.DISPONIBLE

    fun prestar() {
        if (estaDisponible()) estado = EstadoLibro.PRESTADO
    }

    fun devolver() {
        estado = EstadoLibro.DISPONIBLE
    }
}
