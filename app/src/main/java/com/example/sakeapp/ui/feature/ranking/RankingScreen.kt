package com.example.sakeapp.ui.feature.ranking

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.sakeapp.ui.theme.SakeAppTheme

private val dummyList = listOf("獺祭", "田酒", "東洋美人", "八海山")

@Composable
fun RankingScreen() {
    Column {
        Text(
            text = "ランキング",
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center
        )
        LazyColumn(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            items(items = dummyList) { item ->
                RankingItem(itemName = item)
            }
        }
    }
}

@Composable
fun RankingItem(itemName: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
            .background(
                Color.Yellow
            )
    ) {
        Text(text = itemName)
    }
}

@Preview
@Composable
fun RankingScreenPreview(){
    SakeAppTheme {
        RankingScreen()
    }
}

