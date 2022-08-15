package com.aya.newsapp.presentation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.aya.newsapp.databinding.DetailsFragmentBinding
import com.aya.newsapp.domain.model.ArticlesTable
import com.aya.newsapp.presentation.viewModel.DetailsViewModel

class DetailsFragment : Fragment() {

    private lateinit var binding : DetailsFragmentBinding
    private lateinit var viewModel: DetailsViewModel


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DetailsFragmentBinding.inflate(inflater , container , false)
        viewModel = ViewModelProvider(this).get(DetailsViewModel::class.java)

        var arg = arguments?.let { DetailsFragmentArgs.fromBundle(it) }

        val modelDetails = ArticlesTable(urlToImage = arg?.img, title = arg?.title, description = arg?.desc, author = null, bookMark = 0, content = null, publishedAt = null, url = null)
        binding.model = modelDetails

        return binding.root
    }
}