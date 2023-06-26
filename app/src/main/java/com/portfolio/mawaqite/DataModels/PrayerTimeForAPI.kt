package com.portfolio.mawaqite.DataModels


data class PrayerTimeForAPI(

    val code: Int,
    val status: String,
    val data: PrayerTimeDataEntity
)


data class PrayerTimeDataEntity(
    val timings: PrayerTimingsEntity,
    val date: PrayerDateEntity,
    val meta: PrayerMetaDataEntity
)


data class PrayerTimingsEntity(
    val Fajr: String,
    val Sunrise: String,
    val Dhuhr: String,
    val Asr: String,
    val Sunset: String,
    val Maghrib: String,
    val Isha: String,
    val Imsak: String,
    val Midnight: String,
    val Firstthird: String,
    val Lastthird: String
)


data class PrayerDateEntity(
    val readable: String,
    val timestamp: String,
    val hijri: HijriDateEntity,
    val gregorian: GregorianDateEntity
)


data class HijriDateEntity(
    val date: String,
    val format: String,
    val day: String,
    val weekday: WeekdayEntity,
    val month: MonthEntity,
    val year: String,
    val designation: DesignationEntity,
    val holidays: List<String>
)


data class WeekdayEntity(
    val en: String,
    val ar: String
)


data class MonthEntity(
    val number: Int,
    val en: String,
    val ar: String
)


data class DesignationEntity(
    val abbreviated: String,
    val expanded: String
)


data class GregorianDateEntity(
    val date: String,
    val format: String,
    val day: String,
    val weekday: WeekdayEntity,
    val month: MonthEntity,
    val year: String,
    val designation: DesignationEntity
)


data class PrayerMetaDataEntity(
    val latitude: Double,
    val longitude: Double,
    val timezone: String,
    val method: PrayerMethodEntity,
    val latitudeAdjustmentMethod: String,
    val midnightMode: String,
    val school: String,
    val offset: PrayerOffsetEntity
)


data class PrayerMethodEntity(
    val id: Int,
    val name: String,
    val params: PrayerParamsEntity,
    val location: PrayerLocationEntity
)


data class PrayerParamsEntity(
    val Fajr: Double,
    val Isha: Double
)


data class PrayerLocationEntity(
    val latitude: Double,
    val longitude: Double
)


data class PrayerOffsetEntity(
    val Imsak: Int,
    val Fajr: Int,
    val Sunrise: Int,
    val Dhuhr: Int,
    val Asr: Int,
    val Maghrib: Int,
    val Sunset: Int,
    val Isha: Int,
    val Midnight: Int
)