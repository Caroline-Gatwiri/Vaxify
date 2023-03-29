package com.twish.vaxify.app.data


import com.google.gson.annotations.SerializedName

data class VaccineDto(
    @SerializedName("diseases_protected")
    val diseasesProtected: List<String>,
    @SerializedName("full_name")
    val fullName: String
)