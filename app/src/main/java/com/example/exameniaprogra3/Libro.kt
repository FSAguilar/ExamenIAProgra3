package com.example.exameniaprogra3

class Libro(
    id: Int,
    nombre: String,
    precio: Double,
    stock: Int,
    val autor: String,
    val isbn: String,
    val genero: String
) : Producto(id, nombre, precio, stock) {
    override fun obtenerDescripcion(): String =
        "Libro: $nombre, autor: $autor, ISBN: $isbn, genero: $genero"
}
