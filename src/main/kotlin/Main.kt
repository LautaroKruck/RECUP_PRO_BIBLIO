package org.example

fun main() {
    val gestor = GestorBiblioteca()

    // Agregar libros al catálogo, ahora con identificadores únicos generados automáticamente.
    gestor.agregarLibro("Don Quijote de la Mancha", "Miguel de Cervantes", 1605, "Novela")
    gestor.agregarLibro("Cien años de soledad", "Gabriel García Márquez", 1967, "Realismo mágico")
    gestor.agregarLibro("La odisea", "Homero", -800, "Épica")

    // Mostrar el estado actual de los libros con sus ID únicos.
    gestor.todosLosLibros()

    // Consultar disponibilidad
    println("Estado de 'Libro Uno': ${gestor.consultarDisponibilidad("1")}")
}