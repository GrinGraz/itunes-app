package cl.gringraz.itunesclient.search.data.entities

data class ArtistEntity(
    val artistId: Long,
    val artistName: String,
    val artistLinkUrl: String?,
    val primaryGenreName: String?,
    val primaryGenreId: Long?
)
