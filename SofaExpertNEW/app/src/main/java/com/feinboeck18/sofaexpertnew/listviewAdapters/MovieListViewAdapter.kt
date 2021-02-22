package com.feinboeck18.sofaexpertnew.listviewAdapters

import android.app.Activity
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.feinboeck18.sofaexpertnew.MainActivity
import com.feinboeck18.sofaexpertnew.Movie
import com.feinboeck18.sofaexpertnew.R

class MovieListViewAdapter(private val context: Activity, var movies: List<Movie>) : ArrayAdapter<Movie>(context, R.layout.imageview_movie, movies) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val currentView = convertView ?: context.layoutInflater.inflate(R.layout.imageview_movie,null,true)

        Movie.loadImg(currentView.findViewById(R.id.moviePoster), MainActivity.BASIC_IMG_URL + (getItem(position)?.posterURLPath))

        return currentView
    }

    override fun getItem(position: Int): Movie? {
        return movies[position]
    }
}