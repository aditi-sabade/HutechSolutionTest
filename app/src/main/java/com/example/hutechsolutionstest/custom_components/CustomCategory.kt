package com.example.hutechsolutionstest.custom_components

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.example.hutechsolutionstest.R
import com.example.hutechsolutionstest.networking.RetrofitClient

data class CustomCategory(val image_src: String, val name: String, val price: String,
                            val offer_price: String) {
    companion object {
        @JvmStatic
        @BindingAdapter("customImageSrc")
        fun loadImage(imageView: ImageView, imageURL: String) {
            Glide.with(imageView.context)
                .load(imageURL)
                .placeholder(R.mipmap.ic_launcher)
                .into(imageView)
        }
    }
}
