package cl.gringraz.itunesclient.domain.usecases

import cl.gringraz.itunesclient.domain.model.Track
import cl.gringraz.itunesclient.domain.repository.RemoteRepository


class LookupTracksUseCase(private val remoteRepository: RemoteRepository) {
    suspend operator fun invoke(albumId: Long): List<Track> {
        return remoteRepository.lookupTracks(albumId)
    }
}