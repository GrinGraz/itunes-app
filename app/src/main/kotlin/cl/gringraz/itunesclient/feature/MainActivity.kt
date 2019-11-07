package cl.gringraz.itunesclient.feature

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import cl.gringraz.itunesclient.R
import cl.gringraz.itunesclient.feature.search.MainFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MainFragment.newInstance())
                .commitNow()
        }
    }

}
