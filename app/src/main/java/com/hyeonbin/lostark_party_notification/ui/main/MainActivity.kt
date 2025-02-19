package com.hyeonbin.lostark_party_notification.ui.main

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hyeonbin.lostark_party_notification.Result
import com.hyeonbin.lostark_party_notification.database.alarm.AlarmEntity
import com.hyeonbin.lostark_party_notification.ui.main.model.Alarm
import com.hyeonbin.lostark_party_notification.ui.theme.LostArkPartyNotificationTheme
import com.hyeonbin.lostark_party_notification.ui.theme.pretendardFontFamily
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val viewModel: AlarmViewModel by viewModels()

    @SuppressLint("StateFlowValueCalledInComposition")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val result = viewModel.alarmsResult.value
        Log.d("Teddy", "alarm result = $result")
        setContent {
            LostArkPartyNotificationTheme {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .systemBarsPadding()
                        .statusBarsPadding()
                ) {
                    RaidMainTitle("레이드 알람")
                    when (result) {
                        is Result.Loading -> {
                            Log.d("Teddy", "Loading")
                        }

                        is Result.Error -> {
                            Log.d("Teddy", "Error")
                        }

                        is Result.Success -> {
                            Log.d("Teddy", "Success")
                            val alarmList = result.data
                            AlarmList(alarmList)
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainPreview() {
    LostArkPartyNotificationTheme {
        val testItemList = MainRepository().getTestAlarmListItem()
        Column(Modifier.fillMaxSize()) {
            RaidMainTitle("레이드 알람")
//            AlarmList(testItemList)
        }
    }
}

@Composable
fun RaidMainTitle(text: String) {
    val dividerColor = Color(0xFFEEEFF1)
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = text,
            fontSize = 18.sp,
            color = Color.Black,
            fontFamily = pretendardFontFamily,
            fontWeight = FontWeight.Medium,
            modifier = Modifier
                .fillMaxWidth()
                .padding(24.dp, 16.dp)
        )
        HorizontalDivider(color = dividerColor, thickness = 1.dp)
    }
}

@Composable
fun AlarmItem(title: String, timeStamp: String) {
    val titleTextColor = Color(0xFF607085)
    val textColor = Color(0xFF25282D)

    Column {

        Text(
            text = title,
            fontSize = 16.sp,
            color = titleTextColor,
            fontFamily = pretendardFontFamily,
            fontWeight = FontWeight.Normal,
            modifier = Modifier
                .fillMaxWidth()
                .padding(24.dp, 24.dp, 24.dp, 0.dp)
        )

        Text(
            text = timeStamp,
            fontSize = 60.sp,
            color = textColor,
            fontFamily = pretendardFontFamily,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp, vertical = 0.dp)
        )
    }
}

@Composable
fun AlarmList(list: List<AlarmEntity>) {
    LazyColumn {
        items(items = list) { raidItem ->
            val isAfterNoon = if (raidItem.isAfternoon) "오후" else "오전"
            val isPush = if (raidItem.isPush) "알림" else "알람"
            val raidTitle = "${raidItem.dayOfWeek} $isAfterNoon・${raidItem.alarmSchedule} $isPush"
            AlarmItem(raidTitle, raidItem.raidTime)
            HorizontalDivider(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(24.dp, 24.dp, 24.dp, 0.dp), thickness = 1.dp
            )
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun EmptyAlarmItem() {
    Scaffold(Modifier.fillMaxSize()) {
        Text(
            "이런, 알람이 비어있어요.",
            fontSize = 16.sp,
            fontFamily = pretendardFontFamily,
            fontWeight = FontWeight.Light
        )
    }
}