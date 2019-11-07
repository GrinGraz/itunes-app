package cl.gringraz.itunesclient.domain.usecases

import cl.gringraz.itunesclient.domain.model.Album
import cl.gringraz.itunesclient.domain.repository.RemoteRepository


class LookupAlbumsUseCase(private val remoteRepository: RemoteRepository) {
    suspend operator fun invoke(albumId: Long): List<Album> {
        return remoteRepository.lookupAlbums(albumId)
    }
}