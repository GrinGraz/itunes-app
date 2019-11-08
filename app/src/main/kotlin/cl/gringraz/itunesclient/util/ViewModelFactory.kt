package cl.gringraz.itunesclient.util

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import cl.gringraz.itunesclient.domain.repository.RemoteRepository
import cl.gringraz.itunesclient.domain.usecases.LookupAlbumsUseCase
import cl.gringraz.itunesclient.domain.usecases.LookupTracksUseCase
import cl.gringraz.itunesclient.domain.usecases.SearchArtistUseCase
import cl.gringraz.itunesclient.feature.lookup.LookupViewModel
import cl.gringraz.itunesclient.feature.search.SearchViewModel

@Suppress("UNCHECKED_CAST")
class ViewModelFactory constructor(
    private val tasksRepository: RemoteRepository
) : ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel> create(modelClass: Class<T>) =
        with(modelClass) {
            when {
                isAssignableFrom(SearchViewModel::class.java) ->
                    SearchViewModel(
                        SearchArtistUseCase(tasksRepository)
                    )
                isAssignableFrom(LookupViewModel::class.java) ->
                    LookupViewModel(
                        LookupAlbumsUseCase(tasksRepository),
                        LookupTracksUseCase(tasksRepository)
                    )
                else ->
                    throw IllegalArgumentException("Unknown ViewModel class: ${modelClass.name}")
            }
        } as T
}
