package com.example.hutechsolutionstest.Explore

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.hutechsolutionstest.custom_components.CustomCategoriesRepo
import com.example.hutechsolutionstest.custom_components.CustomCategory
import com.example.hutechsolutionstest.models.Categorydatum
import com.example.hutechsolutionstest.models.HomeTestResponse
import com.example.hutechsolutionstest.networking.RetrofitClient
import retrofit2.Call
import retrofit2.Response

class ExploreViewModel: ViewModel() {

    private var categoryListLiveData: MutableLiveData<List<CustomCategory>> = MutableLiveData()
    private var newArrivalListLiveData: MutableLiveData<List<CustomCategory>> = MutableLiveData()
    private var categoryListLiveData1: MutableLiveData<List<Categorydatum>> = MutableLiveData()
    private var banner1: MutableLiveData<String> = MutableLiveData()
    private var banner2: MutableLiveData<String> = MutableLiveData()


    fun getDailyDeals() : MutableLiveData<List<CustomCategory>> = categoryListLiveData

    fun getNewArrivals() : MutableLiveData<List<CustomCategory>> = newArrivalListLiveData

    fun getCategories() : MutableLiveData<List<Categorydatum>> = categoryListLiveData1

    fun getBanner1() : MutableLiveData<String> = banner1

    fun getBanner2() : MutableLiveData<String> = banner2

    fun start(){
        categoryListLiveData.postValue(CustomCategoriesRepo.getDailyDealsList())
    }

    fun getNewArrival() {
        newArrivalListLiveData.postValue(CustomCategoriesRepo.getNewArrivalsList())
    }

    fun makeAPICall(){
        val cal = RetrofitClient.apiInterface.getCategories()

        cal.enqueue(object : retrofit2.Callback<HomeTestResponse> {
            override fun onResponse(
                call: Call<HomeTestResponse>,
                response: Response<HomeTestResponse>
            ) {
                if(response.isSuccessful){
                    Log.i("TAG","response --> ${response.body()}")
                    categoryListLiveData1.postValue(response.body()?.components?.get(1)?.categorydata)
                    banner1.postValue(RetrofitClient.imageUrl+response.body()?.components?.get(0)?.staticBanner?.get(0)?.bannerImage)
                    banner2.postValue(RetrofitClient.imageUrl+response.body()?.components?.get(2)?.adsBanner?.get(0)?.bannerImage)
                }
            }

            override fun onFailure(call: Call<HomeTestResponse>, t: Throwable) {
                Log.i("TAG",t.message)
            }
        })
    }
}