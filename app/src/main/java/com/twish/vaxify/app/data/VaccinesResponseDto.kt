package com.twish.vaxify.app.data


import com.google.gson.annotations.SerializedName

data class VaccinesResponseDto(
    @SerializedName("vaccines")
    val data: List<AgeGroupDto>
)