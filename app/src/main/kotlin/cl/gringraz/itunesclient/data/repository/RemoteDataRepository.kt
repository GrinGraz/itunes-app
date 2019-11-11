package cl.gringraz.itunesclient.data.repository

import cl.gringraz.itunesclient.data.source.remote.RemoteDataSource
import cl.gringraz.itunesclient.domain.model.Album
import cl.gringraz.itunesclient.domain.model.Artist
import cl.gringraz.itunesclient.domain.model.Track
import cl.gringraz.itunesclient.domain.repository.RemoteRepository

class RemoteDataRepository(private val remoteDataSource: RemoteDataSource) : RemoteRepository {
    override suspend fun searchArtists(term: String): List<Artist> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun lookupAlbums(artistId: Long): List<Album> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun lookupTracks(albumId: Long): List<Track> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
