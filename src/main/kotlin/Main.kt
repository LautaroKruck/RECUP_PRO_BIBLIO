package org.example

fun main() {
    // Inicialización de las clases principales
    val catalogo = Catalogo()
    val registroPrestamos = RegistroPrestamos() // Asumiendo que tiene una implementación adecuada
    val gestorBiblioteca = GestorBiblioteca(catalogo, registroPrestamos)

    // Registrar algunos usuarios
    val usuario1 = Usuario("U1", "Juan Pérez")
    val usuario2 = Usuario("U2", "Ana López")
    gestorBiblioteca.registrarUsuario(usuario1)
    gestorBiblioteca.registrarUsuario(usuario2)

    // Crear y agregar algunos libros al catálogo
    val libro1 = Libro("1", "Don Quijote de la Mancha", "Miguel de Cervantes", 1605, "Novela", EstadoLibro.DISPONIBLE)
    val libro2 = Libro("2", "Cien años de soledad", "Gabriel García Márquez", 1967, "Realismo mágico", EstadoLibro.DISPONIBLE)

    gestorBiblioteca.agregarLibro(libro1)
    gestorBiblioteca.agregarLibro(libro2)

    // Mostrar todos los libros en el catálogo
    println("Todos los libros en el catálogo antes de los préstamos:")
    gestorBiblioteca.mostrarTodosLosLibros()

    // Realizar un préstamo
    println("\nRealizando préstamos...")
    gestorBiblioteca.registrarPrestamo(libro1.id, usuario1.id)
    gestorBiblioteca.registrarPrestamo(libro2.id, usuario2.id)

    // Mostrar todos los libros en el catálogo después de los préstamos
    println("\nTodos los libros en el catálogo después de los préstamos:")
    gestorBiblioteca.mostrarTodosLosLibros()

    // Devolver un libro
    println("\nDevolviendo un libro...")
    gestorBiblioteca.devolverLibro(libro1.id, usuario1.id)

    // Estado final de todos los libros en el catálogo
    println("\nEstado final de todos los libros después de las devoluciones:")
    gestorBiblioteca.mostrarTodosLosLibros()
}
