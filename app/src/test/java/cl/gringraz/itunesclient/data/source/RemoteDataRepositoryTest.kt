package cl.gringraz.itunesclient.data.source

import cl.gringraz.itunesclient.data.entity.remote.ArtistEntity
import cl.gringraz.itunesclient.data.entity.remote.toArtist
import cl.gringraz.itunesclient.data.repository.RemoteDataRepository
import cl.gringraz.itunesclient.domain.model.Artist
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Before
import org.junit.Test

@ExperimentalCoroutinesApi
class RemoteDataRepositoryTest {

    private val artist = ArtistEntity(
        3996865,
        "Metallica",
        "https://music.apple.com/us/artist/metallica/3996865?uo=4",
        "Metal",
        1153
    )
    private val remoteArtists = listOf(artist)
    private lateinit var remoteDataSource: FakeDataSource

    private lateinit var remoteDataRepository: RemoteDataRepository

    @ExperimentalCoroutinesApi
    @Before
    fun createRepository() {
        remoteDataSource = FakeDataSource(remoteArtists.toMutableList())

        // Get a reference to the class under test
        remoteDataRepository = RemoteDataRepository(
            remoteDataSource, Dispatchers.Unconfined
        )
    }

    @Test
    fun `request artist from remote data source`() = runBlockingTest {
        val artists = remoteDataRepository.searchArtists("")

        assertThat(artists).isEqualTo(remoteArtists.map { it.toArtist() })
    }
}
