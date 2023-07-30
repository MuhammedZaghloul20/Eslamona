package com.portfolio.mawaqite

import android.app.Service
import android.app.job.JobParameters
import android.app.job.JobService
import android.content.Intent
import android.os.IBinder
import android.util.Log
import android.widget.Toast

class MyJobService : JobService() {



    override fun onStartJob(p0: JobParameters?): Boolean {
        //Toast.makeText(applicationContext, "Opened", Toast.LENGTH_SHORT).show()
        Toast.makeText(applicationContext, "hello", Toast.LENGTH_SHORT).show()
        jobFinished(p0,true)
       return true
    }

    override fun onStopJob(p0: JobParameters?): Boolean {
        return true
    }
}