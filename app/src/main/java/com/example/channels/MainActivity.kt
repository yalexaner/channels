package com.example.channels

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import com.example.channels.ui.screens.MainScreen
import com.example.channels.ui.theme.ChannelsTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ChannelsTheme {
                MainScreen()
            }
        }
    }
}