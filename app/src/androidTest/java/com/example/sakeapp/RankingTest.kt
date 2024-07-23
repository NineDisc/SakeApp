package com.example.sakeapp

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.sakeapp.model.SakeRanking
import com.example.sakeapp.ui.feature.ranking.RankingItem
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class RankingTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun checkComponentTest() {
        val testSake = SakeRanking(1, "獺祭", "宝酒造", "北海道")
        composeTestRule.setContent {
            RankingItem(testSake)
        }
        composeTestRule.onNodeWithText("獺祭").assertIsDisplayed()
    }
}