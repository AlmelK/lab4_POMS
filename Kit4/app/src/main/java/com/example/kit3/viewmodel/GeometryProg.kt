package com.example.kit3

import android.app.Service
import android.content.Intent
import android.os.Handler
import android.os.IBinder
import android.widget.Toast
import java.io.File
import java.util.*

@Suppress("DEPRECATION")
class GeometryProg : Service() {
    private lateinit var mHandler: Handler
    private lateinit var mRunnable: Runnable
    private var number: Int = 1
    private var text: String = ""

    override fun onBind(intent: Intent): IBinder? {
        return null
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Toast.makeText(applicationContext, R.string.startServ, Toast.LENGTH_SHORT).show()

        mHandler = Handler()
        mRunnable = Runnable { geomProg() }
        mHandler.postDelayed(mRunnable, 5000)
        return super.onStartCommand(intent, flags, startId)
    }

    override fun onDestroy() {
        super.onDestroy()
        Toast.makeText(applicationContext, R.string.stopServ, Toast.LENGTH_SHORT).show()
        mHandler.removeCallbacks(mRunnable)
    }

    private fun geomProg(){
        text += "Step: $number\n"
        writeToFile(text)
        number = number*2
        Toast.makeText(applicationContext, "Next step: $number", Toast.LENGTH_SHORT).show()
        mHandler.postDelayed(mRunnable, 5000)
    }

    fun writeToFile(str: String){
        val file = File(this.filesDir,"service_file.txt")
        file.outputStream().use {
            outputStream -> outputStream.write(str.toByteArray())
        }
    }
}