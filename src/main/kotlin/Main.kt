package org.example

fun main() {
    // Instanciar las dependencias
    val catalogo = Catalogo()
    val registroPrestamos = RegistroPrestamos()
    val gestorBiblioteca = GestorBiblioteca(catalogo, registroPrestamos)

    // Crear y agregar algunos libros al catálogo
    gestorBiblioteca.agregarLibro("Don Quijote de la Mancha", "Miguel de Cervantes", 1605, "Novela")
    gestorBiblioteca.agregarLibro("Cien años de soledad", "Gabriel García Márquez", 1967, "Realismo mágico")
    gestorBiblioteca.agregarLibro("La odisea", "Homero", -800, "Épica")

    // Registrar usuarios
    val usuario1 = Usuario("U1", "Juan Pérez")
    val usuario2 = Usuario("U2", "Ana López")
    gestorBiblioteca.registrarUsuario(usuario1)
    gestorBiblioteca.registrarUsuario(usuario2)

    // Mostrar todos los libros antes de los préstamos
    println("Libros en el catálogo antes de los préstamos:")
    gestorBiblioteca.todosLosLibros()

    // Realizar algunos préstamos
    println("\nRealizando préstamos...")
    gestorBiblioteca.registrarPrestamo(catalogo.libros[0].id, usuario1.id) // Asume que el ID de libro es accesible y correcto.
    gestorBiblioteca.registrarPrestamo(catalogo.libros[1].id, usuario2.id)

    // Mostrar todos los libros después de los préstamos
    println("\nLibros en el catálogo después de los préstamos:")
    gestorBiblioteca.todosLosLibros()


    // Mostrar el estado final de los libros
    println("\nEstado final de los libros después de las devoluciones:")
    gestorBiblioteca.todosLosLibros()
}
