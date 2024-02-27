package com.example.sakeapp.ui.feature.ranking

import com.example.sakeapp.model.SakeRanking

sealed class RankingUiState {
    data object Initial: RankingUiState()
    data class Contents(val contents: MutableList<SakeRanking>) : RankingUiState()
}