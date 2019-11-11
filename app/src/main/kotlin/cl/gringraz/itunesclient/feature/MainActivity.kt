package cl.gringraz.itunesclient.feature

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import cl.gringraz.itunesclient.R
import cl.gringraz.itunesclient.feature.search.SearchFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.container_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, SearchFragment.newInstance())
                .commitNow()
        }
    }
}
