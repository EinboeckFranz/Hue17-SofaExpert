package com.feinboeck18.sofaexpertnew.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.feinboeck18.sofaexpertnew.MainActivity
import com.feinboeck18.sofaexpertnew.Movie
import com.feinboeck18.sofaexpertnew.R
import kotlinx.android.synthetic.main.fragment_detailedmovie.*

class DetailedMovieFragment : Fragment() {
    companion object{
        var currentMovie: Movie? = null
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_detailedmovie, container, false)
    }

    @SuppressLint("SetTextI18n", "SimpleDateFormat")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        movieDetailedTitle.text = currentMovie?.movieTitle
        movieDetailedRating.text = "${currentMovie?.votingPoints} / 10"
        Movie.loadImg(
            view.findViewById(R.id.movieDetailedPoster),
            MainActivity.BASIC_IMG_URL + currentMovie?.posterURLPath
        )
        movieDetailedReleaseDate.text = currentMovie?.releaseDate
        movieDetailedDescription.text = currentMovie?.description
    }
}