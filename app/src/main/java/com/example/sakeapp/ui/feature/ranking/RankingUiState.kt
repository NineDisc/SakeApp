package com.example.sakeapp.ui.feature.ranking

import com.example.sakeapp.model.SakeRanking

sealed interface RankingUiState {
    data object Initial : RankingUiState
    data class Contents(
        val contents: MutableList<SakeRanking>,
        val year: String,
        val month: String
    ) : RankingUiState
}