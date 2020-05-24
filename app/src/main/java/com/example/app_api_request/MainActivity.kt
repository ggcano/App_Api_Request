package com.example.app_api_request

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.app_api_request.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    lateinit var viewModel: MainViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        observeData()
    }

    private fun observeData() {
        viewModel.coinData().observe(this, Observer {
            val floatRateUsd = it.coinBpi.usd.rateFloatDTO
            val floatRateGpb = it.coinBpi.gpb.rateFloatDTO
            val floatRateEur = it.coinBpi.eur.rateFloatDTO
            val timeUk = it.time.updatedUk

            label_dollar.text = "$floatRateUsd $"
            label_euro.text = "$floatRateEur €"
            label_libra.text = "$floatRateGpb L"
            label_time_uk.text = timeUk
        })
    }

}