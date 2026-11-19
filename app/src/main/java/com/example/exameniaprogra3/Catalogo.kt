package com.example.exameniaprogra3

class Catalogo {
    private val productos = mutableListOf<Producto>()

    fun agregarProducto(producto: Producto) {
        require(buscarPorId(producto.id) == null) { "Ya existe un producto con el id ${producto.id}" }
        productos.add(producto)
    }

    fun obtenerLibros(): List<Libro> = productos.filterIsInstance<Libro>()

    fun obtenerCuadernos(): List<Cuaderno> = productos.filterIsInstance<Cuaderno>()

    fun buscarPorId(id: Int): Producto? = productos.find { it.id == id }
}
