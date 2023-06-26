package com.portfolio.mawaqite

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.portfolio.mawaqite.API.RetrofitInstance
import com.portfolio.mawaqite.databinding.ActivityMainBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.text.SimpleDateFormat
import java.util.Date

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val dateFormat = SimpleDateFormat("dd-MM-yyyy")
        val date = dateFormat.format(Date())
        GlobalScope.launch(Dispatchers.IO) {
            val response = RetrofitInstance.retrofit.getPrayerTimer(date, 30.033333, 31.233334)
            if (response.isSuccessful) {
                withContext(Dispatchers.Main)
                {
                    binding.fajr.text = response!!.body()?.data?.timings?.Fajr
                    binding.shrouk.text =response!!.body()?.data?.timings?.Sunrise
                    binding.duhur.text = response!!.body()?.data?.timings?.Dhuhr
                    binding.asr.text = response!!.body()?.data?.timings?.Asr
                    binding.maghrb.text =response!!.body()?.data?.timings?.Maghrib
                    binding.isha.text =response!!.body()?.data?.timings?.Isha
                }
            }
        }


    }
}