package org.example

class Libro(
    val id: String,
    val titulo: String,
    val autor: String,
    val añoPublicacion: Int,
    val tematica: String,
    var estado: String = "disponible"
) {
    init {
        require(titulo.isNotEmpty()) { "El título no puede estar vacío" }
        require(autor.isNotEmpty()) { "El autor no puede estar vacío" }
        require(tematica.isNotEmpty()) { "La temática no puede estar vacía" }
    }
}
