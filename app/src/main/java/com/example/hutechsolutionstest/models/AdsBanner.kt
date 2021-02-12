package com.example.hutechsolutionstest.models

import com.google.gson.annotations.SerializedName

data class AdsBanner(
    @SerializedName("banner_id") val bannerId: Int,
    @SerializedName("banner_name") val bannerName: String,
    @SerializedName("banner_description") val bannerDescription: String,
    @SerializedName("banner_alt") val bannerAlt: String,
    @SerializedName("banner_image") val bannerImage: String
)
