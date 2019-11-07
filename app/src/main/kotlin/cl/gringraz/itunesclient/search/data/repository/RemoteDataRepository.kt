package cl.gringraz.itunesclient.search.data.repository

import cl.gringraz.itunesclient.search.data.source.remote.RemoteDataSource
import cl.gringraz.itunesclient.search.domain.model.Album
import cl.gringraz.itunesclient.search.domain.model.Artist
import cl.gringraz.itunesclient.search.domain.model.Track
import cl.gringraz.itunesclient.search.domain.repository.RemoteRepository

class RemoteDataRepository(remoteDataSource: RemoteDataSource): RemoteRepository {
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
