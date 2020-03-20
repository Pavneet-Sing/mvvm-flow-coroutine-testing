package com.pavneet_singh.mvvm_flow_coroutine_testing.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.pavneet_singh.mvvm_flow_coroutine_testing.R
import com.pavneet_singh.mvvm_flow_coroutine_testing.ui.main.di.ChocoLateFactory
import com.pavneet_singh.mvvm_flow_coroutine_testing.ui.main.usecase.ChocolateUseCase

/**
 * Created by Pavneet_Singh on 20/03/20.
 */

class ChocolateFragment : Fragment() {

    private lateinit var tvMessage: TextView

    companion object {
        fun newInstance() = ChocolateFragment()
    }

    private lateinit var viewModel : ChocolateViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tvMessage = view.findViewById(R.id.message)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val chocoLateFactory =  ChocoLateFactory(ChocolateUseCase())
        viewModel = ViewModelProvider(this,chocoLateFactory).get(ChocolateViewModel::class.java)
        viewModel.onOptionsSelected().observe(viewLifecycleOwner, Observer {
            if(it.loading){
                tvMessage.text = "Loading"
            }else if(!it.loading && it.data.isNotEmpty()){
                tvMessage.text = it.run{ "${it.data[0].name} Now run the test" }
            }else{
                tvMessage.text = "Error"
            }
        })
    }

}
