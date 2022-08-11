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
import com.aya.newsapp.domain.response.MainResponse
import com.aya.newsapp.presentation.adapter.BannerAdapter
import com.aya.newsapp.presentation.adapter.NewsAdapter
import com.aya.newsapp.presentation.ui.MainActivity
import com.aya.newsapp.presentation.viewModel.HomeViewModel
import com.example.moeidbannerlibrary.banner.BaseBannerAdapter


class HomeFragment : Fragment() {

    private lateinit var binding : HomeFragmentBinding
    private lateinit var viewModel : HomeViewModel
    private lateinit var adapter : NewsAdapter

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


        val urls: MutableList<String> = ArrayList()
        urls.add("https://helpx.adobe.com/content/dam/help/en/photoshop/using/convert-color-image-black-white/jcr_content/main-pars/before_and_after/image-before/Landscape-Color.jpg")
        urls.add("https://helpx.adobe.com/content/dam/help/en/photoshop/using/convert-color-image-black-white/jcr_content/main-pars/before_and_after/image-before/Landscape-Color.jpg")
        urls.add("https://helpx.adobe.com/content/dam/help/en/photoshop/using/convert-color-image-black-white/jcr_content/main-pars/before_and_after/image-before/Landscape-Color.jpg")
        urls.add("https://helpx.adobe.com/content/dam/help/en/photoshop/using/convert-color-image-black-white/jcr_content/main-pars/before_and_after/image-before/Landscape-Color.jpg")
        urls.add("https://helpx.adobe.com/content/dam/help/en/photoshop/using/convert-color-image-black-white/jcr_content/main-pars/before_and_after/image-before/Landscape-Color.jpg")

        val webBannerAdapter = BannerAdapter(context!!, urls)
        webBannerAdapter.setOnBannerItemClickListener { }
        binding.Banner.setAdapter(webBannerAdapter)


        viewModel.requestBannerLiveData.observe(viewLifecycleOwner, Observer {
            val data = it as MainResponse
            adapter = NewsAdapter()
            adapter.submitList(data.articles)
            binding.recyclerNews.adapter = adapter
        })

        return binding.root
    }
}