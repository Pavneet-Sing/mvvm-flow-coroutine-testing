package com.pavneet_singh.mvvm_flow_coroutine_testing

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.pavneet_singh.mvvm_flow_coroutine_testing.ui.main.ChocolateFragment
import com.pavneet_singh.mvvm_flow_coroutine_testing.ui.main.ChocolateViewModel
import com.pavneet_singh.mvvm_flow_coroutine_testing.ui.main.di.FactoryProvider.getChocolateViewModelFactory
import com.pavneet_singh.mvvm_flow_coroutine_testing.ui.main.usecase.ChocolateUseCase

/**
 * Created by Pavneet_Singh on 20/03/20.
 */

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                    .replace(R.id.container, ChocolateFragment.newInstance())
                    .commitNow()
        }
    }
}
