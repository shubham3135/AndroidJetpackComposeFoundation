package com.shubhamkumarwinner.composefoundation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import com.shubhamkumarwinner.composefoundation.ui.theme.ComposeFoundationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeFoundationTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    BaseTextFieldDemo()
                }
            }
        }
    }
}

//baseTextField
@Composable
fun BaseTextFieldDemo() {
    var textState by remember { mutableStateOf(TextFieldValue()) }

    Column {
        TextField(value = textState, onValueChange = {
            textState = it
        })
        Text("The text field has this text: " + textState.text)
    }

}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeFoundationTheme {
        BaseTextFieldDemo()
    }
}