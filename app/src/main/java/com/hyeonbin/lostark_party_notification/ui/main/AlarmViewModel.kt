package com.hyeonbin.lostark_party_notification.ui.main

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hyeonbin.lostark_party_notification.Result
import com.hyeonbin.lostark_party_notification.database.alarm.AlarmEntity
import com.hyeonbin.lostark_party_notification.ui.main.network.AlarmRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AlarmViewModel @Inject constructor(private val repository: AlarmRepository): ViewModel() {
    private val _alarmsResult: MutableStateFlow<Result<List<AlarmEntity>>> = MutableStateFlow(Result.Loading)
    val alarmsResult: StateFlow<Result<List<AlarmEntity>>> = _alarmsResult

    init {
        getAllAlarmData()
    }

    private fun getAllAlarmData() {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getAllAlarms().collect { result ->
                _alarmsResult.value = result
                Log.d("Teddy", "result = $result")
            }
        }
    }
}