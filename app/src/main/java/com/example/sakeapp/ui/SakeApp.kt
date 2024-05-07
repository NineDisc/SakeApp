package com.example.sakeapp.ui

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.animation.shrinkOut
import androidx.compose.animation.slideIn
import androidx.compose.animation.slideOut
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.IntSize
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.sakeapp.ui.component.SakeBottomAppBar
import com.example.sakeapp.ui.component.SakeTopAppBar
import com.example.sakeapp.ui.feature.ranking.RankingContents

@Composable
fun SakeApp() {
    val navController = rememberNavController()
    val enterAnimation = slideIn(tween(100, easing = LinearOutSlowInEasing)) {
        IntOffset(it.width / 4, 100)
    }
    val exitAnimation = slideOut(tween(100, easing = FastOutSlowInEasing)) {
        IntOffset(-180, 50)
    }


    Scaffold(
        topBar = { SakeTopAppBar(navController) },
        bottomBar = { SakeBottomAppBar(navController) },
        modifier = Modifier.fillMaxSize()
    ) { padding ->
        Column(modifier = Modifier.padding(padding)) {
            NavHost(
                navController = navController,
                startDestination = "ranking",
                enterTransition = {
                    scaleIn(
                        animationSpec = tween(220, delayMillis = 90),
                        initialScale = 2f
                    ) + fadeIn(animationSpec = tween(220, delayMillis = 90))
                },
                exitTransition = {
                    scaleOut(
                        animationSpec = tween(
                            durationMillis = 220,
                            delayMillis = 90
                        ), targetScale = 2f
                    ) + fadeOut(tween(delayMillis = 90))
                },
                popEnterTransition = {
                    expandVertically { 200 }
                },
                popExitTransition = {
                    shrinkOut { IntSize(200, 300) }
                }) {
                composable("ranking") { RankingContents() }
                composable("starScreen") { StarIconScreen() }
                composable("search") { SearchScreen() }
            }
        }
    }
}