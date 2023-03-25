package com.exemple.movie.adapter.nowPlaying

import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.exemple.movie.databinding.FirstSubItemBinding
import com.exemple.movie.model.response.nowPlaying.Result

class NowPlayingMovieViewHolder(val binding: FirstSubItemBinding):RecyclerView.ViewHolder(binding.root) {
    fun bindData(data: Result){
        binding.title.text = data.title
//        binding.description.text = data.overview
        val posterImageUrl = "https://image.tmdb.org/t/p/original"+data.posterPath
        val imageUrl = "https://image.tmdb.org/t/p/original"+data.backdropPath
//        binding.mainImage.load(imageUrl)
        binding.image.load(posterImageUrl)
    }
}