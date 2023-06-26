package com.portfolio.mawaqite.API

import android.content.Context
import android.net.ConnectivityManager
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import com.portfolio.mawaqite.GlobalSharedPreference
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.Date

class Repository(val context:Context) {
    private val pref = GlobalSharedPreference.getInstance(context)

    fun getTimesAPI(lat:Double,long:Double) {
        val dateFormat = SimpleDateFormat("dd-MM-yyyy")
        val date = dateFormat.format(Date())
        GlobalScope.launch(Dispatchers.IO) {
            val response = RetrofitInstance.retrofit.getPrayerTimer(date, lat, long)
            if (response.isSuccessful) {

                pref.setValue("fajr", response.body()!!.data.timings.Fajr)
                pref.setValue("sunRaise", response.body()!!.data.timings.Sunrise)
                pref.setValue("dhuhr", response.body()!!.data.timings.Dhuhr)
                pref.setValue("asr", response.body()!!.data.timings.Asr)
                pref.setValue("maghrib", response.body()!!.data.timings.Maghrib)
                pref.setValue("isha", response.body()!!.data.timings.Isha)
                Log.i("Main","updated")
            }


        }
    }

    fun getTimesPref(): MutableLiveData<Array<String>> {

        if(isInternetConnected(context))
            getTimesAPI(
                 30.033333,
                 31.233334
            )

        val timesLiveData = MutableLiveData<Array<String>>()
        timesLiveData.value = arrayOf(
            pref.getValue("fajr", "3:30").toString(),
            pref.getValue("sunRaise", "5:00").toString(),
            pref.getValue("dhuhr", "11:55").toString(),
            pref.getValue("asr", "3:30").toString(),
            pref.getValue("maghrib", "6:30").toString(),
            pref.getValue("isha", "7:50").toString()
        )

        return timesLiveData
    }
    fun isInternetConnected(context: Context): Boolean {
        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork = connectivityManager.activeNetworkInfo
        return activeNetwork != null && activeNetwork.isConnectedOrConnecting
    }

}