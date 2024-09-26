package com.example.fll_calculator_2024

object MissionManager {
    private val _missionList = mutableListOf<MissionModel>()

    init {
        addAllMissions()
    }

    private fun addAllMissions(): List<MissionModel> {
        _missionList.add(
            0,
            MissionModel(
                title = "Inspeção de Equipamentos",
                image = R.drawable.icon_inspection,
                totalPoints = 20,
                goalsList = listOf(
                    GoalsModel(
                        "(Pré-jogo) O robô e todo o equipamento cabem completamente em uma área de lançamento e abaixo do limite de altura",
                        20
                    )
                )
            )
        )

        _missionList.add(
            1,
            MissionModel(
                title = "M01 Viveiro de Coral",
                image = R.drawable.m01_coral,
                totalPoints = 50,
                goalsList = listOf(
                    GoalsModel(
                        "A árvore de coral está pendurada no suporte da árvore de coral",
                        20
                    ),
                    GoalsModel(
                        "A parte inferior da árvore de coral está em seu suporte",
                        10
                    ),
                    GoalsModel(
                        "Os botões de coral são virados para cima",
                        20
                    )
                )
            )
        )



        return _missionList
    }

    fun getAllMission(): List<MissionModel> {
        return _missionList
    }
}