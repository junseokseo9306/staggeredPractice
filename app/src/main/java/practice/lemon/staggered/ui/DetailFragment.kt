package practice.lemon.staggered.ui

import android.os.Build
import android.os.Bundle
import android.transition.TransitionInflater
import android.view.View
import androidx.annotation.RequiresApi
import androidx.core.os.bundleOf
import coil.load
import coil.memory.MemoryCache
import practice.lemon.staggered.R
import practice.lemon.staggered.databinding.DetailFragmentBinding
import practice.lemon.staggered.utils.viewBinding

class DetailFragment : BaseFragment(R.layout.detail_fragment) {
    private val binding: DetailFragmentBinding by viewBinding()

    companion object {
        private const val ARG_IMAGE_KEY = "image_key"
        private const val ARG_IMAGE_URL = "image_url"

        fun newInstance(
            imageKey: MemoryCache.Key?,
            imageUrl: String
        ) = DetailFragment().apply {
            arguments = bundleOf(
                ARG_IMAGE_KEY to imageKey,
                ARG_IMAGE_URL to imageUrl
            )
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val context = context ?: return
        val animation = TransitionInflater.from(context)
            .inflateTransition(android.R.transition.move)

        sharedElementEnterTransition = animation
        sharedElementReturnTransition = animation
    }

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        postponeEnterTransition()

        val imageKey = arguments?.getParcelable(ARG_IMAGE_KEY, MemoryCache.Key::class.java)
        val imageUrl = arguments?.getString(ARG_IMAGE_URL) ?: ""

        binding.fullImageView.load(imageUrl) {
            placeholderMemoryCacheKey(imageKey)
            this.listener(
                onSuccess = { _, _ ->
                    startPostponedEnterTransition()
                }
            )
        }
    }
}