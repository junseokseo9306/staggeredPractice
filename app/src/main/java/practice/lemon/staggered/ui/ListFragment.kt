package practice.lemon.staggered.ui

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import practice.lemon.staggered.R
import practice.lemon.staggered.adapter.ImageListAdapter
import practice.lemon.staggered.databinding.ListFragmentBinding
import practice.lemon.staggered.uimodel.ImageData
import practice.lemon.staggered.utils.viewBinding

class ListFragment : BaseFragment(R.layout.list_fragment) {
    private val binding: ListFragmentBinding by viewBinding()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val itemList = mutableListOf(
            ImageData("https://upload.wikimedia.org/wikipedia/commons/thumb/1/15/Cat_August_2010-4.jpg/2880px-Cat_August_2010-4.jpg"),
            ImageData("https://upload.wikimedia.org/wikipedia/commons/9/9b/Gustav_chocolate.jpg"),
            ImageData("https://upload.wikimedia.org/wikipedia/commons/thumb/b/b6/Felis_catus-cat_on_snow.jpg/2880px-Felis_catus-cat_on_snow.jpg"),
            ImageData("https://upload.wikimedia.org/wikipedia/commons/5/53/Sheba1.JPG"),
            ImageData("https://upload.wikimedia.org/wikipedia/commons/b/bb/Kittyply_edit1.jpg"),
        )

        val adapter = ImageListAdapter(viewModel.transactionEvent)
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager =
            StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL).apply {
                gapStrategy = StaggeredGridLayoutManager.GAP_HANDLING_MOVE_ITEMS_BETWEEN_SPANS
            }
        adapter.submitList(itemList)
    }
}