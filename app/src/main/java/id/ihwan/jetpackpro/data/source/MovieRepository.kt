package id.ihwan.jetpackpro.data.source

import androidx.lifecycle.MutableLiveData
import id.ihwan.jetpackpro.utils.EspressoIdlingResource
import id.ihwan.jetpackpro.network.TMDBApi
import id.ihwan.jetpackpro.network.response.ResultsMovie
import id.ihwan.jetpackpro.network.response.ResultsTvShow
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MovieRepository {

    val movies = MutableLiveData<List<ResultsMovie>>()
    val tvShows = MutableLiveData<List<ResultsTvShow>>()

    suspend fun getMovie(){
        EspressoIdlingResource.increment()
        withContext(Dispatchers.IO) {
            val data = TMDBApi.retrofitService.getPopularMovies().await()
            movies.postValue(data.results)
            EspressoIdlingResource.decrement()
        }

    }

    suspend fun getTvShow(){
        withContext(Dispatchers.IO) {
            val data = TMDBApi.retrofitService.getPopularTvShow().await()
            tvShows.postValue(data.results)
        }

    }


}