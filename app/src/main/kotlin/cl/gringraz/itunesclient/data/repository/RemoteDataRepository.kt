package cl.gringraz.itunesclient.data.repository

import cl.gringraz.itunesclient.data.entity.remote.toAlbum
import cl.gringraz.itunesclient.data.entity.remote.toArtist
import cl.gringraz.itunesclient.data.entity.remote.toTrack
import cl.gringraz.itunesclient.data.source.remote.RemoteDataSource
import cl.gringraz.itunesclient.domain.model.Album
import cl.gringraz.itunesclient.domain.model.Artist
import cl.gringraz.itunesclient.domain.model.Track
import cl.gringraz.itunesclient.domain.repository.RemoteRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class RemoteDataRepository(
    private val remoteDataSource: RemoteDataSource,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
) : RemoteRepository {
    override suspend fun searchArtists(term: String): List<Artist> {
        return withContext(ioDispatcher){
            val artists = remoteDataSource.searchArtist(term = term)
            artists.results.map { it.toArtist() }
        }
    }

    override suspend fun lookupAlbums(artistId: Long): List<Album> {
        return withContext(ioDispatcher){
            val artists = remoteDataSource.lookupAlbum(artistId)
            artists.results.drop(1).map { it.toAlbum() }
        }
    }

    override suspend fun lookupTracks(albumId: Long): List<Track> {
        return withContext(ioDispatcher) {
            val artists = remoteDataSource.lookupSong(albumId)
            artists.results.drop(1).map { it.toTrack() }
        }
    }
}
