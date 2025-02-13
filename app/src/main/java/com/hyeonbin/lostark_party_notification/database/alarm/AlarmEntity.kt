package com.hyeonbin.lostark_party_notification.database.alarm

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Alarms")
data class AlarmEntity(
    @PrimaryKey val id: Int,
    // 오전, 오후 여부
    val isAfternoon: Boolean,
    // 요일
    val dayOfWeek: String,
    // 푸쉬 알림인지, 앱 자체 알림인지
    val isPush: Boolean,
    // 언제 울릴 것인지 (ex, 5분 전)
    val alarmSchedule: String,
    // 고정팟 시작 시간이 언제인지(ex, 8:00)
    val raidTime: String
)
