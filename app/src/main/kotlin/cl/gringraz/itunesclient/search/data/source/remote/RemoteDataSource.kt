package cl.gringraz.itunesclient.search.data.source.remote

import cl.gringraz.itunesclient.search.data.entities.remote.AlbumEntity
import cl.gringraz.itunesclient.search.data.entities.remote.ArtistEntity
import cl.gringraz.itunesclient.search.data.entities.remote.SearchResult
import cl.gringraz.itunesclient.search.data.entities.remote.TrackEntity

interface RemoteDataSource {
    suspend fun searchArtist(term: String, entity: String): SearchResult<ArtistEntity>
    suspend fun lookupAlbum(id: String, entity: String): SearchResult<AlbumEntity>
    suspend fun lookupSong(id: String, entity: String): SearchResult<TrackEntity>
}
