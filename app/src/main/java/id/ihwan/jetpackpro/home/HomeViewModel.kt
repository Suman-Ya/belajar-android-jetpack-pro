package id.ihwan.jetpackpro.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import id.ihwan.jetpackpro.data.source.MovieRepository
import id.ihwan.jetpackpro.data.source.local.FavoriteDatabase
import id.ihwan.jetpackpro.data.source.remote.network.response.ResultsData
import id.ihwan.jetpackpro.utils.EspressoIdlingResource
import id.ihwan.jetpackpro.utils.Status
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {

    val repository = MovieRepository()

    private val _movie =  MutableLiveData<List<ResultsData>>()

    val movies: LiveData<List<ResultsData>>
        get() = _movie

    private val _tvShow = MutableLiveData<List<ResultsData>>()

    val tvShow: LiveData<List<ResultsData>>
        get() = _tvShow

    private val _status = MutableLiveData<Status>()

    val status : LiveData<Status>
        get() = _status

    init {
        getData()
    }

    private fun getData(){
        EspressoIdlingResource.increment()
        viewModelScope.launch {
                _status.value = Status.LOADING
                _movie.value = repository.getMovie()
                _tvShow.value = repository.getTvShow()
                _status.value = Status.DONE
            EspressoIdlingResource.decrement()
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelScope.cancel()
    }


}