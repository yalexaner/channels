package com.example.channels.ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ControlButtons(
    onGoToPrevious: () -> Unit,
    onGoToNext: () -> Unit
) {
    Row {
        TextButton(onClick = onGoToPrevious) {
            Text(text = "PREVIOUS")
        }

        Spacer(modifier = Modifier.width(16.dp))

        TextButton(onClick = onGoToNext) {
            Text(text = "NEXT")
        }
    }
}