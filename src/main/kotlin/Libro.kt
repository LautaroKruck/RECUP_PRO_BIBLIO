package org.example

class Libro(override val id: String, override val titulo: String, val autor: String, val añoPublicacion: Int, val tematica: String, estado: EstadoLibro = EstadoLibro.DISPONIBLE) : ElementoBiblioteca(id, titulo, estado), Prestable {

    override fun prestar() {
        if (estado == EstadoLibro.DISPONIBLE) estado = EstadoLibro.PRESTADO
    }

    override fun devolver() {
        estado = EstadoLibro.DISPONIBLE
    }

    fun consultarDatos(): String = "Libro: $titulo, Autor: $autor, Año: $añoPublicacion, Temática: $tematica, Estado: ${estado.name}"
}