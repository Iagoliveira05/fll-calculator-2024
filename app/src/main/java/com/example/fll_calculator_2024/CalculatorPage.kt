package com.example.fll_calculator_2024

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Checkbox
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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


@Composable
fun CalculatorPage(modifier: Modifier = Modifier, viewModel: MissionViewModel) {
    val missionList by viewModel.missionList.observeAsState()


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


            missionList?.let {
                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(20.dp),
                    content = {
                        itemsIndexed(it) { index, item ->
                            var extendedState by remember { mutableStateOf(true) }

                            when (extendedState) {
                                false -> {
                                    MissionItemCondensed(
                                        mission = item,
                                        onCondensedClick = { extendedState = !extendedState }
                                    )
                                }

                                true -> {
                                    MissionItemExtended(
                                        mission = item,
                                        onExtendedClick = { extendedState = !extendedState }
                                    )
                                }
                            }
                        }
                    }
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

@Composable
fun MissionItemCondensed(
    modifier: Modifier = Modifier,
    mission: MissionModel,
    onCondensedClick: () -> Unit
) {
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
                    text = "${mission.totalPoints} pts.",
                    style = TextStyle(
                        fontSize = 13.sp,
                        color = Color.Black,
                        fontWeight = FontWeight.W500
                    )
                )
            }

            IconButton(onClick = { onCondensedClick() }) {
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
fun MissionItemExtended(
    modifier: Modifier = Modifier,
    mission: MissionModel,
    onExtendedClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(vertical = 8.dp)
            .shadow(elevation = 5.dp, shape = RoundedCornerShape(10))
            .background(color = Color.White, shape = RoundedCornerShape(10))
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                modifier = Modifier
                    .size(150.dp)
                    .padding(5.dp)
                    .clip(shape = RoundedCornerShape(15.dp)),
                painter = painterResource(id = mission.image),
                contentDescription = null

            )

            Text(
                text = mission.title,
                style = TextStyle(
                    fontSize = 16.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.Bold
                )
            )
            Text(
                text = "${mission.totalPoints} pts.",
                style = TextStyle(
                    fontSize = 13.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.W500
                )
            )

            mission.goalsList.forEach {
                Row(
                    modifier = Modifier
                        .fillMaxSize(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Checkbox(
                        checked = false,
                        onCheckedChange = {}
                    )
                    Text(
                        modifier = Modifier.padding(end = 10.dp),
                        text = "${it.goal} pts.",
                        style = TextStyle(
                            fontSize = 13.sp,
                            color = Color.Black,
                            fontWeight = FontWeight.W500,
                            textAlign = TextAlign.Justify
                        )
                    )
                }
            }
        }
        IconButton(
            onClick = { onExtendedClick() },
            modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(top = 20.dp)
        ) {
            Icon(
                tint = Color.Black,
                painter = painterResource(id = R.drawable.icon_arrow_up),
                contentDescription = null
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun AppPreview() {
    CalculatorPage(viewModel = MissionViewModel())
}