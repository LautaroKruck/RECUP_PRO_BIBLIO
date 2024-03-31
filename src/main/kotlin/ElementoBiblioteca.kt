package org.example

abstract class ElementoBiblioteca(val id: String, val titulo: String, var estado: EstadoLibro)

interface Prestable {
    fun prestar()
    fun devolver()
}
