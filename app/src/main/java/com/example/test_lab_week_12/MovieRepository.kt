package com.example.test_lab_week_12

import androidx.lifecycle.MutableLiveData
import com.example.test_lab_week_12.api.MovieService
import com.example.test_lab_week_12.model.Movie
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.Flow

class MovieRepository(private val movieService: MovieService) {
    private val apiKey = "79dc1fd9991aa8100594433dbf631bad"
    // LiveData that contains a list of movies
    private val movieLiveData = MutableLiveData<List<Movie>>()

    // fetch movies from the API
    fun fetchMovies(): Flow<List<Movie>> {
        return flow {
            // emit the list of popular movies from the API
            emit(movieService.getPopularMovies(apiKey).results)
        // use Dispatchers.IO to run this coroutine on a shared pool of threads
        }.flowOn(Dispatchers.IO)
    }
}