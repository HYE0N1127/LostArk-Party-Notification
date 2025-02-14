package com.hyeonbin.lostark_party_notification.ui.main.network

import com.hyeonbin.lostark_party_notification.Result
import com.hyeonbin.lostark_party_notification.database.alarm.AlarmEntity
import com.hyeonbin.lostark_party_notification.database.alarm.AlarmListDao
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AlarmRepository @Inject constructor(private val alarmDao: AlarmListDao) {
    suspend fun insertAlarm(alarm: AlarmEntity) {
        alarmDao.insertAlarm(alarm)
    }

    suspend fun getAllAlarms(): Flow<Result<List<AlarmEntity>>> = flow {
        emit(Result.Loading)
        try {
            alarmDao.getAllAlarms().collect {
                emit(Result.Success(it))
            }
        } catch (e: Exception) {
            emit(Result.Error(e, e.message.toString()))
        }
    }

    suspend fun deleteAlarm(alarmId: Int) {
        alarmDao.deleteAlarm(alarmId)
    }
}