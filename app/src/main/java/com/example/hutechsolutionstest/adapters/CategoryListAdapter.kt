package com.example.hutechsolutionstest.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.hutechsolutionstest.R
import com.example.hutechsolutionstest.databinding.ItemCategoriesBinding
import com.example.hutechsolutionstest.models.Categorydatum

class CategoryListAdapter : RecyclerView.Adapter<CategoryListAdapter.MyViewHolder>() {

    private var mCategoryList: List<Categorydatum>? = null

    fun setCatergories(categories: List<Categorydatum>) {
        mCategoryList = categories
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val mListElementBinding = DataBindingUtil.inflate<ItemCategoriesBinding>(
            LayoutInflater.from(parent.context),
            R.layout.item_categories, parent, false
        )
        return MyViewHolder(mListElementBinding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(mCategoryList?.let { it.get(position)  })
    }

    override fun getItemCount(): Int {
        return if(mCategoryList!=null && mCategoryList?.size!!>9) 9 else 0
    }

    inner class MyViewHolder(val view: ItemCategoriesBinding) : RecyclerView.ViewHolder(view.root) {
        fun bind(item: Categorydatum?) {
            view.categorydatum = item
        }
    }

}