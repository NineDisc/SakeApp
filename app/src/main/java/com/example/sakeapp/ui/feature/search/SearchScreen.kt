package com.example.sakeapp.ui.feature.search

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.style.TextAlign

@Composable
fun SearchScreen() {
    Text(
        text = "検索画面",
        modifier = Modifier.fillMaxWidth(),
        style = TextStyle(fontSize = 30.sp),
        textAlign = TextAlign.Center
    )
}
