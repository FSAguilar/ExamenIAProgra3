package com.example.exameniaprogra3

class Cuaderno(
    id: Int,
    nombre: String,
    precio: Double,
    stock: Int,
    val numeroHojas: Int,
    val tipoRayado: String
) : Producto(id, nombre, precio, stock) {
    override fun obtenerDescripcion(): String =
        "Cuaderno: $nombre, hojas: $numeroHojas, rayado: $tipoRayado"
}
