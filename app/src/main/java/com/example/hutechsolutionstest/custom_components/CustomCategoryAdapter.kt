package com.example.hutechsolutionstest.custom_components

import android.graphics.Paint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.hutechsolutionstest.R
import com.example.hutechsolutionstest.databinding.ItemCustomCategoryBinding

class CustomCategoryAdapter: RecyclerView.Adapter<CustomCategoryAdapter.CustomViewHolder>() {

    private var mCustomCategoryList: List<CustomCategory>? = null

    fun setCustomCatergories(categories: List<CustomCategory>) {
        mCustomCategoryList = categories
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val mCustomElementBinding = DataBindingUtil.inflate<ItemCustomCategoryBinding>(
            LayoutInflater.from(parent.context),
            R.layout.item_custom_category, parent, false
        )

        return CustomViewHolder(mCustomElementBinding)
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        holder.bind(mCustomCategoryList?.let { it[position] })
    }

    override fun getItemCount(): Int {
        return if(mCustomCategoryList!=null) mCustomCategoryList?.size!! else 0
    }

    class CustomViewHolder (val view: ItemCustomCategoryBinding) : RecyclerView.ViewHolder(view.root) {
        fun bind(item: CustomCategory?) {
            view.customCategory = item
        }
    }
}