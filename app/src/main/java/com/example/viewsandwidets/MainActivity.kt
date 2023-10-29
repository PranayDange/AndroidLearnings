package com.example.viewsandwidets

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //this will replace activity with fragment
        //i want that instead of activity my fragment should open when app is starting what is the procedure for that

        if (savedInstanceState == null) {
            val fragmentSignUp = SignUpFragment()
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, fragmentSignUp)
                .commit()
        }

    }
}