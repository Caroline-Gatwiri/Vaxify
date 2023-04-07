package com.twish.vaxify.app.data

import com.google.gson.annotations.SerializedName

data class ChildModel(
    @SerializedName("child_name")
    val childName: String,
    @SerializedName("guardian_name")
    val guardianName : String,
    @SerializedName("guardian_phone")
    val guardianPhone : String,
    val location :String,
    val age : String,
    val gender: String
)
