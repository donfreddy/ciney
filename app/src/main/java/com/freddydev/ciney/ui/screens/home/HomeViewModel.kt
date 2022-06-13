package com.freddydev.ciney.ui.screens.home

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.freddydev.ciney.domain.use_case.get_trending.GetTrendingUseCase
import com.freddydev.ciney.ui.common.Constants
import com.freddydev.ciney.util.EnumMediaType
import com.freddydev.ciney.util.EnumsTimeWindow
import com.freddydev.ciney.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
  private val getTrending: GetTrendingUseCase
) : ViewModel() {

  private val _trendingState = mutableStateOf(TrendingState())
  val trendingState: State<TrendingState> = _trendingState

  init {
    getDailyTrending()
  }

  /**
   * Get the daily trending items.
   */
  private fun getDailyTrending() {
    getTrending.execute(
      params = GetTrendingUseCase.Params(
        mediaType = EnumMediaType.ALL.value,
        timeWindow = EnumsTimeWindow.DAY.value,
        page = Constants.DEFAULT_PAGE
      )
    ).onEach { result ->
      when (result) {
        is Resource.Loading -> {
          _trendingState.value = TrendingState(isLoading = true)
        }
        is Resource.Success -> {
          _trendingState.value = TrendingState(trending = result.data)
        }
        is Resource.Error -> {
          _trendingState.value =
            TrendingState(error = result.message ?: Constants.HTTP_EXCEPT_MSG)
        }
      }
    }.launchIn(viewModelScope)
  }
}