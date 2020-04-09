package com.pavneet_singh.mvvm_flow_coroutine_testing

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.pavneet_singh.mvvm_flow_coroutine_testing.ui.main.ChocolateFragment

/**
 * Created by Pavneet_Singh on 20/03/20.
 */

class MainActivity : AppCompatActivity() {


    /**
     * Load the chocolate fragment
     */
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
