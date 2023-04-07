package com.twish.vaxify.app.data

data class RequestModel(
    val childName: String,
    val guardianName : String,
    val location :String,
    val age : Int,
    val gender: String
)
