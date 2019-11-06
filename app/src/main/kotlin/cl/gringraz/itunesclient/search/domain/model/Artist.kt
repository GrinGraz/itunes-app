package cl.gringraz.itunesclient.search.domain.model

data class Artist(
    val artistId: Long,
    val artistName: String,
    val artistLinkUrl: String,
    val primaryGenreName: String,
    val primaryGenreId: Long,
    val isLiked: Boolean
)
