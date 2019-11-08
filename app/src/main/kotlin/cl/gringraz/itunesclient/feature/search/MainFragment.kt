package cl.gringraz.itunesclient.feature.search

import android.os.Bundle
import android.view.*
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import cl.gringraz.itunesclient.R
import cl.gringraz.itunesclient.util.getViewModelFactory

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private val viewModel by viewModels<SearchViewModel> { getViewModelFactory() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.list_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        setupSearchviewMenu(menu, inflater)
        return super.onCreateOptionsMenu(menu, inflater)
    }

    private fun setupSearchviewMenu(menu: Menu, inflater: MenuInflater) {
        setupSearchviewMenu(menu, inflater)
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
                viewModel.searchArtist(query)
                return true
            }
        })
    }
}
