package rodriguez.kevin.introduccion2.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import rodriguez.kevin.introduccion2.ui.theme.Introduccion2Theme

// 1. EL PADRE (Stateful / Con estado)
// Es el "Jefe". Guarda los datos y acomoda a los hijos en la pantalla.
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FichaPersona() {
    // Aquí vive el ESTADO
    var nombre by remember { mutableStateOf("") }
    var ciudad by remember { mutableStateOf("") }
    var edad by remember { mutableStateOf("") }

    Scaffold(
        topBar = { TopAppBar(title = { Text("Ficha de Persona") }) }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp)
                .verticalScroll(rememberScrollState())
        ) {
            // Llamamos al Hijo 1 pasándole solo los datos para que los dibuje
            TarjetaPersona(nombre = nombre, ciudad = ciudad, edad = edad)
            
            Spacer(modifier = Modifier.height(24.dp)) // Espacio en blanco
            
            // Llamamos al Hijo 2 pasándole los datos actuales y las "órdenes" 
            // de qué hacer cuando el usuario escriba algo nuevo
            FormularioPersona(
                nombre = nombre,
                alCambiarNombre = { nuevoNombre -> nombre = nuevoNombre }, //funciones anonimas
                ciudad = ciudad,
                alCambiarCiudad = { nuevaCiudad -> ciudad = nuevaCiudad }, //funciones anonimas
                edad = edad,
                alCambiarEdad = { nuevaEdad -> edad = nuevaEdad }
            )
        }
    }
}

// 2. HIJO 1 (Stateless / Sin estado) - Solo visualización
// Es un "trabajador" que solo dibuja una tarjeta bonita con los textos que le den.
@Composable
fun TarjetaPersona(nombre: String, ciudad: String, edad: String) {
    Card(modifier = Modifier.fillMaxWidth()) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = "Nombre: ${nombre.ifEmpty { "---" }}", 
                style = MaterialTheme.typography.titleLarge
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Ciudad: ${ciudad.ifEmpty { "---" }}")
            Text(text = "Edad: ${edad.ifEmpty { "---" }}")
        }
    }
}

// 3. HIJO 2 (Stateless / Sin estado) - Interacción
// Es un "trabajador" que dibuja campos de texto, pero no guarda información por sí mismo.
@Composable
fun FormularioPersona(
    nombre: String,
    alCambiarNombre: (String) -> Unit,
    ciudad: String,
    alCambiarCiudad: (String) -> Unit,
    edad: String,
    alCambiarEdad: (String) -> Unit
) {
    Column {
        OutlinedTextField(
            value = nombre,
            onValueChange = alCambiarNombre, // Le avisa al Jefe que el nombre cambió
            label = { Text("Nombre") },
            modifier = Modifier.fillMaxWidth().padding(bottom = 8.dp)
        )
        OutlinedTextField(
            value = ciudad,
            onValueChange = alCambiarCiudad, // Le avisa al Jefe que la ciudad cambió
            label = { Text("Ciudad") },
            modifier = Modifier.fillMaxWidth().padding(bottom = 8.dp)
        )
        OutlinedTextField(
            value = edad,
            onValueChange = alCambiarEdad, // Le avisa al Jefe que la edad cambió
            label = { Text("Edad") },
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Preview(showBackground = true)
@Composable
fun FichaPersonaPreview() {
    Introduccion2Theme {
        FichaPersona()
    }
}