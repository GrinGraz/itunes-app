package cl.gringraz.itunesclient.feature.lookup

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import cl.gringraz.itunesclient.domain.model.Album
import cl.gringraz.itunesclient.domain.model.Artist
import cl.gringraz.itunesclient.domain.model.Track
import cl.gringraz.itunesclient.domain.usecases.LookupAlbumsUseCase
import cl.gringraz.itunesclient.domain.usecases.LookupTracksUseCase
import cl.gringraz.itunesclient.domain.usecases.SearchArtistUseCase
import kotlinx.coroutines.launch

class LookupViewModel(private val lookupAlbumsUseCase: LookupAlbumsUseCase,
                      private val lookupTracksUseCase: LookupTracksUseCase): ViewModel() {

    val albums = MutableLiveData<List<Album>>().apply { value = emptyList() }
    val tracks = MutableLiveData<List<Track>>().apply { value = emptyList() }

    fun lookupAlbum(albumId: Long){
        viewModelScope.launch {
            albums.value = lookupAlbumsUseCase(albumId)
        }
    }

    fun lookupTrack(trackId: Long){
        viewModelScope.launch {
            tracks.value = lookupTracksUseCase(trackId)
        }
    }
}
