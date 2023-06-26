package com.portfolio.mawaqite.API

import com.portfolio.mawaqite.API.Constants.Companion.BASE_URL
import com.portfolio.mawaqite.API.Constants.Companion.BASE_URL_FOR_COUNTRY
import com.portfolio.mawaqite.API.Constants.Companion.BASE_URL_FOR_HADEETH
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(API::class.java)
    }

}
object RetrofitInstanceHadeeth{
    val retrofit by lazy {
        Retrofit.Builder().baseUrl(BASE_URL_FOR_HADEETH).addConverterFactory(GsonConverterFactory.create()).build().create(API::class.java)
    }
}
object RetrofitInstanceLocation {
    val retrofit by lazy {
        Retrofit.Builder().baseUrl(BASE_URL_FOR_COUNTRY).addConverterFactory(GsonConverterFactory.create()).build().create(API::class.java)
    }
}