package com.example.mytabata

import com.example.mytabata.ui.theme.MytabataTheme

import android.os.Bundle
import android.os.CountDownTimer
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MytabataTheme{
                Scaffold(modifier = Modifier
                        .fillMaxSize()) { innerPadding ->
                    Counter(
                        modifier = Modifier
                            .padding(innerPadding)

                    )
                }
            }
        }
    }
}

@Composable
fun Counter(modifier: Modifier = Modifier) {
    var theCounter by remember { mutableStateOf(0L) }
    var miConterDown by remember{ mutableStateOf(CounterDown(99, {newvalue -> theCounter = newvalue}))}

    Column(modifier = Modifier
            .fillMaxSize()
            .background(Color(233, 233, 233)),
            verticalArrangement = Arrangement.Top)
    {
        Text(
            text = "Interval Timer",
            fontWeight = FontWeight.Bold,
            fontSize = 40.sp,
            modifier = modifier
                .align(alignment = Alignment.CenterHorizontally)
                .padding(top = 60.dp),

        )
        Text(
            text = "Quick Start ",
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            modifier = modifier
                .align(alignment = Alignment.Start)
                .padding(start = 20.dp)
            )
        Text(
            text = "SETS",
            fontSize = 20.sp,
            modifier = modifier
                .align(alignment = Alignment.CenterHorizontally)
            )
        Row(modifier = Modifier
            .background(Color(21, 194, 192))
            .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround
        ){
            Text(
                text = "+",
                modifier = modifier
            )
            Text(
                text = "12:58",
                modifier = modifier
            )
            Text(
                text = "-",
                modifier = modifier
            )
        }
        Text(
                text = "WORK",
                fontSize = 20.sp,
                modifier = modifier
                    .align(alignment = Alignment.CenterHorizontally)
            )
        Row(modifier = Modifier
            .background(Color(163, 228, 215 ))
            .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround
        ){
            Text(
                text = "+",
                modifier = modifier
            )
            Text(
                text = "12:58",
                modifier = modifier
            )
            Text(
                text = "-",
                modifier = modifier
            )
        }
        Text(
                text = "REST",
                fontSize = 20.sp,
                modifier = modifier
                    .align(alignment = Alignment.CenterHorizontally)
            )
        Row(modifier = Modifier
            .background(Color(163, 228, 215 ))
            .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround
        ){
            Text(
                text = "+",
                modifier = modifier
            )
            Text(
                text = theCounter.toString() + ":" +  theCounter.toString(),
                modifier = modifier
            )
            Text(
                text = "-",
                modifier = modifier
            )
        }
        Button(modifier = Modifier.align(alignment = Alignment.CenterHorizontally), onClick = {
            miConterDown.toggle()
        }) {
            Text(
                text = "Empezar",
                modifier = Modifier.padding( start = 36.dp, end = 36.dp)
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MytabataTheme {
        Counter()
    }
}