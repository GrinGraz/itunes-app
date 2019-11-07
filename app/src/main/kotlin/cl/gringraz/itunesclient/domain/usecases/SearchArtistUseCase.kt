package cl.gringraz.itunesclient.domain.usecases

import cl.gringraz.itunesclient.domain.model.Artist
import cl.gringraz.itunesclient.domain.repository.RemoteRepository


class SearchArtistUseCase(private val remoteRepository: RemoteRepository) {
    suspend operator fun invoke(term: String): List<Artist> {
        return remoteRepository.searchArtists(term)
    }
}