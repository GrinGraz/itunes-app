package cl.gringraz.itunesclient.data.entity.remote

import cl.gringraz.itunesclient.domain.model.Artist

data class ArtistEntity(
    val artistId: Long,
    val artistName: String,
    val artistLinkUrl: String?,
    val primaryGenreName: String?,
    val primaryGenreId: Long?
)

fun ArtistEntity.toArtist() = Artist(
    artistId = artistId,
    artistName = artistName,
    artistLinkUrl = artistLinkUrl ?: "",
    primaryGenreName = primaryGenreName ?: "",
    primaryGenreId = primaryGenreId ?: 0
)
