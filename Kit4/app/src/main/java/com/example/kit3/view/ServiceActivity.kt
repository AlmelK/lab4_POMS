package com.example.kit3

import android.app.ActivityManager
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

@Suppress("DEPRECATION")
class ServiceActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_service)

        val service = GeometryProg::class.java
        val intent = Intent(applicationContext, service)

        val btn_start = findViewById<Button>(R.id.startServ_btn)
        val btn_end = findViewById<Button>(R.id.stopServ_btn)

        btn_start.setOnClickListener {
            if(!ifServiceRunning()){
                startService(intent)
            }
            else
            {
                Toast.makeText(applicationContext, R.string.alrStartServ, Toast.LENGTH_SHORT).show()
            }
        }

        btn_end.setOnClickListener {
            if(ifServiceRunning()){
                stopService(intent)
            }
            else
                Toast.makeText(applicationContext, R.string.alrStopServ, Toast.LENGTH_SHORT).show()
        }

    }
    private fun ifServiceRunning(): Boolean{
        val actManager = getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
        for(service in actManager.getRunningServices(Integer.MAX_VALUE)){
            return true
        }
        return false
    }
}