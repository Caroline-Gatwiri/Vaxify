package com.twish.vaxify.app.data


import com.google.gson.annotations.SerializedName

data class AgeRange(
    @SerializedName("end")
    val end: Int,
    @SerializedName("start")
    val start: Int
)