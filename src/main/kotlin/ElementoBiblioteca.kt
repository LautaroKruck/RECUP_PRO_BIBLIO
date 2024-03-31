
package org.example

abstract class ElementoBiblioteca(open val id: String, open val titulo: String, var estado: EstadoLibro)

interface Prestable {
    fun prestar()
    fun devolver()
}
