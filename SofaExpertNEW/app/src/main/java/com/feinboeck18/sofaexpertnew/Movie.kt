package com.feinboeck18.sofaexpertnew

import android.widget.ImageView
import com.squareup.picasso.Picasso

data class Movie(val votingPoints : Double, val movieTitle : String, val posterURLPath : String, val description : String, val releaseDate : String) {
    companion object {
        fun loadImg(imgView: ImageView, imgPath: String) {
            Picasso.get()
                .load(imgPath)
                .into(imgView)
        }
    }
}