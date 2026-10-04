package rodriguez.kevin.introduccion2.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import rodriguez.kevin.introduccion2.ui.theme.Introduccion2Theme

/**
 * COMPOSABLE SIN ESTADO (Stateless)
 * Solo recibe datos como parámetros y los muestra. No modifica nada.
 * Se usa dentro de FichaEstudiante.kt para desplegar o mostrar datos
 */
@Composable
fun PantallaPerfil(
    nombre: String,
    carrera: String,
    semestre: String
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .padding(bottom = 16.dp)
                    .size(130.dp)
                    .clip(CircleShape)
                    .background(MaterialTheme.colorScheme.primaryContainer),
                contentAlignment = Alignment.Center
            ) {
                val inicial = nombre.firstOrNull()?.toString() ?: "?"
                Text(
                    text = inicial.uppercase(),
                    style = MaterialTheme.typography.displayLarge,
                    color = MaterialTheme.colorScheme.onPrimaryContainer,
                )
            }
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = nombre.ifEmpty { "Sin nombre" },
                    fontSize = 25.sp,
                    textAlign = TextAlign.Center
                )
                Text(
                    text = carrera.ifEmpty { "Sin carrera" },
                    fontSize = 20.sp,
                    textAlign = TextAlign.Center
                )
                Text(
                    text = semestre.ifEmpty { "Sin semestre" },
                    fontSize = 18.sp,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}

