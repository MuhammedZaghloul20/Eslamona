package com.portfolio.mawaqite

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.portfolio.eslamona.databinding.ActivityMainBinding
import com.portfolio.mawaqite.ConnectivityChecking.NetworkObserver
import com.portfolio.mawaqite.Service.MajorService


class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    lateinit var networkObserver: NetworkObserver
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        startService(Intent(this, MajorService::class.java))
        Toast.makeText(applicationContext, "start", Toast.LENGTH_SHORT).show()


//        val dateFormat = SimpleDateFormat("dd-MM-yyyy")
//        val date = dateFormat.format(Date())
//        GlobalScope.launch(Dispatchers.IO) {
//            val response = RetrofitInstance.retrofit.getPrayerTimer(date, 30.033333, 31.233334)
//            if (response.isSuccessful) {
//                withContext(Dispatchers.Main)
//                {
//                    binding.fajr.text = response!!.body()?.data?.timings?.Fajr
//                    binding.shrouk.text =response!!.body()?.data?.timings?.Sunrise
//                    binding.duhur.text = response!!.body()?.data?.timings?.Dhuhr
//                    binding.asr.text = response!!.body()?.data?.timings?.Asr
//                    binding.maghrb.text =response!!.body()?.data?.timings?.Maghrib
//                    binding.isha.text =response!!.body()?.data?.timings?.Isha
//                }
//            }
//        }


    }
}