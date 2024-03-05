package com.example.sakeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.sakeapp.ui.SakeApp
import com.example.sakeapp.ui.theme.SakeAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SakeAppTheme {
                SakeApp()
            }
        }
    }
}