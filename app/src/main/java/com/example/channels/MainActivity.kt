package com.example.channels

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.channels.data.MainViewModel
import com.example.channels.ui.screens.MainScreen
import com.example.channels.ui.theme.ChannelsTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        setContent {
            ChannelsTheme {
                MainScreen(viewModel = viewModel)
            }
        }
    }
}