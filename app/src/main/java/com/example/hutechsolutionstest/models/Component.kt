package com.example.hutechsolutionstest.models

import com.google.gson.annotations.SerializedName

data class Component(
    @SerializedName("name") val name :String,
    @SerializedName("StaticBanner") val staticBanner:List<StaticBanner>,
    @SerializedName("categorydata") val categorydata:List<Categorydatum>,
    @SerializedName("AdsBanner") val adsBanner:List<AdsBanner>,
    @SerializedName("CarouselBanner") val carouselBanner:List<Object>
    )