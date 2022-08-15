package com.aya.newsapp.presentation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import com.aya.newsapp.R
import com.aya.newsapp.databinding.SearchFragmentBinding
import com.aya.newsapp.domain.model.ArticlesTable
import com.aya.newsapp.domain.response.MainResponse
import com.aya.newsapp.presentation.adapter.NewsAdapter
import com.aya.newsapp.presentation.interfaces.onClickDetails
import com.aya.newsapp.presentation.viewModel.SearchViewModel
import java.util.*

class SearchFragment : Fragment() ,onClickDetails, SearchView.OnQueryTextListener {

    private lateinit var binding : SearchFragmentBinding
    private lateinit var viewModel: SearchViewModel
    private lateinit var allNews : ArrayList<ArticlesTable>
    private lateinit var adapter : NewsAdapter

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
        binding = SearchFragmentBinding.inflate(inflater , container , false)
        viewModel = ViewModelProvider(this).get(SearchViewModel::class.java)

        adapter = NewsAdapter(this)

        viewModel.requestSearchLiveData.observe(viewLifecycleOwner, Observer {
            val data = it as MainResponse
            allNews = data.articles
            adapter.submitList(data.articles)
            binding.recyclerNews.adapter = adapter
        })

        binding.searchView.setOnQueryTextListener(this)

        return binding.root
    }

    override fun onClick(artical: ArticlesTable) {
        navController.navigate(SearchFragmentDirections.actionSearchFragmentToDetailsFragment(artical.urlToImage.toString(),artical.title.toString(),artical.description.toString()))

    }

    override fun onClickBookMarks(artical: ArticlesTable) {
      //  TODO("Not yet implemented")
    }

    override fun onQueryTextSubmit(newTitle: String?): Boolean {
        var filterNews = allNews.filter { item ->
            item.title!!.contains(newTitle.toString())
        }
        adapter.submitList(filterNews)
        return false
    }

    override fun onQueryTextChange(newTitle: String?): Boolean {
        var filterNews = allNews.filter { item ->
            item.title!!.contains(newTitle.toString())
        }
        adapter.submitList(filterNews)
        return false
    }
}