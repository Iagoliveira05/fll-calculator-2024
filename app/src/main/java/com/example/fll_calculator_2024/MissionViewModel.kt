package com.example.fll_calculator_2024

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MissionViewModel: ViewModel() {
    private val _missionList = MutableLiveData<List<MissionModel>>()
    private val _score = MutableLiveData<Int>()
    val missionList: LiveData<List<MissionModel>> = _missionList
    val score: LiveData<Int> = _score


    init {
        getAllMission()
        getScore()
    }

    private fun getAllMission(){
         _missionList.value = MissionManager.getAllMission()
    }

    private fun getScore() {
        _score.value = MissionManager.getScore()
    }

    fun checkedChange() {
        MissionManager.sumScore()
        getScore()
    }

}