package com.example.kit3.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.ImageView
import com.example.kit3.R

class Graphic : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_graphic)

        val image: ImageView = findViewById(R.id.imageView)
        val image2: ImageView = findViewById(R.id.imageView2)
        val btn_anim1 = findViewById<Button>(R.id.animate1)
        val btn_anim2 = findViewById<Button>(R.id.btn_anim2)

        val animate1 = AnimationUtils.loadAnimation(this, R.anim.move_alpha)
        val animate2 = AnimationUtils.loadAnimation(this, R.anim.rotate_scale)


        btn_anim1.setOnClickListener { image.startAnimation(animate1) }
        btn_anim2.setOnClickListener { image2.startAnimation(animate2) }
    }
}