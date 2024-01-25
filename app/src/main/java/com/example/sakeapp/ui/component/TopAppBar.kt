package com.example.sakeapp.ui.component

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import com.example.sakeapp.ui.theme.BlueGrey
import com.example.sakeapp.ui.theme.Grey20

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
                    tint = Grey20
                )
            }
        },
        title = {
                Text(
                    text = "さけのば",
                    color = Grey20
                )
        },
        actions = {
            IconButton(onClick = { /*TODO 画面遷移イベント*/ }) {
                 Icon(
                     Icons.Filled.Info,
                     contentDescription = "CopyRight",
                     tint = Grey20
                 )
            }
        }
    )
}
