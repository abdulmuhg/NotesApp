package secretymus.id.notes.navigation

import android.content.Intent
import android.os.Bundle
import android.view.TouchDelegate
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import secretymus.id.notes.note.NoteListFragment
import secretymus.id.notes.R
import secretymus.id.notes.create.CreateActivity
import secretymus.id.notes.task.TaskListFragment

class NavigationActivity : AppCompatActivity(), TaskListFragment.TouchActionDelegate, NoteListFragment.TouchActionDelegate {
    private val mOnNavigationItemSelectedListener =
        BottomNavigationView.OnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_tasks -> {
                    replaceFragment(TaskListFragment.newInstance())
                    return@OnNavigationItemSelectedListener true
                }
                R.id.navigation_notes -> {
                    replaceFragment(NoteListFragment.newInstance())
                    return@OnNavigationItemSelectedListener true
                }
            }
            false
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navigation)
        replaceFragment(TaskListFragment.newInstance())
        val navigation = findViewById<View>(R.id.navigation) as BottomNavigationView
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }

    private fun replaceFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentHolder, fragment)
            .commit()

    }

    private fun goToCreateActivity(fragmentValue: String){
        startActivity(Intent(this, CreateActivity::class.java).apply {
            putExtra(FRAGMENT_TYPE_KEY, fragmentValue)
        })
    }

    override fun onAddButtonClicked(value: String) {
        goToCreateActivity(value)
    }

    companion object {
        const val FRAGMENT_TYPE_KEY = "f_t_k"
        const val FRAGMENT_VALUE_TASK = "f_v_t"
        const val FRAGMENT_VALUE_NOTE = "f_v_n"
    }

}