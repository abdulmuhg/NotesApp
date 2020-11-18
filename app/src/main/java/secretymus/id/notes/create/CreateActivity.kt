package secretymus.id.notes.create

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_create.*
import secretymus.id.notes.R
import secretymus.id.notes.navigation.NavigationActivity

class CreateActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create)

        textView.text = intent?.getStringExtra(NavigationActivity.FRAGMENT_TYPE_KEY)
    }
}