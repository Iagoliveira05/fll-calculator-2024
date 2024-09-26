package com.example.fll_calculator_2024

data class MissionModel(
    val title: String,
    val image: Int,
    val totalPoints: Int,
    var goalsList: List<GoalsModel>
)

data class GoalsModel(
    val goal: String,
    val score: Int
)