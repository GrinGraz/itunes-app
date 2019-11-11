package cl.gringraz.itunesclient.feature.search

import android.content.Intent
import android.net.ConnectivityManager
import android.os.Bundle
import android.view.*
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import cl.gringraz.itunesclient.R
import cl.gringraz.itunesclient.domain.model.Artist
import cl.gringraz.itunesclient.feature.lookup.album.EXTRA_ARTIST_ID
import cl.gringraz.itunesclient.feature.lookup.album.AlbumActivity
import cl.gringraz.itunesclient.util.ViewModelFactory
import cl.gringraz.itunesclient.util.visible
import kotlinx.android.synthetic.main.list_fragment.*
import org.koin.android.ext.android.inject

class SearchFragment : Fragment() {

    companion object {
        fun newInstance() = SearchFragment()
    }

    private val connectivityManager: ConnectivityManager by inject()
    private val viewModelFactory: ViewModelFactory by inject()
    private val viewModel by viewModels<SearchViewModel> { viewModelFactory }
    private val searchAdapter = SearchAdapter(manager = ArtistManager())

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.list_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(recycler) {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = searchAdapter

            setHasFixedSize(true)
        }

        with(viewModel) {
            artists.observe(this@SearchFragment, Observer(::searchHandler))
        }
    }

    private fun searchHandler(artists: List<Artist>) {
        if (artists.isEmpty()) {
            message.text = "No results"
        } else {
            searchAdapter.swapItems(artists)
            message.visible = false
            recycler.visible = true
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        setupSearchviewMenu(menu, inflater)
        return super.onCreateOptionsMenu(menu, inflater)
    }

    private fun setupSearchviewMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.search_menu, menu)
        val searchItem = menu.findItem(R.id.action_search)
        val searchView = searchItem.actionView as SearchView
        searchView.isSubmitButtonEnabled = true
        searchView.queryHint = "Search artist"
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextChange(newText: String): Boolean {

                return false
            }

            override fun onQueryTextSubmit(query: String): Boolean {
                message.visible = true
                recycler.visible = false
                if (connectivityManager.activeNetworkInfo?.isConnected == true) {
                    viewModel.searchArtist(query)
                    message.text = "Searching..."
                } else {
                    message.text = "No internet connection"
                }
                return true
            }
        })
    }

    inner class ArtistManager : SearchAdapter.AdapterManager {
        override fun onArtistClicked(item: Artist, position: Int) {
            startActivity(Intent(activity, AlbumActivity::class.java).putExtra(
                EXTRA_ARTIST_ID, item.artistId))
        }
    }
}
