package com.aya.newsapp.presentation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.aya.newsapp.databinding.DetailsFragmentBinding
import com.aya.newsapp.databinding.SearchFragmentBinding
import com.aya.newsapp.presentation.viewModel.DetailsViewModel
import com.aya.newsapp.presentation.viewModel.SearchViewModel

class SearchFragment : Fragment() {

    private lateinit var binding : SearchFragmentBinding
    private lateinit var viewModel: SearchViewModel


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = SearchFragmentBinding.inflate(inflater , container , false)
        viewModel = ViewModelProvider(this).get(SearchViewModel::class.java)


        return binding.root
    }
}