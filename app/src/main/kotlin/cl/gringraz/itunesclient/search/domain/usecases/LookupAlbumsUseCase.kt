package cl.gringraz.itunesclient.search.domain.usecases

import cl.gringraz.itunesclient.search.domain.model.Album
import cl.gringraz.itunesclient.search.domain.repository.RemoteRepository


class LookupAlbumsUseCase(private val remoteRepository: RemoteRepository) {
    suspend operator fun invoke(albumId: Long): List<Album> {
        return remoteRepository.lookupAlbums(albumId)
    }
}