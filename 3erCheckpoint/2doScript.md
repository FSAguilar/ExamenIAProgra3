Implementa únicamente las clases Kotlin correspondientes al Checkpoint 1 de mi proyecto Android de **Librería**.

Utiliza la estructura de carpetas y paquetes que ya existe en el proyecto. No crees documentación, diagramas, archivos Markdown ni estructuras adicionales.

### Clases a implementar

**1. Producto (clase abstracta)**
- `id: Int`
- `nombre: String`
- `precio: Double`
- `stock: Int`
- `estaDisponible(): Boolean`
- `precioConDescuento(porcentaje: Double): Double`
- `obtenerDescripcion(): String` (abstracto)

**2. Libro (hereda de Producto)**
- `autor: String`
- `isbn: String`
- `genero: String`
- Sobrescribir `obtenerDescripcion()`.

**3. Cuaderno (hereda de Producto)**
- `numeroHojas: Int`
- `tipoRayado: String`
- Sobrescribir `obtenerDescripcion()`.

**4. Catalogo**
- Colección privada de productos: `MutableList<Producto>`.
- `agregarProducto(producto: Producto)`.
- `obtenerLibros(): List<Libro>`.
- `obtenerCuadernos(): List<Cuaderno>`.
- `buscarPorId(id: Int): Producto?`.

### Requisitos técnicos
- Utilizar Kotlin y aplicar correctamente los principios de POO: encapsulamiento, herencia, abstracción y polimorfismo.
- Utilizar `override`, `open`, `abstract` y modificadores de acceso cuando corresponda.
- Validar que el precio y el stock no sean negativos.
- Validar que los descuentos estén entre 0 y 100.
- Evitar identificadores de productos duplicados en el catálogo.
- Mantener el código limpio, sencillo y sin dependencias externas.
- No implementar interfaces Jetpack Compose, navegación ni bases de datos.
- No modificar archivos que no sean necesarios para implementar estas clases.

**Importante:** Trabaja directamente sobre mi proyecto existente. No crees un proyecto nuevo ni avances con otros checkpoints. No realices commits ni push.

Al finalizar, indica brevemente qué archivos modificaste o creaste.

