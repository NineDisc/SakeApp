package com.example.sakeapp.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.sakeapp.ui.component.SakeBottomAppBar
import com.example.sakeapp.ui.component.SakeTopAppBar
import com.example.sakeapp.ui.feature.ranking.RankingContents

@Composable
fun SakeApp() {
    Scaffold(
        topBar = { SakeTopAppBar() },
        bottomBar = { SakeBottomAppBar() },
        modifier = Modifier.fillMaxSize()
    ) { padding ->
        Column(modifier = Modifier.padding(padding)) {
//            RankingScreen()
            RankingContents()
        }
    }
}