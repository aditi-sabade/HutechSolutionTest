package com.example.hutechsolutionstest.Explore

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.hutechsolutionstest.R
import com.example.hutechsolutionstest.adapters.CategoryListAdapter
import com.example.hutechsolutionstest.custom_components.CustomCategory
import com.example.hutechsolutionstest.models.Categorydatum
import kotlinx.android.synthetic.main.fragment_explore.*

class ExploreFragment : Fragment() {

    private lateinit var viewModel: ExploreViewModel
    val adapter = CategoryListAdapter()

    val dailyDealsObserver: Observer<List<CustomCategory>> by lazy {
        Observer {
            //adapter.setCatergories(it)
            daily_deals.setData(it)

        }
    }

    val newArrivalObserver: Observer<List<CustomCategory>> by lazy {
        Observer {
            new_arrivals.setData(it)
        }
    }

    val categoryObserver: Observer<List<Categorydatum>> by lazy {
        Observer {
            adapter.setCatergories(it)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_explore, container, false)
        viewModel = ViewModelProvider(this).get(ExploreViewModel::class.java)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        category_recycler_view.adapter = adapter
        viewModel.start()
        viewModel.getNewArrival()
        viewModel.makeAPICall()
        observeData()
    }

    fun observeData() {
        viewModel.getDailyDeals().observe(requireActivity(), dailyDealsObserver)
        viewModel.getNewArrivals().observe(requireActivity(), newArrivalObserver)
        viewModel.getCategories().observe(requireActivity(), categoryObserver)
        viewModel.getBanner1().observe(requireActivity(), Observer {
            Glide.with(requireActivity())
                .load(it)
                .placeholder(R.mipmap.ic_launcher)
                .into(banner_first)
        })
        viewModel.getBanner2().observe(requireActivity(), Observer {
            Glide.with(requireActivity())
                .load(it)
                .placeholder(R.mipmap.ic_launcher)
                .into(banner_second)
            Glide.with(requireActivity())
                .load(it)
                .placeholder(R.mipmap.ic_launcher)
                .into(banner_third)
        })
    }
}