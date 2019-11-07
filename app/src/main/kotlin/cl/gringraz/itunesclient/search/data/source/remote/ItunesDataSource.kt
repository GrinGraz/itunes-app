package cl.gringraz.itunesclient.search.data.source.remote

import cl.gringraz.itunesclient.search.data.entity.remote.AlbumEntity
import cl.gringraz.itunesclient.search.data.entity.remote.ArtistEntity
import cl.gringraz.itunesclient.search.data.entity.remote.SearchResult
import cl.gringraz.itunesclient.search.data.entity.remote.TrackEntity

class ItunesDataSource(itunesApi: ItunesApi): RemoteDataSource {
    override suspend fun searchArtist(term: String, entity: String): SearchResult<ArtistEntity> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun lookupAlbum(id: String, entity: String): SearchResult<AlbumEntity> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun lookupSong(id: String, entity: String): SearchResult<TrackEntity> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}
