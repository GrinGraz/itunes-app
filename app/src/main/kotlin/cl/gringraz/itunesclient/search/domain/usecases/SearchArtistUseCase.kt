package cl.gringraz.itunesclient.search.domain.usecases

import cl.gringraz.itunesclient.search.domain.model.Artist
import cl.gringraz.itunesclient.search.domain.repository.RemoteRepository


class SearchArtistUseCase(private val remoteRepository: RemoteRepository) {
    suspend operator fun invoke(term: String): List<Artist> {
        return remoteRepository.searchArtists(term)
    }
}