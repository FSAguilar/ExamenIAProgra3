package com.example.exameniaprogra3

abstract class Producto(
    val id: Int,
    val nombre: String,
    val precio: Double,
    val stock: Int
) {
    init {
        require(precio >= 0) { "El precio no puede ser negativo" }
        require(stock >= 0) { "El stock no puede ser negativo" }
    }

    fun estaDisponible(): Boolean = stock > 0

    fun precioConDescuento(porcentaje: Double): Double {
        require(porcentaje in 0.0..100.0) { "El descuento debe estar entre 0 y 100" }
        return precio * (1 - porcentaje / 100)
    }

    abstract fun obtenerDescripcion(): String
}
