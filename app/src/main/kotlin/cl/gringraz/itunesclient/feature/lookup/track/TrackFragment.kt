package cl.gringraz.itunesclient.feature.lookup.track

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
import cl.gringraz.itunesclient.domain.model.Track
import cl.gringraz.itunesclient.domain.model.toTrackItem
import cl.gringraz.itunesclient.feature.lookup.LookupViewModel
import cl.gringraz.itunesclient.feature.lookup.track.model.TrackItem
import cl.gringraz.itunesclient.util.ViewModelFactory
import cl.gringraz.itunesclient.util.visible
import kotlinx.android.synthetic.main.list_fragment.*
import org.koin.android.ext.android.inject

const val EXTRA_ALBUM_ID = "albumId"

class TrackFragment : Fragment() {
    companion object {
        fun newInstance(albumId: Long): TrackFragment {
            val fragment = TrackFragment()
            val bundle = Bundle()
            bundle.putLong(EXTRA_ALBUM_ID, albumId)
            fragment.arguments = bundle
            return fragment
        }
    }

    private val connectivityManager: ConnectivityManager by inject()
    private val trackAdapter = TrackAdapter()
    private val viewModelFactory: ViewModelFactory by inject()
    private val viewModel by viewModels<LookupViewModel> { viewModelFactory }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.list_fragment, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val albumId = arguments?.getLong(EXTRA_ALBUM_ID, 0)!!

        with(recycler) {
            layoutManager = LinearLayoutManager(context)
            adapter = trackAdapter
            setHasFixedSize(true)
        }

        with(viewModel) {
            tracks.observe(this@TrackFragment, Observer(::trackHandler))

            if (connectivityManager.activeNetworkInfo?.isConnected == true) {
                lookupTrack(albumId)
                message.text = "Searching..."
            } else {
                message.text = "No internet connection"
                return
            }
        }
    }

    private fun trackHandler(tracks: List<Track>) {
        val items = tracks.map(Track::toTrackItem)
        if (tracks.isEmpty()) {
            message.text = "No results"
            if (connectivityManager.activeNetworkInfo?.isConnected != true) {
                message.text = "No internet connection"
            }
        } else {
            trackAdapter.swapItems(items)
            message.visible = false
            recycler.visible = true
        }

        trackAdapter.swapItems(items)
    }
}
