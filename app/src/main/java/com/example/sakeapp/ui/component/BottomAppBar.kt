package com.example.sakeapp.ui.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Timeline
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.example.sakeapp.ui.theme.BlueGrey
import com.example.sakeapp.ui.theme.Grey20
import androidx.navigation.NavController

@Composable
fun SakeBottomAppBar(navController: NavController) {
    BottomAppBar(containerColor = Grey20) {
        Row(
            modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            SakeBottomAppBarItem(
                icon = Icons.Filled.Timeline,
                contentDescription = "タイムラインアイコン",
                onClick = { navController.navigate("ranking") }
            )

            SakeBottomAppBarItem(
                icon = Icons.Filled.Search,
                contentDescription = "検索アイコン",
                onClick = { navController.navigate("search") }
            )
        }
    }
}

@Composable
fun SakeBottomAppBarItem(
    icon: ImageVector,
    contentDescription: String,
    onClick: () -> Unit
) {
    IconButton(
        onClick = onClick
    ) {
        Icon(
            icon,
            contentDescription = contentDescription,
            tint = BlueGrey,
            modifier = Modifier.size(100.dp)
        )
    }
}