package com.example.sakeapp.ui.feature.search

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.sakeapp.ui.theme.*

@Composable
fun SearchContents() {
    val viewModel = SearchViewModel()
    SearchScreen(viewModel)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun SearchScreen(viewModel: SearchViewModel) {

    var zipCodeInput by remember { mutableStateOf("") }

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
                value = zipCodeInput,
                onValueChange = { zipCodeInput = it },
                modifier = Modifier.weight(0.7f),
                label = { Text("検索ワード") },
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Grey10, // 背景の色
                    focusedIndicatorColor = Grey70, // フォーカス時のインジケータ（下線）の色
                    unfocusedIndicatorColor = Grey60, // 非フォーカス時のインジケータ（下線）の色
                    cursorColor = Grey50 // カーソルの色
                )
            )

            // 検索ボタン
            IconButton(onClick = { /*TODO クリックイベント*/ }) {
                Icon(
                    Icons.Filled.Search,
                    modifier = Modifier.size(40.dp).weight(0.3f),
                    contentDescription = "Search",
                    tint = BlueGrey
                )
            }
        }
    }
}

@Composable
@Preview
private fun SearchScreenPreview() {
    SearchContents()
}
