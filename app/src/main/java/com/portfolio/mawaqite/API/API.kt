package com.portfolio.mawaqite.API

import com.portfolio.mawaqite.DataModels.Hadith
import com.portfolio.mawaqite.DataModels.PrayerTimeForAPI
import com.portfolio.mawaqite.DataModels.SearchResult
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface API {


    @GET("timings/{date}")
    suspend fun getPrayerTimer(@Path("date") date:String
                               ,@Query("latitude") latitude:Double
                               ,@Query("longitude") longitude: Double):Response<PrayerTimeForAPI>
    @GET("one/")
    suspend fun getAhadeeth(@Query("language") language:String="ar",@Query("id") id:Int):Response<Hadith>

    @GET("search")
    suspend  fun getFineLocation(@Query("key") key:String="pk.8ddd3ddc07d109011830319bf8ae56fa",@Query("q") country:String,@Query("format")format:String="json",@Query("accept-language")accept_language:String="ar"): Response<List<SearchResult>>
}