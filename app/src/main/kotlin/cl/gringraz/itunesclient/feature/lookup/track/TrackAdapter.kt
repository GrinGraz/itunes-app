package cl.gringraz.itunesclient.feature.lookup.track

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import cl.gringraz.itunesclient.R
import cl.gringraz.itunesclient.feature.lookup.track.model.TrackItem
import cl.gringraz.itunesclient.ui.BaseAdapter
import cl.gringraz.itunesclient.ui.BaseViewHolder
import kotlinx.android.synthetic.main.item_track.view.*

class TrackAdapter : BaseAdapter<TrackItem>() {

    override fun provideComparator() = compareBy(TrackItem::trackId)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<TrackItem> {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_track, parent, false)

        return TrackViewHolder(itemView)
    }

    inner class TrackViewHolder(itemView: View) : BaseViewHolder<TrackItem>(itemView) {
        override fun bindView(item: TrackItem) {
            with(itemView) {
                trackName.text = item.trackName
            }
        }
    }
}
