package practice.lemon.staggered.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import practice.lemon.staggered.utils.Event
import practice.lemon.staggered.utils.TransactionEvent

class ListViewModel : ViewModel() {
    val transactionEvent: MutableLiveData<Event<TransactionEvent>> = MutableLiveData()
}