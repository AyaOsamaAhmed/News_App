package com.aya.newsapp.presentation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import com.aya.newsapp.R
import com.aya.newsapp.databinding.HomeFragmentBinding
import com.aya.newsapp.presentation.ui.MainActivity
import com.aya.newsapp.presentation.viewModel.HomeViewModel

class HomeFragment : Fragment() {

    private lateinit var binding : HomeFragmentBinding
    private lateinit var viewModel : HomeViewModel

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



        return binding.root
    }
}