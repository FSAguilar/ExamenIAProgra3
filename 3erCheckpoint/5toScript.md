# Checkpoint 5 — Implementación de interfaces con Jetpack Compose

Actúa como un desarrollador Android senior especializado en Kotlin, Jetpack Compose, Material 3 y arquitectura de software.

Estoy desarrollando una aplicación Android de **Librería** para mi primer parcial de Programación III.

Tu tarea es completar exclusivamente el **Checkpoint 5 — Interfaz (20 puntos)**, cuya consigna es:

"Construye dos pantallas utilizando Jetpack Compose que permita visualizar información de al menos dos de los objetos implementados."

## 1. Analizar el proyecto existente

Antes de implementar:

- Inspecciona la estructura actual del proyecto.
- Revisa las clases Kotlin implementadas en checkpoints anteriores (`Producto`, `Libro`, `Cuaderno`, `Catalogo`).
- Revisa las dependencias, configuración de Gradle y `MainActivity`.
- No recrees clases ni funcionalidades que ya existen.

## 2. Utilizar los diseños del Checkpoint 4

En la carpeta `./4toCheckpoint/` se encuentran:

- Imágenes de referencia de las dos pantallas.
- Descripción de los componentes de Jetpack Compose que deben utilizarse.

**Es obligatorio revisar todos estos archivos antes de escribir código.**

Las imágenes son la referencia visual principal. Implementa las pantallas respetando lo más fielmente posible su diseño original:

- Distribución y posición de los elementos.
- Colores, tamaños y espaciados.
- Tipografía y jerarquía visual.
- Tarjetas, íconos y barras de navegación.
- Componentes descritos en la documentación.

No inventes un diseño alternativo. Si existe alguna diferencia entre las imágenes y las descripciones, prioriza las imágenes para el aspecto visual y utiliza la documentación para determinar los componentes y el comportamiento esperado.

## 3. Implementar las dos pantallas

**Pantalla 1 — Libros**

- Mostrar una lista de objetos `Libro`.
- Visualizar sus atributos relevantes: nombre, autor, género, precio y stock.
- Utilizar los componentes de Jetpack Compose definidos en el Checkpoint 4.

**Pantalla 2 — Cuadernos**

- Mostrar una lista de objetos `Cuaderno`.
- Visualizar sus atributos relevantes: nombre, número de hojas, tipo de rayado, precio y stock.
- Mantener coherencia visual con la primera pantalla.

Ambas pantallas deben utilizar datos reales de las clases Kotlin existentes, no simplemente textos estáticos simulando objetos.

Si todavía no existen datos iniciales, crea una pequeña colección de productos de ejemplo utilizando las clases implementadas.

## 4. Navegación y componentes

- Implementa la navegación entre ambas pantallas según el diseño del Checkpoint 4.
- Utiliza Jetpack Compose y Material 3.
- Reutiliza componentes cuando tengan una estructura similar, evitando duplicar código.
- Utiliza `LazyColumn` para presentar los productos.
- Gestiona correctamente el estado de la interfaz con `remember` o `rememberSaveable`, según corresponda.
- Implementa únicamente las interacciones representadas o descritas en los archivos del Checkpoint 4.
- Mantén la lógica de datos separada de los componentes visuales.

## 5. Restricciones

- Trabaja directamente sobre el proyecto existente.
- No crees un proyecto Android nuevo.
- No modifiques innecesariamente las clases de dominio.
- No agregues bases de datos, APIs ni autenticación.
- No implementes características ajenas a los diseños proporcionados.
- No generes documentación adicional.
- No modifiques los archivos de `./4toCheckpoint/`.
- No avances al Checkpoint 6.
- No hagas commits ni `git push`.

## 6. Verificación

Al terminar:

1. Comprueba que ambas pantallas utilicen correctamente los objetos del modelo.
2. Revisa que la navegación funcione.
3. Verifica que no existan errores evidentes de compilación.
4. Ejecuta una compilación con Gradle si el entorno lo permite.
5. Comprueba que no se hayan introducido cambios innecesarios en otros archivos.

## Resultado esperado

Las dos pantallas del Checkpoint 4 implementadas en Kotlin con Jetpack Compose, visualmente fieles a las imágenes de `./4toCheckpoint/`, utilizando las clases del proyecto y con navegación funcional.

Al finalizar, proporciona un resumen breve de los archivos modificados, las funcionalidades implementadas y el resultado de la compilación.
