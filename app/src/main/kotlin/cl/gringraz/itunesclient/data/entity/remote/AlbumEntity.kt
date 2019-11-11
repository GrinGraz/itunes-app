package cl.gringraz.itunesclient.data.entity.remote

import cl.gringraz.itunesclient.domain.model.Album
import java.util.*

data class AlbumEntity(
    val artistId: Long,
    val collectionId: Long,
    val artistName: String,
    val collectionName: String,
    val collectionCensoredName: String,
    val artistViewUrl: String,
    val collectionViewUrl: String,
    val artworkUrl30: String?,
    val artworkUrl60: String?,
    val artworkUrl100: String?,
    val collectionPrice: Double,
    val collectionExplicitness: String,
    val trackCount: Int,
    val copyright: String,
    val country: String,
    val currency: String,
    val primaryGenreName: String
)

fun AlbumEntity.toAlbum() = Album(
    collectionId = collectionId,
    artistId = artistId,
    artistName = artistName,
    collectionName = collectionName,
    collectionCensoredName = collectionCensoredName,
    artistViewUrl = artistViewUrl,
    collectionViewUrl = collectionViewUrl,
    artworkUrl30 = artworkUrl30 ?: "",
    artworkUrl60 = artworkUrl60 ?: "",
    artworkUrl100 = artworkUrl100 ?: "",
    collectionPrice = collectionPrice,
    isExplicit = collectionExplicitness != "notExplicit",
    trackCount = trackCount,
    copyright = copyright,
    country = country,
    currency = currency,
    primaryGenreName = primaryGenreName
)
