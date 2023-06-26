package com.portfolio.mawaqite.DataModels

data class SearchResult(
    val place_id: String,
    val licence: String,
    val osm_type: String,
    val osm_id: String,
    val boundingBox: List<String>,
    val lat: String,
    val lon: String,
    val display_name: String,
    val class_type: String,
    val type: String,
    val importance: Double,
    val icon: String? = null
)
