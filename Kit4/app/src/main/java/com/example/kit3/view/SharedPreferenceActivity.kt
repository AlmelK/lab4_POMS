package com.example.kit3.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kit3.R

class SharedPreferenceActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shared_preference)
        supportFragmentManager.beginTransaction().replace(R.id.for_sh_frag, SharedPrefFragment()).commit()
    }
}