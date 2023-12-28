package com.example.sakeapp.ui.component

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SakeTopAppBar() {
    TopAppBar(
        title = { Text(text = "さけのば", color = Color.White) },
        colors = topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primary
        )
    )
}