package cl.gringraz.itunesclient.domain.model

data class Album(
    val collectionId: Long,
    val artistId: Long,
    val artistName: String,
    val collectionName: String,
    val collectionCensoredName: String,
    val artistViewUrl: String,
    val collectionViewUrl: String,
    val artworkUrl30: String,
    val artworkUrl60: String,
    val artworkUrl100: String,
    val collectionPrice: Double,
    val isExplicit: Boolean,
    val trackCount: Int,
    val copyright: String,
    val country: String,
    val currency: String,
    val primaryGenreName: String
)
