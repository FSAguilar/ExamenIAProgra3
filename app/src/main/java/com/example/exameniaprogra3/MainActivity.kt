package com.example.exameniaprogra3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AutoStories
import androidx.compose.material.icons.outlined.EditNote
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.exameniaprogra3.ui.theme.ExamenIAProgra3Theme

private val Fondo = Color(0xFF303030)
private val Borde = Color(0xFF555555)
private val TextoSecundario = Color(0xFFD6D6D6)
private val Azul = Color(0xFF28598A)
private val Verde = Color(0xFF00C853)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ExamenIAProgra3Theme(darkTheme = true, dynamicColor = false) {
                LibreriaApp()
            }
        }
    }
}

@Composable
private fun LibreriaApp() {
    val catalogo = remember { crearCatalogoEjemplo() }
    var mostrarLibros by rememberSaveable { mutableStateOf(true) }
    var busqueda by rememberSaveable { mutableStateOf("") }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = Fondo,
        bottomBar = {
            NavegacionInferior(
                mostrarLibros = mostrarLibros,
                alSeleccionar = {
                    mostrarLibros = it
                    busqueda = ""
                }
            )
        }
    ) { padding ->
        if (mostrarLibros) {
            PantallaProductos(
                titulo = "Libros disponibles",
                productos = catalogo.obtenerLibros(),
                busqueda = busqueda,
                alCambiarBusqueda = { busqueda = it },
                detalles = { listOf(it.autor, it.genero) },
                iconos = listOf("📘", "📗", "📕"),
                modifier = Modifier.padding(padding)
            )
        } else {
            PantallaProductos(
                titulo = "Cuadernos disponibles",
                productos = catalogo.obtenerCuadernos(),
                busqueda = busqueda,
                alCambiarBusqueda = { busqueda = it },
                detalles = { listOf("${it.numeroHojas} hojas", it.tipoRayado) },
                iconos = listOf("📓", "📒", "📔"),
                modifier = Modifier.padding(padding)
            )
        }
    }
}

@Composable
private fun <T : Producto> PantallaProductos(
    titulo: String,
    productos: List<T>,
    busqueda: String,
    alCambiarBusqueda: (String) -> Unit,
    detalles: (T) -> List<String>,
    iconos: List<String>,
    modifier: Modifier = Modifier
) {
    val resultados = productos.filter { it.nombre.contains(busqueda, ignoreCase = true) }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp, vertical = 16.dp)
    ) {
        Encabezado()
        Spacer(Modifier.height(18.dp))
        Text(titulo, color = Color.White, fontSize = 21.sp, fontWeight = FontWeight.Bold)
        Spacer(Modifier.height(4.dp))
        Text("Explora nuestro catálogo", color = TextoSecundario, fontSize = 14.sp)
        Spacer(Modifier.height(14.dp))
        OutlinedTextField(
            value = busqueda,
            onValueChange = alCambiarBusqueda,
            modifier = Modifier.fillMaxWidth(),
            placeholder = { Text("Buscar producto...") },
            leadingIcon = { Icon(Icons.Outlined.Search, contentDescription = null) },
            singleLine = true,
            shape = RoundedCornerShape(14.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedTextColor = Color.White,
                unfocusedTextColor = Color.White,
                focusedBorderColor = Color(0xFF777777),
                unfocusedBorderColor = Borde,
                focusedLeadingIconColor = TextoSecundario,
                unfocusedLeadingIconColor = TextoSecundario,
                focusedPlaceholderColor = Color(0xFFBDBDBD),
                unfocusedPlaceholderColor = Color(0xFFBDBDBD)
            )
        )
        Spacer(Modifier.height(16.dp))
        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            Text("Productos", color = Color.White, fontSize = 16.sp)
            Text("${resultados.size} resultados", color = TextoSecundario, fontSize = 13.sp)
        }
        Spacer(Modifier.height(14.dp))
        LazyColumn(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.spacedBy(9.dp)
        ) {
            items(resultados, key = { it.id }) { producto ->
                val indice = productos.indexOf(producto)
                TarjetaProducto(
                    producto = producto,
                    detalles = detalles(producto),
                    icono = iconos[indice % iconos.size]
                )
            }
        }
    }
}

