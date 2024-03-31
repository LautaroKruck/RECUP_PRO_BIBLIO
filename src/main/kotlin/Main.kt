package org.example

fun main() {
    // Inicialización de las dependencias del sistema de gestión de la biblioteca
    val catalogo = Catalogo()
    val registroPrestamos = RegistroPrestamos()
    val gestorBiblioteca = GestorBiblioteca(catalogo, registroPrestamos)

    // Crear y agregar algunos elementos al catálogo
    val libro1 = Libro("1", "Don Quijote de la Mancha", "Miguel de Cervantes", 1605, "Novela", EstadoLibro.DISPONIBLE)
    val libro2 = Libro("2", "Cien años de soledad", "Gabriel García Márquez", 1967, "Realismo mágico", EstadoLibro.DISPONIBLE)

    gestorBiblioteca.agregarElemento(libro1)
    gestorBiblioteca.agregarElemento(libro2)

    // Registrar usuarios
    val usuario1 = Usuario("U1", "Juan Pérez")
    val usuario2 = Usuario("U2", "Ana López")
    gestorBiblioteca.registrarUsuario(usuario1)
    gestorBiblioteca.registrarUsuario(usuario2)

    // Realizar préstamos
    println("Realizando préstamos...")
    gestorBiblioteca.registrarPrestamo(libro1.id, usuario1.id)
    gestorBiblioteca.registrarPrestamo(libro2.id, usuario2.id)

    // Mostrar todos los elementos después de los préstamos
    println("\nElementos en el catálogo después de realizar los préstamos:")
    gestorBiblioteca.mostrarTodosLosElementos()

    // Devolver libros
    println("\nDevolviendo libros...")
    gestorBiblioteca.devolverElemento(libro1.id, usuario1.id)
    gestorBiblioteca.devolverElemento(libro2.id, usuario2.id)

    // Estado final de todos los elementos
    println("\nEstado final de todos los elementos después de las devoluciones:")
    gestorBiblioteca.mostrarTodosLosElementos()
}
