package cl.gringraz.itunesclient.search.data.source.remote

import cl.gringraz.itunesclient.search.data.entity.remote.AlbumEntity
import cl.gringraz.itunesclient.search.data.entity.remote.ArtistEntity
import cl.gringraz.itunesclient.search.data.entity.remote.SearchResult
import cl.gringraz.itunesclient.search.data.entity.remote.TrackEntity
import retrofit2.http.GET
import retrofit2.http.Query


interface ItunesApi {
    @GET("search")
    suspend fun searchArtists(
        @Query("term") terms: String,
        @Query("entity") entity: String = "musicArtist"
    ): SearchResult<ArtistEntity>

    @GET("lookup")
    suspend fun lookupAlbums(
        @Query("id") artistId: Long,
        @Query("entity") entity: String = "album"
    ): SearchResult<AlbumEntity>

    @GET("lookup")
    suspend fun lookupTracks(
        @Query("id") albumId: Long,
        @Query("entity") entity: String = "song"
    ): SearchResult<TrackEntity>
}
