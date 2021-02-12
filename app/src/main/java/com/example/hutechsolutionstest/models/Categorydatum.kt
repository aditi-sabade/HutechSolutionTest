package com.example.hutechsolutionstest.models

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.example.hutechsolutionstest.R
import com.example.hutechsolutionstest.networking.RetrofitClient
import com.google.gson.annotations.SerializedName

data class Categorydatum(
    @SerializedName("category_id") val categoryId: Int,
    @SerializedName("category_name") val categoryName: String,
    @SerializedName("category_description") val categoryDescription: String,
    @SerializedName("category_picture") val categoryPicture: String
){
    companion object {
        @JvmStatic
        @BindingAdapter("categoryImageSrc")
        fun loadImage(imageView: ImageView, imageURL: String) {
            Glide.with(imageView.context)
                .load(RetrofitClient.imageUrl+imageURL)
                .placeholder(R.mipmap.ic_launcher)
                .into(imageView)
        }
    }
}
