package com.gunder.testcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.gunder.testcompose.ui.theme.TestComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TestComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    color = MaterialTheme.colors.background) {
                    jetpackCompose()
                }
            }
        }
    }
}

@Composable
fun jetpackCompose() {
    Card {
        var expand by remember { mutableStateOf(false) }
        Column(Modifier.clickable { expand = !expand }) {
            androidx.compose.foundation.Image(painterResource(R.drawable.ic_compose),
                contentDescription = "welcome to jetpack compose")
            AnimatedVisibility(expand) {
                Text(text = "welcome to Jetpack compose",
                    style = MaterialTheme.typography.h3,
                    textAlign = TextAlign.Center)

            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TestComposeTheme {
        jetpackCompose()
    }
}