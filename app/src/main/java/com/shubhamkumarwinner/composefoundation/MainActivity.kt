package com.shubhamkumarwinner.composefoundation

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.shubhamkumarwinner.composefoundation.ui.theme.ComposeFoundationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeFoundationTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    TextExample()
                }
            }
        }
    }
}

//text
@Composable
fun TextExample(){
    Column {
        Text("Just Text")
        Text("Text with cursive font", style = TextStyle(fontFamily = FontFamily.Cursive))
        Text(
            text = "Text with LineThrough",
            style = TextStyle(textDecoration = TextDecoration.LineThrough)
        )
        Text(
            text = "Text with underline",
            style = TextStyle(textDecoration = TextDecoration.Underline)
        )
        Text(
            text = "Text with underline, linethrough and bold",
            style = TextStyle(
                textDecoration = TextDecoration.combine(
                    listOf(
                        TextDecoration.Underline,
                        TextDecoration.LineThrough
                    )
                ), fontWeight = FontWeight.Bold
            )
        )
    }
}

//lazyVerticalGrid
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun LazyVerticalGridDemo(){
    val list = (1..50).map { it.toString() }

    LazyVerticalGrid(
        cells = GridCells.Adaptive(128.dp),

        // content padding
        contentPadding = PaddingValues(
            start = 12.dp,
            top = 16.dp,
            end = 12.dp,
            bottom = 16.dp
        ),
        content = {
            items(list.size) { index ->
                Card(
                    backgroundColor = Color.Red,
                    modifier = Modifier
                        .padding(4.dp)
                        .fillMaxWidth(),
                    elevation = 8.dp,
                ) {
                    Text(
                        text = list[index],
                        fontWeight = FontWeight.Bold,
                        fontSize = 30.sp,
                        color = Color(0xFFFFFFFF),
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(16.dp)
                    )
                }
            }
        }
    )
}

//lazyRow
@Composable
fun LazyRowDemo() {
    val list = listOf(
        "A", "B", "C", "D"
    ) + ((0..100).map { it.toString() })
    LazyRow(modifier = Modifier.fillMaxHeight()) {
        items(items = list, itemContent = { item ->
            Log.d("COMPOSE", "This get rendered $item")
            when (item) {
                "A" -> {
                    Text(text = item, style = TextStyle(fontSize = 80.sp))
                }
                "B" -> {
                    Button(onClick = {}) {
                        Text(text = item, style = TextStyle(fontSize = 80.sp))
                    }
                }
                "C" -> {
                    //Do Nothing
                }
                "D" -> {
                    Text(text = item)
                }
                else -> {
                    Text(text = item, style = TextStyle(fontSize = 80.sp))
                }
            }
        })
    }
}

//lazyColumn
@Composable
fun LazyColumnDemo() {
    val list = listOf(
        "A", "B", "C", "D"
    ) + ((0..100).map { it.toString() })
    LazyColumn(modifier = Modifier.fillMaxHeight()) {
        items(items = list, itemContent = { item ->
            Log.d("COMPOSE", "This get rendered $item")
            when (item) {
                "A" -> {
                    Text(text = item, style = TextStyle(fontSize = 80.sp))
                }
                "B" -> {
                    Button(onClick = {}) {
                        Text(text = item, style = TextStyle(fontSize = 80.sp))
                    }
                }
                "C" -> {
                    //Do Nothing
                }
                "D" -> {
                    Text(text = item)
                }
                else -> {
                    Text(text = item, style = TextStyle(fontSize = 80.sp))
                }
            }
        })
    }
}

//image
@Composable
fun ImageResourceDemo() {
    val image: Painter = painterResource(id = R.drawable.pic)
    Image(painter = image,contentDescription = "")
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
        TextExample()
    }
}