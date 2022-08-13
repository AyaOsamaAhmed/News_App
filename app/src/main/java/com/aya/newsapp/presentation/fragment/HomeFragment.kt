package com.aya.newsapp.presentation.fragment

import android.R.attr.banner
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import com.aya.newsapp.R
import com.aya.newsapp.databinding.HomeFragmentBinding
import com.aya.newsapp.domain.model.ArticlesModel
import com.aya.newsapp.domain.response.MainResponse
import com.aya.newsapp.presentation.adapter.BannerAdapter
import com.aya.newsapp.presentation.adapter.NewsAdapter
import com.aya.newsapp.presentation.interfaces.onClickDetails
import com.aya.newsapp.presentation.ui.MainActivity
import com.aya.newsapp.presentation.viewModel.HomeViewModel
import com.example.moeidbannerlibrary.banner.BaseBannerAdapter


class HomeFragment : Fragment() , onClickDetails {

    private lateinit var binding : HomeFragmentBinding
    private lateinit var viewModel : HomeViewModel
    private lateinit var adapter : NewsAdapter

    private lateinit var adapterBanner : BannerAdapter

    val mainActivity  by lazy { activity as MainActivity }

    private val navController by lazy {
        val navHostFragment = activity?.supportFragmentManager
            ?.findFragmentById(R.id.homeframelayout) as NavHostFragment
        navHostFragment.navController
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = HomeFragmentBinding.inflate(inflater , container , false)
        viewModel = ViewModelProvider(this).get(HomeViewModel::class.java)

        viewModel.requestBannerLiveData.observe(viewLifecycleOwner, Observer {
            val data = it as MainResponse
            adapter = NewsAdapter(this)
            adapterBanner = BannerAdapter(requireContext(),data.articles)
            binding.Banner.setAdapter(adapterBanner)
            adapter.submitList(data.articles)
            binding.recyclerNews.adapter = adapter
        })

        return binding.root
    }

    override fun onClick(artical: ArticlesModel) {
        navController.navigate(R.id.action_HomeFragment_to_DetailsFragment)
    }
}