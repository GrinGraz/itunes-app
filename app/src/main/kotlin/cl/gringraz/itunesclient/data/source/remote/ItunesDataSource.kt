package cl.gringraz.itunesclient.data.source.remote

import cl.gringraz.itunesclient.data.entity.remote.AlbumEntity
import cl.gringraz.itunesclient.data.entity.remote.ArtistEntity
import cl.gringraz.itunesclient.data.entity.remote.SearchResult
import cl.gringraz.itunesclient.data.entity.remote.TrackEntity

class ItunesDataSource(private val itunesApi: ItunesApi) : RemoteDataSource {
    override suspend fun searchArtist(term: String, entity: String): SearchResult<ArtistEntity> {
        return itunesApi.searchArtists(term)
    }

    override suspend fun lookupAlbum(id: Long, entity: String): SearchResult<AlbumEntity> {
        return itunesApi.lookupAlbums(id)
    }

    override suspend fun lookupSong(id: Long, entity: String): SearchResult<TrackEntity> {
        return itunesApi.lookupTracks(id)
    }
}
