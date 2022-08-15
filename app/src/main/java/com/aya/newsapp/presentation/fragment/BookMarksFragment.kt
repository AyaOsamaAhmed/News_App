package com.aya.newsapp.presentation.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import com.aya.newsapp.R
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
        binding = BookMarksFragmentBinding.inflate(inflater , container , false)
        viewModel = ViewModelProvider(this).get(BookMarksViewModel::class.java)

        newsDataBase = NewsDataBase.getInstance(requireContext())

        viewModel.getAllBookMark(newsDataBase)

        viewModel.requestBookMarksiveData.observe(viewLifecycleOwner, Observer {
            val data = it as List<ArticlesTable>
            adapter = NewsAdapter(this)
            Log.d("BookMarks",data.size.toString())

             adapter.submitList(data)
            binding.recyclerNews.adapter = adapter
        })
        return binding.root
    }

    override fun onClick(artical: ArticlesTable) {
        navController.navigate(R.id.action_BookMarksFragment_to_DetailsFragment)
    }

    override fun onClickBookMarks(artical: ArticlesTable) {
        viewModel.deleteBookMark(newsDataBase,artical)

        viewModel.getAllBookMark(newsDataBase)
    }
}