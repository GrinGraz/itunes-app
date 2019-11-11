package cl.gringraz.itunesclient.feature.lookup.track.model

data class TrackItem(
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
) {
    override fun hashCode() = trackId.toInt()

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as TrackItem

        return (trackId == other.trackId)
    }
}
