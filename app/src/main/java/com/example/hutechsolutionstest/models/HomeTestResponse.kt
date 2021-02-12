package com.example.hutechsolutionstest.models

import com.google.gson.annotations.SerializedName

data class HomeTestResponse(
    @SerializedName("success") val success: Boolean,
    @SerializedName("components") val components: List<Component>
)