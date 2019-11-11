package cl.gringraz.itunesclient.feature.search

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import cl.gringraz.itunesclient.R
import cl.gringraz.itunesclient.domain.model.Artist
import cl.gringraz.itunesclient.ui.BaseAdapter
import cl.gringraz.itunesclient.ui.BaseViewHolder
import kotlinx.android.synthetic.main.item_artist.view.*

open class SearchAdapter(
    private val manager: AdapterManager
) : BaseAdapter<Artist>() {

    interface AdapterManager {
        fun onArtistClicked(item: Artist, position: Int)
    }

    override fun provideComparator() = compareBy(Artist::artistId)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<Artist> {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_artist, parent, false)

        return ArtistViewHolder(itemView).also { holder ->
            with(itemView) {
                setOnClickListener {
                    val item = holder.resolveItem()
                    if (item != null)
                        manager.onArtistClicked(item, holder.adapterPosition)
                }
            }
        }
    }

    inner class ArtistViewHolder(itemView: View): BaseViewHolder<Artist>(itemView) {
        override fun bindView(item: Artist) {
            with(itemView) {
                artistName.text = item.artistName
                artistGenre.text = item.primaryGenreName
            }
        }
    }
}
