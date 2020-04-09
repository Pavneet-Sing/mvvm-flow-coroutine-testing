package com.pavneet_singh.mvvm_flow_coroutine_testing.ui.main.usecase

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

/**
 * Created by Pavneet_Singh on 20/03/20.
 */

class ChocolateUseCase {
    /**
     *  Emit the dummy data with the specified interval delay, default is 6 seconds
     *
     *  @param delay: Long to add delay between response
     *  @param chocolateAction: ChocolateAction to perform network call as per type
     */
    fun getListOfChocolates(
        chocolateAction: ChocolateAction,
        delay: Long = 6000
    ): Flow<ChocolateResult> {
        return flow {
            when (chocolateAction) {
                ChocolateAction.GetChocolateList -> {
                    emit(ChocolateResult.Loading)
                    delay(delay)
                    emit(
                        ChocolateResult.ChocolateList(
                            arrayListOf(
                                ChocolateModel(
                                    "Chocolates are awesome!",
                                    1
                                )
                            )
                        )
                    )
                }
            }
        }
    }
}
