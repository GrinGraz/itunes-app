package cl.gringraz.itunesclient.feature.lookup

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import cl.gringraz.itunesclient.R

class AlbumFragment : Fragment() {
    companion object {
        fun newInstance() = AlbumFragment()
    }

    private lateinit var viewModel: LookupViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.list_fragment, container, false)

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(LookupViewModel::class.java)
        // TODO: Use the ViewModel
    }
}
