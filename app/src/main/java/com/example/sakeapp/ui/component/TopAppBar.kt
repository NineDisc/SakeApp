package com.example.sakeapp.ui.component

import androidx.compose.foundation.layout.Row
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.example.sakeapp.ui.theme.BlueGrey
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SakeTopAppBar() {
    TopAppBar(
        colors = topAppBarColors(containerColor = BlueGrey),
        navigationIcon = {
            IconButton(
                onClick = {/*TODO クリックイベント*/}
            ) {
                Icon(
                    Icons.Filled.Menu,
                    contentDescription = "ハンバーガーメニュー",
                    tint = Color.Gray
                )
            }
        },
        title = {
                Text(
                    text = "さけのば",
                    color = Color.White
                )
        },
        actions = {
            IconButton(onClick = { /*TODO 画面遷移イベント*/ }) {
                 Icon(
                     Icons.Filled.Info,
                     contentDescription = "CopyRight",
                     tint = Color.Gray
                 )
            }
        }
    )
}
