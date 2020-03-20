package com.pavneet_singh.mvvm_flow_coroutine_testing.ui.main

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import androidx.lifecycle.SavedStateHandle
import com.pavneet_singh.mvvm_flow_coroutine_testing.ui.main.usecase.*
import com.pavneet_singh.temp.MainCoroutineScopeRule
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.mockito.*
import org.mockito.ArgumentMatchers.anyLong

/**
 * Created by Pavneet_Singh on 20/03/20.
 */

class ChocolateViewModelTest {

    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    val coroutineScope = MainCoroutineScopeRule()

    @Mock
    private lateinit var mockObserver: Observer<ChocolateViewState>

    private lateinit var myViewModel: ChocolateViewModel

    @Mock
    private lateinit var useCase: ChocolateUseCase

    @Mock
    private lateinit var chocolateList: List<ChocolateModel>

    private lateinit var viewState: ChocolateViewState

    @Captor
    private lateinit var captor: ArgumentCaptor<ChocolateViewState>


    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        viewState =
            ChocolateViewState()
        myViewModel = ChocolateViewModel(useCase)
    }

    @Test
    fun onOptionsSelected() {
        runBlocking {
            val flow = flow {
                emit(ChocolateResult.Loading)
                delay(10)
                emit(ChocolateResult.ChocolateList(chocolateList))
            }

            Mockito.`when`(useCase.getListOfChocolates(ChocolateAction.GetChocolateList)).thenReturn(flow)
            Mockito.`when`(chocolateList.get(0)).thenReturn(
                ChocolateModel(
                    "Pavneet",
                    1
                )
            )
            val liveData = myViewModel.onOptionsSelected()
            liveData.observeForever(mockObserver) // to trigger the transformation

            Mockito.verify(mockObserver).onChanged(captor.capture()) // loading state has been received
            assertEquals(true, captor.value.loading)
            coroutineScope.advanceTimeBy(10)
            Mockito.verify(mockObserver, Mockito.times(2)).onChanged(captor.capture()) // onchange has been triggered twice
            assertEquals("Pavneet", captor.value.data[0].name) // assert the received value i.e. chocolate state
        }
    }
}