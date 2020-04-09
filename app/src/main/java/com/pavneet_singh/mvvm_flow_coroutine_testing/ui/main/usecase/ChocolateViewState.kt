package com.pavneet_singh.mvvm_flow_coroutine_testing.ui.main.usecase

/**
 * Created by Pavneet_Singh on 20/03/20.
 */

/**
 * State management class for response
 */
data class ChocolateViewState(
    val loading: Boolean = false,
    val data: List<ChocolateModel> = emptyList(),
    val error: String? = null
)

data class ChocolateModel(val name: String = "choco", val id: Int = -1)