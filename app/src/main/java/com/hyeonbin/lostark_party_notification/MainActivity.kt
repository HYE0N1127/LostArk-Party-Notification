package com.hyeonbin.lostark_party_notification

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
                Scaffold(modifier = Modifier.fillMaxSize()) {
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
        Scaffold(modifier = Modifier.fillMaxSize()) {
            RaidMainTitle("레이드 알람")
        }
    }
}

@Composable
fun RaidMainTitle(text: String, modifier: Modifier = Modifier) {
    Text(
        text = text,
        fontSize = 18.sp,
        color = Color.Black,
        modifier = modifier.fillMaxWidth().padding(24.dp, 16.dp)
    )
}

@Composable
fun RaidAlarmItem() {
    
}