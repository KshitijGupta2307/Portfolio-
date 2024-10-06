package com.example.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.android.ui.theme.AndroidTheme
import kotlin.String

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AndroidTheme {
                CreateBizcard()
            }
        }
    }
}

@Composable
fun CreateBizcard() {
    var buttonClickedState by remember { mutableStateOf(false) }
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
        Card(
            modifier = Modifier
                .width(200.dp)
                .height(390.dp)
                .padding(12.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White),
            shape = RoundedCornerShape(corner = CornerSize(15.dp)),
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                CreateImageProfile(Modifier.size(100.dp))
                HorizontalDivider()
                CreateInfo()
                Button(onClick = { buttonClickedState = !buttonClickedState }) {
                    Text("Portfolio", style = MaterialTheme.typography.titleMedium)
                }
                if (buttonClickedState) {
                    Content()
                }
            }
        }
    }
}

@Preview
@Composable
fun Content() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(5.dp)
    ) {
        Surface(
            modifier = Modifier
                .padding(3.dp)
                .fillMaxHeight()
                .fillMaxWidth(),
            shape = RoundedCornerShape(6.dp),
            border = BorderStroke(2.dp, color = MaterialTheme.colorScheme.primary)
        ) {
            Portfolio(data = listOf("Project1", "Project2", "Project3", "Project4", "Project5"))
        }
    }
}

@Composable
fun Portfolio(data: List<String>) {
    LazyColumn {
        items(data) { item ->
            Card(
                modifier = Modifier
                    .padding(13.dp)
                    .fillMaxWidth(),
                shape = RectangleShape,
                elevation = CardDefaults.cardElevation(defaultElevation = 7.dp)
            ) {
                Row(
                    modifier = Modifier
                        .padding(8.dp)
                        .background(MaterialTheme.colorScheme.surface)
                        .padding(7.dp)
                ) {
                    CreateImageProfile(modifier = Modifier.size(100.dp))
                    Column(
                        modifier = Modifier
                            .padding(7.dp)
                            .align(Alignment.CenterVertically)
                    ) {
                        Text(text = item, fontWeight = FontWeight.Bold) // Removed extra padding
                        Text(text = "A great project", style = MaterialTheme.typography.bodySmall) // Removed extra padding
                    }
                }
            }
        }
    }
}
@Composable
private fun CreateInfo() {
    Column(modifier = Modifier.padding(5.dp)) {
        Text(
            text = "XYZ",
            style = MaterialTheme.typography.headlineLarge,
            color = MaterialTheme.colorScheme.primary
        )
        Text(text = "XYZ", modifier = Modifier.padding(3.dp))
        Text(
            text = "XYZ",
            modifier = Modifier.padding(3.dp),
            style = MaterialTheme.typography.titleLarge
        )
    }
}

@Composable
private fun CreateImageProfile(modifier: Modifier) {
    Surface(
        modifier = Modifier
            .size(150.dp)
            .padding(5.dp),
        shape = CircleShape,
        border = BorderStroke(0.5.dp, Color.LightGray),
        tonalElevation = 4.dp,
        color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.5f)
    ) {
        Image(
            painter = painterResource(id = R.drawable.profile_image), // Replace with your actual image
            contentDescription = "profile image",
            modifier = Modifier.size(155.dp),
            contentScale = ContentScale.Crop
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    AndroidTheme {
        CreateBizcard()
    }
}