package cl.gringraz.itunesclient.feature.lookup.album

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import cl.gringraz.itunesclient.R

class AlbumActivity : AppCompatActivity() {

    private val extraArtistId by lazy {
        intent.getLongExtra(EXTRA_ARTIST_ID, 0)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.container_activity)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container,
                    AlbumFragment.newInstance(
                        extraArtistId
                    )
                )
                .commitNow()
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()

        return true
    }
}
