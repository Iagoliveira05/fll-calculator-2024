package com.example.fll_calculator_2024

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.fll_calculator_2024.ui.theme.FLLCalculator2024Theme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FLLCalculator2024Theme {
                Scaffold(
                    containerColor = Color(0xFF7FE5F7),
                ) { innerPadding ->
                    App(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun App(modifier: Modifier = Modifier) {
    Surface(
        modifier = modifier.fillMaxSize(),
        color = Color(0xFF0088A6),
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TopBarAppCalculator(
                modifier = Modifier
                    .fillMaxWidth()
                    .shadow(
                        elevation = 20.dp,
                        shape = RoundedCornerShape(
                            bottomStart = 20.dp,
                            bottomEnd = 20.dp
                        )
                    )
                    .background(
                        color = Color(0xFF7FE5F7),
                        shape = RoundedCornerShape(
                            bottomStart = 20.dp,
                            bottomEnd = 20.dp
                        )
                    )
                    .height(120.dp)
                    .padding(horizontal = 20.dp, vertical = 10.dp)
            )

            Title()

            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(20.dp)
            ) {
                item {
                    MissionItem(
                        mission = MissionModel(
                            title = "Inspeção de Equipamentos",
                            image = R.drawable.icon_inspection,
                            points = 20
                        )
                    )

                    MissionItem(
                        mission = MissionModel(
                            title = "M01 Viveiro de Corais",
                            image = R.drawable.m01_coral,
                            points = 50
                        )
                    )

                    MissionItem(
                        mission = MissionModel(
                            title = "M02 Tubarão",
                            image = R.drawable.m02_shark,
                            points = 30
                        )
                    )

                    MissionItem(
                        mission = MissionModel(
                            title = "Inspeção de Equipamentos",
                            image = R.drawable.icon_inspection,
                            points = 20
                        )
                    )

                    MissionItem(
                        mission = MissionModel(
                            title = "M01 Viveiro de Corais",
                            image = R.drawable.m01_coral,
                            points = 50
                        )
                    )

                    MissionItem(
                        mission = MissionModel(
                            title = "M02 Tubarão",
                            image = R.drawable.m02_shark,
                            points = 30
                        )
                    )

                    MissionItem(
                        mission = MissionModel(
                            title = "Inspeção de Equipamentos",
                            image = R.drawable.icon_inspection,
                            points = 20
                        )
                    )

                    MissionItem(
                        mission = MissionModel(
                            title = "M01 Viveiro de Corais",
                            image = R.drawable.m01_coral,
                            points = 50
                        )
                    )

                    MissionItem(
                        mission = MissionModel(
                            title = "M02 Tubarão",
                            image = R.drawable.m02_shark,
                            points = 30
                        )
                    )
                }
            }

        }
    }
}

@Composable
fun MissionItem(modifier: Modifier = Modifier, mission: MissionModel) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(vertical = 8.dp)
            .shadow(elevation = 10.dp, shape = RoundedCornerShape(20))
            .background(color = Color.White, shape = RoundedCornerShape(20))
    ) {
        Row(
            modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                modifier = Modifier
                    .size(90.dp)
                    .padding(5.dp)
                    .clip(shape = RoundedCornerShape(15.dp)),
                painter = painterResource(id = mission.image),
                contentDescription = null

            )

            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = mission.title,
                    style = TextStyle(
                        fontSize = 16.sp,
                        color = Color.Black,
                        fontWeight = FontWeight.Bold
                    )
                )
                Text(
                    text = "${mission.points}pts.",
                    style = TextStyle(
                        fontSize = 13.sp,
                        color = Color.Black,
                        fontWeight = FontWeight.W500
                    )
                )
            }

            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    tint = Color.Black,
                    painter = painterResource(id = R.drawable.icon_arrow_down),
                    contentDescription = null
                )
            }
        }
    }
}


@Composable
fun Title() {
    Spacer(modifier = Modifier.height(30.dp))
    Text(
        text = "Missões",
        style = TextStyle(
            fontSize = 32.sp,
            color = Color.White,
            fontWeight = FontWeight.W400
        )
    )
    HorizontalDivider(
        modifier = Modifier
            .padding(horizontal = 20.dp, vertical = 5.dp)
            .alpha(0.6F),
        color = Color.White
    )

    Text(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp),
        text = "Pontuação: 10pts.",
        style = TextStyle(
            fontSize = 20.sp,
            color = Color.White,
            fontWeight = FontWeight.W400,
            textAlign = TextAlign.End,
            textDecoration = TextDecoration.Underline
        )
    )
}

@Preview(showBackground = true)
@Composable
fun AppPreview() {
    App()
}