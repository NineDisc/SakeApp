package com.example.sakeapp.ui.feature.ranking

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
    val uiState = viewModel.uiState.collectAsState()
    Column {
        Text(
            text = "日本酒ランキング${viewModel.year}年${viewModel.month}月版",
            modifier = Modifier.fillMaxWidth(),
            fontSize = 28.sp,
            textAlign = TextAlign.Center
        )
        LazyColumn(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
//            when(uiState){it ->
//                RankingUiState.Contents -> {
//
//                }
//            }
            items(items = viewModel.rankingList) { item ->
                RankingItem(item = item)
                Divider(thickness = 1.dp, color = Color.Black)
            }
            android.util.Log.d("SEMBA", "aaaa")
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

