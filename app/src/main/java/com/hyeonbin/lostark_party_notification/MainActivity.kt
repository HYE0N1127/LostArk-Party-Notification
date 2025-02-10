package com.hyeonbin.lostark_party_notification

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hyeonbin.lostark_party_notification.ui.theme.LostArkPartyNotificationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LostArkPartyNotificationTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { _ ->
                    RaidMainTitle("레이드 알람")
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun MainPreview() {
    LostArkPartyNotificationTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { _ ->
            Column {
                RaidMainTitle("레이드 알람")
                RaidAlarmItem()
            }
        }
    }
}

@Composable
fun RaidMainTitle(text: String, modifier: Modifier = Modifier) {
    val dividerColor = Color(0xFFEEEFF1)
    Column(modifier = modifier.fillMaxWidth()) {
        Text(
            text = text,
            fontSize = 18.sp,
            color = Color.Black,
            modifier = modifier
                .fillMaxWidth()
                .padding(24.dp, 16.dp)
        )
        HorizontalDivider(color = dividerColor, thickness = 1.dp)
    }
}

@Composable
fun RaidAlarmItem() {
    val dividerColor = Color(0xFFEEEFF1)
    Column {
        AlarmItemTitle()
        AlarmItemTime("8:00")
        HorizontalDivider(
            modifier = Modifier
                .fillMaxWidth()
                .padding(all = 24.dp),
            color = dividerColor,
            thickness = 1.dp
        )
    }
}

@Composable
fun AlarmItemTitle(title: String = "목요일 오후・5분 전 알람", modifier: Modifier = Modifier) {
    val titleTextColor = Color(0xFF607085)
    Text(
        text = title,
        fontSize = 16.sp,
        color = titleTextColor,
        modifier = modifier
            .fillMaxWidth()
            .padding(24.dp, 24.dp, 24.dp, 0.dp)
    )
}

@Composable
fun AlarmItemTime(timeStamp: String, modifier: Modifier = Modifier) {
    val textColor = Color(0xFF25282D)
    Text(
        text = timeStamp,
        fontSize = 60.sp,
        color = textColor,
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp, vertical = 0.dp)
    )
}