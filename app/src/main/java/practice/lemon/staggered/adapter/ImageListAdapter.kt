package practice.lemon.staggered.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import practice.lemon.staggered.databinding.LayoutItemBinding
import practice.lemon.staggered.uimodel.ImageData
import practice.lemon.staggered.utils.Event
import practice.lemon.staggered.utils.TransactionEvent
import practice.lemon.staggered.viewholder.ImageListViewHolder

class ImageListAdapter(
    private val transaction: MutableLiveData<Event<TransactionEvent>>
) : ListAdapter<ImageData, ImageListViewHolder>(ImageListDiffUtil) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageListViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = LayoutItemBinding.inflate(layoutInflater, parent, false)
        return ImageListViewHolder(binding, transaction = transaction)
    }

    override fun onBindViewHolder(holder: ImageListViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }
}

object ImageListDiffUtil : DiffUtil.ItemCallback<ImageData>() {
    override fun areItemsTheSame(oldItem: ImageData, newItem: ImageData): Boolean {
        return oldItem.image == newItem.image
    }

    override fun areContentsTheSame(oldItem: ImageData, newItem: ImageData): Boolean {
        return oldItem == newItem
    }
}