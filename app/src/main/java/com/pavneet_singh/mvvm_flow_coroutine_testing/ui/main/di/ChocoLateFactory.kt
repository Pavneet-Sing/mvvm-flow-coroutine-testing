package com.pavneet_singh.mvvm_flow_coroutine_testing.ui.main.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.pavneet_singh.mvvm_flow_coroutine_testing.ui.main.ChocolateViewModel
import com.pavneet_singh.mvvm_flow_coroutine_testing.ui.main.usecase.ChocolateUseCase

/**
 * Created by Pavneet_Singh on 20/03/20.
 */

@Suppress("UNCHECKED_CAST")
class ChocoLateFactory(private val useCase: ChocolateUseCase) :
    ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ChocolateViewModel(useCase) as T
    }
}