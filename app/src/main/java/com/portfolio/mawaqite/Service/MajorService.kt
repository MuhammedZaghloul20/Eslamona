package com.portfolio.mawaqite.Service

import android.app.Service
import android.app.job.JobInfo
import android.app.job.JobScheduler
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.os.IBinder
import android.util.Log
import android.widget.Toast
import com.portfolio.mawaqite.MyJobService
import java.util.Calendar

class MajorService : Service() {

    override fun onBind(intent: Intent): IBinder {
        TODO("Return the communication channel to the service.")
    }

    override fun onCreate() {
        super.onCreate()
        Toast.makeText(this, "main service", Toast.LENGTH_SHORT).show()
        Log.i("main","service")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {

        val timeInMillis = getTimeInMillisForDesiredTime(0, 0)

        val con= ComponentName(this, MyJobService::class.java)
        val jobInfo= JobInfo.Builder(10,con)
            //.setMinimumLatency(5000)
            .setRequiredNetworkType(JobInfo.NETWORK_TYPE_ANY)

            //.setMinimumLatency(timeInMillis) // Start the job at the desired time
            //.setOverrideDeadline(timeInMillis) // The job will run within this time window
            .build()


        val schedule = getSystemService(JOB_SCHEDULER_SERVICE) as JobScheduler
        schedule.schedule(jobInfo)


        return START_STICKY
    }
    // Utility function to get the time in milliseconds for a specific hour and minute of the day
    private fun getTimeInMillisForDesiredTime(hourOfDay: Int, minute: Int): Long {
        val calendar = Calendar.getInstance()
        calendar.set(Calendar.HOUR_OF_DAY, hourOfDay)
        calendar.set(Calendar.MINUTE, minute)
        calendar.set(Calendar.SECOND, 0)
        calendar.set(Calendar.MILLISECOND, 0)

        val currentTimeInMillis = System.currentTimeMillis()
        val desiredTimeInMillis = calendar.timeInMillis

        // If the desired time is in the past, add one day to schedule it for the next day
        if (currentTimeInMillis > desiredTimeInMillis) {
            calendar.add(Calendar.DAY_OF_MONTH, 1)
        }

        return calendar.timeInMillis
    }
}

