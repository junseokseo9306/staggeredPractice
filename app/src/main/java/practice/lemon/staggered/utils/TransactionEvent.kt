package practice.lemon.staggered.utils

import android.view.View
import coil.memory.MemoryCache

sealed class TransactionEvent

data object ListFragmentEvent : TransactionEvent()

data class DetailFragmentEvent(
    val sharedElement: Pair<View, String>?,
    val key: MemoryCache.Key?,
    val imageUrl: String
) : TransactionEvent()
