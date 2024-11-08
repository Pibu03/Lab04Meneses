package com.example.lab04_meneses

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lab04_meneses.ui.theme.Lab04MenesesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Lab04MenesesTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MainContent(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun MainContent(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Greeting(name = "Android")
        Spacer(modifier = Modifier.height(16.dp))
        Counter()
        Spacer(modifier = Modifier.height(16.dp))
        UserInputField()
        Spacer(modifier = Modifier.height(16.dp))
        ImageGallery()
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hola $name!",
        modifier = modifier
    )
}

@Composable
fun Counter() {
    var count by remember { mutableStateOf(0) }
    Row(verticalAlignment = Alignment.CenterVertically) {
        Button(onClick = { count++ }) {
            Text(text = "Incrementar")
        }
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = "Cuenta: $count")
    }
}

@Composable
fun UserInputField() {
    var text by remember { mutableStateOf("") }
    BasicTextField(
        value = text,
        onValueChange = { text = it },
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        decorationBox = { innerTextField ->
            Box(modifier = Modifier.padding(8.dp)) {
                if (text.isEmpty()) {
                    Text("Ingrese su texto aquí", color = androidx.compose.ui.graphics.Color.Gray)
                }
                innerTextField()
            }
        }
    )
}

@Composable
fun ImageGallery() {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_foreground),
            contentDescription = "Imagen 1",
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_foreground),
            contentDescription = "Imagen 2",
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_foreground),
            contentDescription = "Imagen 3",
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun MainContentPreview() {
    Lab04MenesesTheme {
        MainContent()
    }
}