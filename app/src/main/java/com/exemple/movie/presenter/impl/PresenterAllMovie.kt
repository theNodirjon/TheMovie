package com.exemple.movie.presenter.impl

import android.util.Log
import com.exemple.movie.model.network.MovieClient
import com.exemple.movie.model.response.base.BaseType
import com.exemple.movie.model.response.home.nowPlaying.NowPlayingMoviesResponse
import com.exemple.movie.model.response.home.popular.PopularMovieResponse
import com.exemple.movie.model.response.home.topRated.TopRatedMovieResponse
import com.exemple.movie.model.response.home.upcoming.UpcomingMovieResponse
import com.exemple.movie.presenter.interfaces.AllMoviePresenter
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.observers.DisposableSingleObserver
import io.reactivex.rxjava3.schedulers.Schedulers

class PresenterAllMovie(private val view: AllMoviePresenter.View) : AllMoviePresenter.Presenter {

    private val compositeDisposable = CompositeDisposable()

    private val call = MovieClient.getApiMethods()

    override fun loadData(movieType: String) {

        when (movieType) {
            "Popular" -> {
                loadPopularMovies()
            }
            "Top Rated" -> {
                loadTopRatedMovies()
            }
            "Upcoming" -> {
                loadUpcomingMovies()
            }
            "Now Playing" -> {
                loadNowPlayingMovies()
            }
        }
    }

    override fun cancel() {
        if (!compositeDisposable.isDisposed) {
            compositeDisposable.dispose()
        }
    }
    override fun destroy() {
        compositeDisposable.clear()
    }

    private var page=0
    private fun loadUpcomingMovies() {

        page++

        compositeDisposable.add(
            call.getUpcomingMovies(page)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<UpcomingMovieResponse>() {
                    override fun onSuccess(t: UpcomingMovieResponse) {
                        view.showData(t.results as List<BaseType>)


                        Log.d("TAGaaa", "loadUpcomingMovies:${t.results}")
                    }


                    override fun onError(e: Throwable) {
                        view.showError(e.message!!)
                    }

                })
        )
    }


    private fun loadNowPlayingMovies() {

        compositeDisposable.add(
            call.getNowPaying()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<NowPlayingMoviesResponse>() {
                    override fun onSuccess(t: NowPlayingMoviesResponse) {
                        view.showData(t.results as List<BaseType>)

                    }

                    override fun onError(e: Throwable) {
                        view.showError(e.message!!)
                    }

                })
        )

    }

    private fun loadTopRatedMovies() {

        compositeDisposable.add(
            call.getTopRated()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<TopRatedMovieResponse>() {
                    override fun onSuccess(t: TopRatedMovieResponse) {
                        view.showData(t.results as List<BaseType>)

                    }

                    override fun onError(e: Throwable) {
                        view.showError(e.message!!)
                    }

                })
        )
    }

    private fun loadPopularMovies() {

        compositeDisposable.add(
            call.getPopularMovies()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<PopularMovieResponse>() {
                    override fun onSuccess(t: PopularMovieResponse) {
                        view.showData(t.results as List<BaseType>)

                    }

                    override fun onError(e: Throwable) {
                        view.showError(e.message!!)
                    }

                })
        )

    }
}