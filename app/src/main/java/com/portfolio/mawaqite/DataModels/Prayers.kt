package com.portfolio.mawaqite.DataModels


data class Prayers(

    val hijriDate:String,
    val miladDate:String,

    val fajr: String,
    val sunrise: String,
    val dhuhr: String,
    val asr: String,
    val maghrib: String,
    val isha: String,
    val MidNight: String,
    val FirstThird: String,
    val LasThird: String,

    val locationLatitude:Double,
    val locationLongitude:Double
)

