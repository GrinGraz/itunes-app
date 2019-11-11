package cl.gringraz.itunesclient.feature.lookup.album

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import cl.gringraz.itunesclient.R
import cl.gringraz.itunesclient.domain.model.Album
import cl.gringraz.itunesclient.ui.BaseAdapter
import cl.gringraz.itunesclient.ui.BaseViewHolder
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_album.view.*

class AlbumAdapter(
    private val manager: AdapterManager
) : BaseAdapter<Album>() {

    interface AdapterManager {
        fun onAlbumClicked(item: Album, position: Int)

        fun provideImageLoader(): Picasso
    }

    override fun provideComparator() = compareBy(Album::collectionId)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<Album> {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_album, parent, false)

        return AlbumViewHolder(itemView, manager).also { holder ->
            with(itemView) {
                setOnClickListener {
                    val item = holder.resolveItem()

                    if (item != null)
                        manager.onAlbumClicked(item, holder.adapterPosition)
                }
            }
        }
    }

    inner class AlbumViewHolder(itemView: View, private val manager: AdapterManager) : BaseViewHolder<Album>(itemView) {
        override fun bindView(item: Album) {
            with(itemView) {
                albumName.text = item.collectionName
                albumArtistName.text = item.artistName

                val artworkUrl = item.artworkUrl100

                if (artworkUrl.isNotBlank())
                    with(receiver = manager.provideImageLoader()) {
                        load(artworkUrl)
                            .placeholder(R.mipmap.ic_launcher_round)
                            .into(albumCover)
                    }
                else
                    albumCover.setImageResource(R.mipmap.ic_launcher_round)
            }
        }
    }
}
