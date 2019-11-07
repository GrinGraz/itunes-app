package cl.gringraz.itunesclient.feature.search

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import cl.gringraz.itunesclient.domain.model.Artist
import cl.gringraz.itunesclient.domain.usecases.SearchArtistUseCase
import kotlinx.coroutines.launch

class SearchViewModel(private val searchArtistUseCase: SearchArtistUseCase): ViewModel() {

    val artists = MutableLiveData<List<Artist>>().apply { value = emptyList() }

    fun searchArtist(term: String){
        viewModelScope.launch {
            artists.value = searchArtistUseCase(term)
        }
    }
}
