package com.hyeonbin.lostark_party_notification.ui.main

import com.hyeonbin.lostark_party_notification.model.Alarm

class MainRepository {
    fun getTestAlarmListItem(): List<Alarm> {
        return listOf(
            Alarm("목요일", true, false, "5분 전", "9:00"),
            Alarm("일요일", false, false, "10분 전", "11:00"),
            Alarm("화요일", true, false, "5분 전", "7:00"),
            Alarm("금요일", true, false, "20분 전", "11:00"),
            Alarm("금요일", true, false, "20분 전", "11:00"),
            Alarm("금요일", true, false, "20분 전", "11:00"),
            Alarm("금요일", true, false, "20분 전", "11:00"),
            Alarm("금요일", true, false, "20분 전", "11:00"),
            Alarm("금요일", true, false, "20분 전", "11:00"),
            Alarm("금요일", true, false, "20분 전", "11:00"),
            Alarm("금요일", true, false, "20분 전", "11:00"),
            Alarm("토요일", false, false, "15분 전", "10:00")
        )
    }
}