package com.hyeonbin.lostark_party_notification.module

import android.app.Application
import androidx.room.Room
import com.hyeonbin.lostark_party_notification.database.AlarmDatabase
import com.hyeonbin.lostark_party_notification.database.alarm.AlarmListDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataBaseModule {
    @Provides
    @Singleton
    fun provideDatabase(app: Application): AlarmDatabase {
        return Room.databaseBuilder(app, AlarmDatabase::class.java, "alarm_database").build()
    }

    @Provides
    @Singleton
    fun provideAlarmDao(database: AlarmDatabase): AlarmListDao {
        return database.alarmDao()
    }
}