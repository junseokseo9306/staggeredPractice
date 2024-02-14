package practice.lemon.staggered.viewholder

import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.result
import practice.lemon.staggered.databinding.LayoutItemBinding
import practice.lemon.staggered.uimodel.ImageData
import practice.lemon.staggered.utils.DetailFragmentEvent
import practice.lemon.staggered.utils.Event
import practice.lemon.staggered.utils.TransactionEvent

class ImageListViewHolder(
    private val binding: LayoutItemBinding,
    private val transaction: MutableLiveData<Event<TransactionEvent>>
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(item: ImageData) {
        binding.imageview.load(item.image)
        binding.imageview.transitionName = item.id

        binding.imageview.setOnClickListener {
            transaction.value = Event(
                DetailFragmentEvent(
                    sharedElement = Pair(binding.imageview, "full_image"),
                    key = binding.imageview.result?.request?.memoryCacheKey,
                    imageUrl = item.image
                )
            )
        }
    }
}