package com.example.sakeapp.ui.feature.ranking

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.sakeapp.model.SakeRanking
import com.example.sakeapp.ui.theme.SakeAppTheme

@Composable
fun RankingContents() {
    val viewModel = RankingViewModel()
    RankingScreen(viewModel)
}

@Composable
fun RankingScreen(viewModel: RankingViewModel) {
    viewModel.fetch()
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        when (uiState) {
            is RankingUiState.Contents -> {
                Text(
                    text = "日本酒ランキング${(uiState as RankingUiState.Contents).year}年${(uiState as RankingUiState.Contents).month}月版",
                    modifier = Modifier.fillMaxWidth(),
                    fontSize = 28.sp,
                    textAlign = TextAlign.Center
                )
                LazyColumn(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(),
                    verticalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    items(items = (uiState as RankingUiState.Contents).contents) { item ->
                        RankingItem(item = item)
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
fun RankingItem(item: SakeRanking) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .padding(16.dp)
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

@Preview
@Composable
fun RankingScreenPreview() {
    SakeAppTheme {
//        RankingScreen()
    }
}

@Preview
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

