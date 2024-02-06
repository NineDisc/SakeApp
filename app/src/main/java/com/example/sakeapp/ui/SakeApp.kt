package com.example.sakeapp.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.sakeapp.ui.component.SakeBottomAppBar
import com.example.sakeapp.ui.component.SakeTopAppBar
import com.example.sakeapp.ui.feature.ranking.RankingContents
import androidx.navigation.compose.composable

@Composable
fun SakeApp() {
    val navController = rememberNavController()

    Scaffold(
        topBar = { SakeTopAppBar() },
        bottomBar = { SakeBottomAppBar(navController) },
        modifier = Modifier.fillMaxSize()
    ) { padding ->
        Column(modifier = Modifier.padding(padding)) {
            NavHost(navController = navController, startDestination = "ranking"){
                composable("ranking") { RankingContents() }
                composable("starScreen") { StarIconScreen() }
            }
        }
    }
}