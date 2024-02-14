package practice.lemon.staggered.ui

import android.os.Bundle
import android.view.View
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import practice.lemon.staggered.utils.DetailFragmentEvent
import practice.lemon.staggered.utils.ListFragmentEvent
import practice.lemon.staggered.viewmodel.ListViewModel

open class BaseFragment(@LayoutRes val contentLayoutId: Int) : Fragment(contentLayoutId) {

    protected val viewModel: ListViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val activity = activity ?: return
        val mainActivity = activity as MainActivity

        viewModel.transactionEvent.observe(viewLifecycleOwner) {
            val event = it.getContentIfNotHandled() ?: return@observe

            when (event) {
                is ListFragmentEvent -> {
                    mainActivity.transactionFragment(
                        fragment = ListFragment(),
                        backStack = true
                    )
                }

                is DetailFragmentEvent -> {
                    val detailFragment = DetailFragment.newInstance(event.key, event.imageUrl)
                    mainActivity.transactionFragment(
                        fragment = detailFragment,
                        backStack = true,
                        sharedElement = event.sharedElement
                    )
                }
            }
        }
    }
}