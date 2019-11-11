package cl.gringraz.itunesclient.feature.lookup.track

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import cl.gringraz.itunesclient.R

class TrackActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.container_activity)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val albumExtraId = intent.getLongExtra(EXTRA_ALBUM_ID, 0)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container,
                    TrackFragment.newInstance(
                        albumExtraId
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
