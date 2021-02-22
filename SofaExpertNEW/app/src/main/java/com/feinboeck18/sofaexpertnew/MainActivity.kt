package com.feinboeck18.sofaexpertnew

import android.annotation.SuppressLint
import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.json.JSONArray
import org.json.JSONObject
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader
import java.util.stream.Collectors

class MainActivity : AppCompatActivity() {
    companion object {
        const val BASIC_IMG_URL = "http://image.tmdb.org/t/p/w154/"
        @SuppressLint("StaticFieldLeak")
        lateinit var currentActivity: Activity
        lateinit var movieList: List<Movie>
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        currentActivity = this
        movieList = readMoviesFromJSON(assets.open("movies.json"))

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    private fun readMoviesFromJSON(fileInputStream: InputStream): List<Movie> {
        val temp = ArrayList<Movie>()

        val fileContent = BufferedReader(InputStreamReader(fileInputStream))
            .lines()
            .collect(Collectors.joining("\n"))
        val fileContentToJSONObject = JSONObject(fileContent)
        val jsonArray: JSONArray = fileContentToJSONObject.getJSONArray("results")

        for(i in 0 until jsonArray.length()) {
            val currentMovieJSON = jsonArray.getJSONObject(i)
            temp.add(Movie(currentMovieJSON.getDouble("vote_average"), currentMovieJSON.getString("title"), currentMovieJSON.getString("poster_path"),
                currentMovieJSON.getString("overview"), currentMovieJSON.getString("release_date")))
        }

        return temp
    }
}