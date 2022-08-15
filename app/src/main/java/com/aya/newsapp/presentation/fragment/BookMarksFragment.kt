package com.aya.newsapp.presentation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.aya.newsapp.domain.model.ArticlesTable
import com.aya.newsapp.data.local.NewsDataBase
import com.aya.newsapp.databinding.BookMarksFragmentBinding
import com.aya.newsapp.domain.model.ArticlesModel
import com.aya.newsapp.presentation.adapter.NewsAdapter
import com.aya.newsapp.presentation.interfaces.onClickDetails
import com.aya.newsapp.presentation.viewModel.BookMarksViewModel

class BookMarksFragment : Fragment() ,onClickDetails {

    private lateinit var binding : BookMarksFragmentBinding
    private lateinit var viewModel: BookMarksViewModel

    private lateinit var adapter : NewsAdapter
    private lateinit var newsDataBase: NewsDataBase


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = BookMarksFragmentBinding.inflate(inflater , container , false)
        viewModel = ViewModelProvider(this).get(BookMarksViewModel::class.java)

        newsDataBase = NewsDataBase.getInstance(context!!)

        viewModel.getAllBookMark(newsDataBase)

        viewModel.requestBookMarksiveData.observe(viewLifecycleOwner, Observer {
            val data = it as ArrayList<ArticlesTable>
            adapter = NewsAdapter(this)
            adapter.submitList(data)
            binding.recyclerNews.adapter = adapter
        })
        return binding.root
    }

    override fun onClick(artical: ArticlesTable) {
        TODO("Not yet implemented")
    }

    override fun onClickBookMarks(artical: ArticlesTable) {
        TODO("Not yet implemented")
    }
}