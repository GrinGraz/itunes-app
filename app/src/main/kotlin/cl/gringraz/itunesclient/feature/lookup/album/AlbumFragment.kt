package cl.gringraz.itunesclient.feature.lookup.album

import android.content.Intent
import android.net.ConnectivityManager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import cl.gringraz.itunesclient.R
import cl.gringraz.itunesclient.domain.model.Album
import cl.gringraz.itunesclient.feature.lookup.LookupViewModel
import cl.gringraz.itunesclient.feature.lookup.track.EXTRA_ALBUM_ID
import cl.gringraz.itunesclient.feature.lookup.track.TrackActivity
import cl.gringraz.itunesclient.util.ViewModelFactory
import cl.gringraz.itunesclient.util.visible
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.list_fragment.*
import org.koin.android.ext.android.inject

const val EXTRA_ARTIST_ID = "artistId"

class AlbumFragment : Fragment() {
    companion object {
        fun newInstance(artistId: Long): AlbumFragment {
            val fragment = AlbumFragment()
            val bundle  = Bundle()
            bundle.putLong(EXTRA_ARTIST_ID, artistId)
            fragment.arguments = bundle
            return fragment
        }
    }

    private val picasso = Picasso.get()
    private val connectivityManager: ConnectivityManager by inject()
    private val albumAdapter = AlbumAdapter(AlbumManager())
    private val viewModelFactory: ViewModelFactory by inject()
    private val viewModel by viewModels<LookupViewModel> { viewModelFactory }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.list_fragment, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val artistId = arguments?.getLong(EXTRA_ARTIST_ID, 0)!!

        activity?.actionBar?.setDisplayHomeAsUpEnabled(true)

        with(recycler) {
            layoutManager = LinearLayoutManager(context)
            adapter = albumAdapter
            setHasFixedSize(true)
        }

        with(viewModel) {
            albums.observe(this@AlbumFragment, Observer(::albumHandler))

            if (connectivityManager.activeNetworkInfo?.isConnected == true) {
                lookupAlbum(artistId)
                message.text = "Searching..."
            } else {
                message.text = "No internet connection"
                return
            }
        }
    }

    private fun albumHandler(albums: List<Album>) {
        if (albums.isEmpty()) {
            message.text = "No results"
            if (connectivityManager.activeNetworkInfo?.isConnected != true) {
                message.text = "No internet connection"
            }
        } else {
            albumAdapter.swapItems(albums)
            message.visible = false
            recycler.visible = true
        }
    }

    inner class AlbumManager :
        AlbumAdapter.AdapterManager {
        override fun onAlbumClicked(item: Album, position: Int) {
            val intent = Intent(activity, TrackActivity::class.java)
            intent.putExtra(EXTRA_ALBUM_ID, item.collectionId)
            startActivity(intent)
        }

        override fun provideImageLoader(): Picasso {
            return picasso
        }
    }
}
