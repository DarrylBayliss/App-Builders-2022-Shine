package com.darrylbayliss.sunshine.ui.detail

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.* // ktlint-disable no-wildcard-imports
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.darrylbayliss.sunshine.R
import com.darrylbayliss.sunshine.ui.theme.SunshineTheme

@Composable
fun DetailScreen() {
    SunshineTheme {
        WeatherDetail()
    }
}

@Composable
fun WeatherDetail() {

    Column {
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .padding(all = 10.dp),
            imageVector = Icons.Filled.ArrowDropDown,
            contentDescription = "Weather Detail Symbol"
        )

        Row {
            Box(
                modifier = Modifier
                    .size(width = 100.dp, height = 100.dp)
                    .border(BorderStroke(width = 0.1.dp, color = Color.Gray)),
                contentAlignment = Alignment.Center
            ) {
                Text("14")
            }

            Box(
                modifier = Modifier
                    .size(width = 100.dp, height = 100.dp)
                    .border(BorderStroke(width = 0.1.dp, color = Color.Gray)),
                contentAlignment = Alignment.Center
            ) {
                Column {
                    Text("H:16°c")
                    Spacer(modifier = Modifier.height(10.dp))
                    Text("L:12°c")
                }
            }
        }

        Row {
            Box(
                modifier = Modifier
                    .size(width = 100.dp, height = 100.dp)
                    .border(BorderStroke(width = 0.1.dp, color = Color.Gray)),
                contentAlignment = Alignment.Center
            ) {

                Column {
                    Row {
                        Image(
                            painter = painterResource(id = R.drawable.ic_sunrise),
                            contentDescription = "Sunrise"
                        )
                        Text(
                            text = "08:23"
                        )
                    }
                }

                Column {
                    Row {
                        Image(
                            painter = painterResource(id = R.drawable.ic_sunset),
                            contentDescription = "Sunset"
                        )
                        Text(
                            text = "19:34"
                        )
                    }
                }
            }

            Box(
                modifier = Modifier
                    .size(width = 100.dp, height = 100.dp)
                    .border(BorderStroke(width = 0.1.dp, color = Color.Gray)),
                contentAlignment = Alignment.Center
            ) {
                Row {
                    Image(
                        painter = painterResource(id = R.drawable.ic_sunset),
                        contentDescription = "Sunset"
                    )
                    Text(
                        text = "19:34"
                    )
                }
            }
        }
    }
}
