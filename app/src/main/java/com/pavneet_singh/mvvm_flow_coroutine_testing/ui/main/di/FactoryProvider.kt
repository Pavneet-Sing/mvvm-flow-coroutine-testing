package com.pavneet_singh.mvvm_flow_coroutine_testing.ui.main.di

import androidx.lifecycle.ViewModelProvider
import com.pavneet_singh.mvvm_flow_coroutine_testing.ui.main.usecase.ChocolateUseCase

/**
 * Created by Pavneet_Singh on 20/03/20.
 */

object FactoryProvider {
    fun getChocolateViewModelFactory(useCase: ChocolateUseCase) = ChocoLateFactory(useCase)
}