@Composable
private fun Encabezado() {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Box(
            modifier = Modifier
                .size(38.dp)
                .clip(RoundedCornerShape(12.dp))
                .background(Azul),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = Icons.Outlined.AutoStories,
                contentDescription = null,
                tint = Color.White,
                modifier = Modifier.size(22.dp)
            )
        }
        Spacer(Modifier.width(10.dp))
        Column {
            Text("Mi Librería", color = Color.White, fontSize = 22.sp, fontWeight = FontWeight.Bold)
            Text("Catálogo de productos", color = TextoSecundario, fontSize = 14.sp)
        }
    }
}

@Composable
private fun TarjetaProducto(producto: Producto, detalles: List<String>, icono: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(116.dp)
            .border(1.dp, Borde, RoundedCornerShape(18.dp)),
        shape = RoundedCornerShape(18.dp),
        colors = CardDefaults.cardColors(containerColor = Fondo)
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(width = 74.dp, height = 86.dp)
                    .clip(RoundedCornerShape(13.dp))
                    .background(Color.Black),
                contentAlignment = Alignment.Center
            ) {
                Text(icono, fontSize = 30.sp)
            }
            Spacer(Modifier.width(12.dp))
            Column(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight(),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Column(verticalArrangement = Arrangement.spacedBy(2.dp)) {
                    Text(producto.nombre, color = Color.White, fontSize = 16.sp)
                    detalles.forEach { Text(it, color = TextoSecundario, fontSize = 13.sp) }
                }
                Text(formatearPrecio(producto.precio), color = Color.White, fontSize = 18.sp)
            }
            Text(
                text = "Stock: ${producto.stock}",
                color = Verde,
                fontSize = 10.sp,
                modifier = Modifier.align(Alignment.Bottom)
            )
        }
    }
}

@Composable
private fun NavegacionInferior(mostrarLibros: Boolean, alSeleccionar: (Boolean) -> Unit) {
    Column(modifier = Modifier.background(Fondo)) {
        HorizontalDivider(color = Borde, thickness = 1.dp, modifier = Modifier.padding(horizontal = 16.dp))
        NavigationBar(containerColor = Fondo) {
            NavigationBarItem(
                selected = mostrarLibros,
                onClick = { alSeleccionar(true) },
                icon = { Icon(Icons.Outlined.AutoStories, contentDescription = null) },
                label = { Text("Libros") },
                colors = coloresNavegacion()
            )
            NavigationBarItem(
                selected = !mostrarLibros,
                onClick = { alSeleccionar(false) },
                icon = { Icon(Icons.Outlined.EditNote, contentDescription = null) },
                label = { Text("Cuadernos") },
                colors = coloresNavegacion()
            )
        }
    }
}

@Composable
private fun coloresNavegacion() = NavigationBarItemDefaults.colors(
    selectedIconColor = Color.White,
    selectedTextColor = Color.White,
    unselectedIconColor = Color(0xFFBDBDBD),
    unselectedTextColor = Color(0xFFBDBDBD),
    indicatorColor = Color.Transparent
)

private fun crearCatalogoEjemplo() = Catalogo().apply {
    agregarProducto(Libro(1, "Clean Code", 160.0, 8, "Robert C. Martin", "9780132350884", "Programación"))
    agregarProducto(Libro(2, "El principito", 55.0, 12, "Antoine de Saint-Exupéry", "9780156012195", "Literatura"))
    agregarProducto(Libro(3, "1984", 90.0, 4, "George Orwell", "9780451524935", "Ciencia ficción"))
    agregarProducto(Cuaderno(4, "Cuaderno A4", 25.0, 15, 100, "Cuadriculado"))
    agregarProducto(Cuaderno(5, "Universitario", 35.0, 10, 200, "Rayado"))
    agregarProducto(Cuaderno(6, "Cuaderno espiral", 18.0, 20, 80, "Liso"))
}

private fun formatearPrecio(precio: Double): String =
    if (precio % 1 == 0.0) "Bs ${precio.toInt()}" else "Bs $precio"

@Preview(showBackground = true, backgroundColor = 0xFF303030)
@Composable
private fun LibreriaPreview() {
    ExamenIAProgra3Theme(darkTheme = true, dynamicColor = false) {
        LibreriaApp()
    }
}
