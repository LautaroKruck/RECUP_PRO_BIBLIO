package org.example

fun main() {
    val gestor = GestorBiblioteca()

    gestor.agregarLibro(Libro("1", "Libro Uno", "Autor Uno", 2020, "Ficción"))
    gestor.agregarLibro(Libro("2", "Libro Dos", "Autor Dos", 2018, "Ciencia Ficción"))
    gestor.agregarLibro(Libro("3", "Libro Tres", "Autor Tres", 2021, "Historia"))

    // Hacer préstamos
    gestor.registrarPrestamo("1")
    gestor.registrarPrestamo("1") // Va a dar error porque ya está prestado

    // Devoluciones
    gestor.devolverLibro("1")
    gestor.devolverLibro("1") // Va a dar error porque ya está devuelto

    // Consultar disponibilidad
    println("Estado de 'Libro Uno': ${gestor.consultarDisponibilidad("1")}")

}
