package practice.lemon.staggered.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import practice.lemon.staggered.R
import practice.lemon.staggered.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        transactionFragment(ListFragment())
    }

    fun transactionFragment(
        fragment: Fragment,
        backStack: Boolean = false,
        sharedElement: Pair<View, String>? = null
    ) {
        supportFragmentManager.commit {
            setReorderingAllowed(true)
            if (backStack) {
                addToBackStack(null)
            }
            if (sharedElement != null) {
                addSharedElement(sharedElement.first, sharedElement.second)
            }
            replace(R.id.fragmentContainer, fragment, fragment::class.java.name)
        }
    }
}
