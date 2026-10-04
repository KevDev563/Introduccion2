package rodriguez.kevin.introduccion2.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import rodriguez.kevin.introduccion2.ui.theme.Introduccion2Theme

@Composable
fun ContadorCafes(){
    var contador by rememberSaveable { mutableStateOf(value = 0) }

    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center) {

        Text(text = "Llevas ${contador} cafes")
        Button(onClick = {contador++}) {
            Text(text = "Agregar otro cafe ")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Introduccion2Theme{
        ContadorCafes()
    }
}



