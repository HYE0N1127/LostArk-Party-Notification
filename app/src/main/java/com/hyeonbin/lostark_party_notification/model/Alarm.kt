package com.hyeonbin.lostark_party_notification.model

data class Alarm(
    val dayOfWeek: String,
    val isAfterNoon: Boolean,
    val isPush: Boolean,
    val alarmMinutesAgo: String,
    val raidTime: String
)
