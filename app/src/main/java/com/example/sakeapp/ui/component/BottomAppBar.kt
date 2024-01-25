package com.example.sakeapp.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.StarRate
import androidx.compose.material.icons.filled.Timelapse
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.sakeapp.R
import com.example.sakeapp.ui.theme.BlueGrey
import com.example.sakeapp.ui.theme.Grey20

@Composable
fun SakeBottomAppBar(){
        BottomAppBar(containerColor = Grey20) {
            Row(
                modifier = Modifier.fillMaxSize(),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                IconButton(
                    onClick = {/*TODO クリックイベント*/}
                ) {
                    Icon(
                        Icons.Filled.Timelapse,
                        contentDescription = "タイムラインアイコン",
                        tint = BlueGrey,
                        modifier = Modifier.size(100.dp)
                    )
                }

                IconButton(
                    onClick = {/*TODO クリックイベント*/}
                ) {
                    Icon(
                        Icons.Filled.Create,
                        contentDescription = "投稿アイコン",
                        tint = BlueGrey,
                        modifier = Modifier.size(100.dp)
                    )
                }

                IconButton(
                    onClick = {/*TODO クリックイベント*/}
                ) {
                    Icon(
                        Icons.Filled.Star,
                        contentDescription = "ランキングアイコン",
                        tint = BlueGrey,
                        modifier = Modifier.size(100.dp)
                    )
                }
            }
        }
}