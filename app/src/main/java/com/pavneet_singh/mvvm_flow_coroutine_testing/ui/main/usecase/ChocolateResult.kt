package com.pavneet_singh.mvvm_flow_coroutine_testing.ui.main.usecase

/**
 * Created by Pavneet_Singh on 20/03/20.
 */

sealed class ChocolateResult {
    object Loading : ChocolateResult()
    data class ChocolateList(val choclateList: List<ChocolateModel>) : ChocolateResult()
    data class Error(val msg: String) : ChocolateResult()
}