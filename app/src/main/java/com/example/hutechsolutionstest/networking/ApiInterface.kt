package com.example.hutechsolutionstest.networking

import com.example.hutechsolutionstest.models.HomeTestResponse
import retrofit2.Call
import retrofit2.http.POST
import retrofit2.http.Query

interface ApiInterface {
    @POST("home_test_section")
    fun getCategories(@Query("category_id") category_id: Int = 2): Call<HomeTestResponse>
}