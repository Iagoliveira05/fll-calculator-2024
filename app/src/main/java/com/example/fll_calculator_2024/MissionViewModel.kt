package com.example.fll_calculator_2024

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MissionViewModel: ViewModel() {
    private val _missionList = MutableLiveData<List<MissionModel>>()
    val missionList: LiveData<List<MissionModel>> = _missionList


    init {
        getAllMission()
    }

    private fun getAllMission(){
         _missionList.value = MissionManager.getAllMission()
    }
}