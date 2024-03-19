package com.example.sakeapp.ui.feature.search

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun SearchScreen() {
    Column {
        Text(
            text = "検索画面",
            modifier = Modifier.fillMaxWidth(),
            style = TextStyle(fontSize = 30.sp),
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.padding(10.dp))

        // TODO 検索画面の実装
        Row {
            TextField(
                value = "",
                onValueChange = {},
                modifier = Modifier.fillMaxWidth(),
                label = { Text("検索ワード") }
            )
        }
    }
}
