package cl.gringraz.itunesclient.domain.model

import cl.gringraz.itunesclient.feature.lookup.track.model.TrackItem

data class Track(
    val artistId: Long,
    val collectionId: Long,
    val trackId: Long,
    val artistName: String,
    val collectionName: String,
    val trackName: String,
    val collectionCensoredName: String,
    val trackCensoredName: String,
    val artistViewUrl: String,
    val collectionViewUrl: String,
    val trackViewUrl: String,
    val previewUrl: String,
    val collectionPrice: Double,
    val trackPrice: Double,
    val releaseDate: String,
    val discCount: Int,
    val discNumber: Int,
    val trackCount: Int,
    val trackNumber: Int,
    val trackTimeMillis: Long,
    val country: String,
    val currency: String,
    val primaryGenreName: String,
    val isMusic: Boolean,
    val isVideo: Boolean
)

fun Track.toTrackItem() = TrackItem(
    artistId = artistId,
    collectionId = collectionId,
    trackId = trackId,
    artistName = artistName,
    collectionName = collectionName,
    trackName = trackName,
    collectionCensoredName = collectionCensoredName,
    trackCensoredName = trackCensoredName,
    artistViewUrl = artistViewUrl,
    collectionViewUrl = collectionViewUrl,
    trackViewUrl = trackViewUrl,
    previewUrl = previewUrl,
    collectionPrice = collectionPrice,
    trackPrice = trackPrice,
    discCount = discCount,
    discNumber = discNumber,
    trackCount = trackCount,
    trackNumber = trackNumber,
    trackTimeMillis = trackTimeMillis,
    country = country,
    currency = currency,
    primaryGenreName = primaryGenreName,
    isMusic = isMusic,
    isVideo = isVideo
)
