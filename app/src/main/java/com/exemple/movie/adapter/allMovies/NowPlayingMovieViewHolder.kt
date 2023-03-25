package com.exemple.movie.adapter.allMovies

import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.exemple.movie.databinding.AllMoviesItemBinding

class NowPlayingMovieViewHolder(val binding: AllMoviesItemBinding):RecyclerView.ViewHolder(binding.root) {
    fun bindData(data: com.exemple.movie.model.response.home.nowPlaying.Result){
        binding.title.text = data.title
        val imageUrl = "https://image.tmdb.org/t/p/original"+data.posterPath
        binding.imageView.load(imageUrl)
        binding.title.text
    }
}