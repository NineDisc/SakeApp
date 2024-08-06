package com.example.sakeapp.ui.feature.ranking

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.sakeapp.model.SakeRanking

val INITIAL_SAKE = SakeRanking(-1, "", "", "")

@Composable
fun RankingContents() {
    val viewModel = RankingViewModel()
    viewModel.fetch()
    RankingScreen(viewModel)
}

@Composable
fun RankingScreen(viewModel: RankingViewModel) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    val tappedItem = remember {
        mutableStateOf(INITIAL_SAKE)
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        when (uiState) {
            is RankingUiState.Contents -> {
                val currentState = uiState as RankingUiState.Contents
                if (tappedItem.value.rank != -1) {
                    RankingItemDialog(tappedItem.value) {
                        tappedItem.value = INITIAL_SAKE
                    }
                }
                Text(
                    text = "日本酒ランキング${currentState.year}年${currentState.month}月版",
                    modifier = Modifier.fillMaxWidth(),
                    fontSize = 28.sp,
                    textAlign = TextAlign.Center
                )
                LazyColumn(
                    verticalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    items(items = currentState.contents) { item ->
                        RankingItem(item = item) {
                            tappedItem.value = item
                        }
                        HorizontalDivider(thickness = 1.dp, color = Color.Black)
                    }
                }
            }

            else -> {
                CircularProgressIndicator()
            }
        }
    }
}

@Composable
fun RankingItem(item: SakeRanking, onClick: () -> Unit = {}) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .clickable {
                onClick()
            }
    ) {
        Text(
            text = "${item.rank}位",
            fontSize = 48.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )

        Text(text = item.name, fontSize = 36.sp)
        Text(text = "${item.breweries}  ${item.area}")
    }

}

@Composable
fun RankingItemDialog(item: SakeRanking, onDismiss: () -> Unit) {
    AlertDialog(onDismissRequest = { onDismiss() }, confirmButton = {
        TextButton(onClick = { onDismiss() }) {
            Text(text = "閉じる")
        }
    }, title = {
        Text(text = item.name)
    }, text = {
        Text(text = "順位：${item.rank}位\n 酒造：${item.breweries}")
    })
}

@Preview(showBackground = true)
@Composable
fun RankingItemPreview() {
    val item = SakeRanking(
        rank = 1,
        name = "田酒",
        breweries = "新政酒造",
        area = "秋田県"
    )

    RankingItem(item = item)
}

