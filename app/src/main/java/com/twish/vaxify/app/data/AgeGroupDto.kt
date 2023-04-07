package com.twish.vaxify.app.data


import com.google.gson.annotations.SerializedName

data class AgeGroupDto(
    @SerializedName("age")
    val age: String,
    @SerializedName("age_range")
    val ageRange: AgeRange,
    @SerializedName("vaccines")
    val vaccines: List<VaccineDto>
)