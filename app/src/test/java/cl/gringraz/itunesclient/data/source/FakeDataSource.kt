package cl.gringraz.itunesclient.data.source

import cl.gringraz.itunesclient.data.entity.remote.AlbumEntity
import cl.gringraz.itunesclient.data.entity.remote.ArtistEntity
import cl.gringraz.itunesclient.data.entity.remote.SearchResult
import cl.gringraz.itunesclient.data.entity.remote.TrackEntity
import cl.gringraz.itunesclient.data.source.remote.RemoteDataSource

class FakeDataSource(var artists: MutableList<ArtistEntity>? = mutableListOf()): RemoteDataSource{
    override suspend fun searchArtist(term: String, entity: String): SearchResult<ArtistEntity> {
        return SearchResult(1, artists?.toList()!!)
    }

    override suspend fun lookupAlbum(id: String, entity: String): SearchResult<AlbumEntity> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun lookupSong(id: String, entity: String): SearchResult<TrackEntity> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
