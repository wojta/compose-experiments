package cz.sazel.android.composableexperiments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import cz.sazel.android.composableexperiments.view.MainActivityView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainActivityView(title = getString(R.string.app_name))
        }
    }
}