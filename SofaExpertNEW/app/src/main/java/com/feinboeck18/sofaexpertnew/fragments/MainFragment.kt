package com.feinboeck18.sofaexpertnew.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.feinboeck18.sofaexpertnew.MainActivity
import com.feinboeck18.sofaexpertnew.R
import com.feinboeck18.sofaexpertnew.listviewAdapters.MovieListViewAdapter
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val adapter = MovieListViewAdapter(MainActivity.currentActivity, MainActivity.movieList)

        mainGridView.adapter = adapter
        mainGridView.setOnItemClickListener { _, _, position, _ ->
            DetailedMovieFragment.currentMovie = adapter.getItem(position)
            findNavController().navigate(R.id.action_fragmentMain_to_fragmentDetail)
        }
    }
}