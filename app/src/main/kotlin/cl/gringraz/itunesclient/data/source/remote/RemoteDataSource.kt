package cl.gringraz.itunesclient.data.source.remote

import cl.gringraz.itunesclient.data.entity.remote.AlbumEntity
import cl.gringraz.itunesclient.data.entity.remote.ArtistEntity
import cl.gringraz.itunesclient.data.entity.remote.SearchResult
import cl.gringraz.itunesclient.data.entity.remote.TrackEntity

interface RemoteDataSource {
    suspend fun searchArtist(term: String, entity: String = "musicArtist"): SearchResult<ArtistEntity>
    suspend fun lookupAlbum(id: Long, entity: String = "album"): SearchResult<AlbumEntity>
    suspend fun lookupSong(id: Long, entity: String = "song"): SearchResult<TrackEntity>
}
