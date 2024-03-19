package com.example.sakeapp.ui.component

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.clickable
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import com.example.sakeapp.ui.theme.BlueGrey
import com.example.sakeapp.ui.theme.Grey20

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SakeTopAppBar(navController: NavController) {
    val context = LocalContext.current
    TopAppBar(
        colors = topAppBarColors(containerColor = BlueGrey),
        title = {
                Text(
                    text = "さけのば",
                    color = Grey20,
                    modifier = Modifier.clickable {
                        navController.navigate("ranking")
                    }
                )
        },
        actions = {
            IconButton(
                onClick = {
                val url = "https://sakenowa.com/"
                val intent = Intent(Intent.ACTION_VIEW)
                intent.data = Uri.parse(url)
                context.startActivity(intent)
            }) {
                 Icon(
                     Icons.Filled.Info,
                     contentDescription = "CopyRight",
                     tint = Grey20
                 )
            }
        }
    )
}

