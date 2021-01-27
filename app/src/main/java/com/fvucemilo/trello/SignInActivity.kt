package com.fvucemilo.trello

import android.content.Intent
import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import android.view.WindowManager
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_sign_in.*
import java.util.*

class SignInActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        btn_sign_in.setOnClickListener {
            // Launch the sign in screen.
            showUrl()
        }

        setupActionBar()
    }

    /**
     * A function for actionBar Setup.
     */
    private fun setupActionBar() {
        setSupportActionBar(toolbar_sign_in_activity)

        val actionBar = supportActionBar
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true)
            actionBar.setHomeAsUpIndicator(R.drawable.ic_black_color_back_24dp)
        }

        toolbar_sign_in_activity.setNavigationOnClickListener {
            onBackPressed()
        }
    }

    private fun showUrl() {
        val uri: Uri = Uri.parse("https://www.tvz.hr")
        startActivity(Intent(Intent.ACTION_VIEW, uri))
    }

    override fun onRestart() {
        super.onRestart()
        val rnd = Random()
        val color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256))
        val signInActivity = findViewById<LinearLayout>(R.id.test)
        signInActivity.setBackgroundColor(color)
    }
}