package cl.gringraz.itunesclient.domain.repository

import cl.gringraz.itunesclient.domain.model.Album
import cl.gringraz.itunesclient.domain.model.Artist
import cl.gringraz.itunesclient.domain.model.Track

interface RemoteRepository {
    suspend fun searchArtists(term: String): List<Artist>
    suspend fun lookupAlbums(artistId: Long): List<Album>
    suspend fun lookupTracks(albumId: Long): List<Track>
}
