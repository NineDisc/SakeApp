package com.example.sakeapp.ui.feature.search

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.sakeapp.ui.theme.*
import kotlinx.coroutines.delay

@Composable
fun SearchScreen(viewModel: SearchViewModel) {
    var searchText by remember { mutableStateOf("") }
    var isLoading by remember { mutableStateOf(true) }

    // 仮のローディング
    LaunchedEffect(Unit) {
        delay(1000)
        isLoading = false
    }

    if (isLoading) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator()
        }
    } else {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Grey10),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            TopSearchBar(
                searchText = searchText,
                onSearchTextChange = { searchText = it },
                onSearch = { viewModel.fetchSearch(searchText) }
            )

            SearchResulList(searchResult = viewModel.searchResult.value)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun TopSearchBar(
    searchText: String,
    onSearchTextChange: (String) -> Unit,
    onSearch: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .background(Grey40, shape = RoundedCornerShape(8.dp)),
        contentAlignment = Alignment.Center
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            // 検索ボタン
            IconButton(
                onClick = onSearch
            ) {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "Search Icon",
                    tint = Grey70
                )
            }

            Spacer(modifier = Modifier.width(8.dp))

            TextField(
                value = searchText,
                onValueChange = onSearchTextChange,
                placeholder = { Text("銘柄検索") },
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Grey30,
                    cursorColor = BlueGrey,
                    focusedIndicatorColor = Grey60,
                    unfocusedIndicatorColor = Grey40
                ),
                modifier = Modifier.fillMaxWidth(),
                singleLine = true,
                maxLines = 1
            )
        }
    }
}

@Composable
private fun SearchResulList(searchResult: String?) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "検索結果",
                style = TextStyle(fontSize = 20.sp),
                modifier = Modifier.padding(bottom = 16.dp)
            )

            // 検索結果を表示
            searchResult?.let { result ->
                Column(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    // TODO:  検索結果アイテム（仮）
                    result.split(" ").forEachIndexed { index, item ->
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 8.dp)
                                .background(Color.LightGray, shape = RoundedCornerShape(8.dp))
                                .padding(16.dp)
                        ) {
                            Text(
                                text = "$item $index",
                                style = TextStyle(fontSize = 16.sp)
                            )
                        }
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun SearchScreenPreview() {
    SakeAppTheme {
        SearchScreen(viewModel = SearchViewModel())
    }
}
