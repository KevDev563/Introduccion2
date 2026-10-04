package rodriguez.kevin.introduccion2.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.LargeFloatingActionButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import rodriguez.kevin.introduccion2.ui.theme.Introduccion2Theme

data class Articulo(
    val id: Int,
    val nombre: String,
    val cantidad: Int
)
@Composable
@OptIn(ExperimentalMaterial3Api::class)

fun ListaCompras(){

    val lista = remember { mutableStateListOf<Articulo>(
        Articulo(id = 1, nombre = "Marcador", cantidad = 3),
        Articulo(id = 2, nombre = "Lapiz", cantidad = 3)
    ) }
    Scaffold(
        topBar = { TopAppBar(title = { Text("Lista de compras") }) },

        floatingActionButton = {
            LargeFloatingActionButton(
                onClick = { /* Acción al presionar */ },
                containerColor = Color.Green,
                shape = CircleShape,
                modifier = Modifier.padding(16.dp)
            ) {
                Text(
                    text = "+",
                    fontSize = 40.sp,
                    color = Color.White
                )
            }
        }
    ) {
        innerPadding ->
        LazyColumn(modifier = Modifier.fillMaxSize().padding(innerPadding)) {
            items(
                items = lista,
                key = {it.id}
            ) { articulo ->
                ItemLista(articulo = articulo)
            }
        }
    }
}

@Composable
fun ItemLista(articulo: Articulo){
    Card(
        modifier = Modifier.padding(all = 8.dp)
            .fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Text(text = "${articulo.nombre} x${articulo.cantidad}", modifier = Modifier.padding(16.dp))
    }
}


@Preview(showBackground = true)
@Composable
fun ListaComprasPreview() {
    Introduccion2Theme {
        ListaCompras()
    }
}
