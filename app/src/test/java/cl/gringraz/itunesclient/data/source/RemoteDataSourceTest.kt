package cl.gringraz.itunesclient.data.source

import cl.gringraz.itunesclient.data.entity.remote.ArtistEntity
import cl.gringraz.itunesclient.data.source.remote.ItunesApi
import cl.gringraz.itunesclient.data.source.remote.ItunesDataSource
import cl.gringraz.itunesclient.data.source.remote.RemoteDataSource
import com.google.common.truth.Truth
import com.google.common.truth.Truth.*
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.koin.test.KoinTest
import org.koin.test.inject

class RemoteDataSourceTest: KoinTest {

    private val artistSearch = "metallica"

    private val artist = ArtistEntity(
        3996865,
        "Metallica",
        "https://music.apple.com/us/artist/metallica/3996865?uo=4",
        "Metal",
        1153
    )

    val api by inject<ItunesApi>()
    private lateinit var itunesDataSource: RemoteDataSource

    @Before
    fun `start koin`() {
        startKoin{ modules(testModule) }
        itunesDataSource = ItunesDataSource(api)
    }

    @Test
    fun `should get artists from iTunes api`() {
        val result = runBlocking {
            itunesDataSource.searchArtist(term = artistSearch)
        }

        assertNotNull(result)
        assertTrue(result.resultCount > 0)
        assertThat(result.results[0]).isEqualTo(artist)
    }

    @After
    fun `stop koin`() {
        stopKoin()
    }
}
