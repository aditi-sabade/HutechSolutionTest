package com.example.hutechsolutionstest.custom_components

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import com.example.hutechsolutionstest.R
import kotlinx.android.synthetic.main.custom_component.view.*

class CustomComponent @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {

    private val adapter = CustomCategoryAdapter()

    init {
        LayoutInflater.from(context).inflate(R.layout.custom_component, this, true)
        orientation = VERTICAL

        attrs?.let {
            val typedArray = context.obtainStyledAttributes(
                it,
                R.styleable.custom_component_attributes,
                0,
                0
            )
            val title = resources.getText(
                typedArray
                    .getResourceId(
                        R.styleable.custom_component_attributes_custom_component_title,
                        R.string.component_one
                    )
            )

            custom_textView.text = title

            typedArray.recycle()
        }
        custom_recyclerview.adapter = adapter
    }
    fun setData(customCategoryList: List<CustomCategory>){
        adapter.setCustomCatergories(customCategoryList)
    }
}