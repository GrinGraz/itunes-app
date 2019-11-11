package cl.gringraz.itunesclient.feature.lookup

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import cl.gringraz.itunesclient.R
import cl.gringraz.itunesclient.util.ViewModelFactory
import org.koin.android.ext.android.inject

class TrackFragment : Fragment() {
    companion object {
        fun newInstance() = AlbumFragment()
    }

    private val viewModelFactory: ViewModelFactory by inject()
    private val viewModel by viewModels<LookupViewModel> { viewModelFactory }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.list_fragment, container, false)

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }
}
