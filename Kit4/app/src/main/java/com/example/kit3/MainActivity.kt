package com.example.kit3

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.FrameLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_number.*
import org.w3c.dom.Text
import java.util.ArrayList

//lateinit var history: ArrayList<ItemView>

class MainActivity : AppCompatActivity() {
    private var history: ArrayList<ItemView> = ArrayList()
    private var ifNum: Boolean = true

    companion object {
        const val HISTORY_KEY = "history"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragSlot = findViewById<FrameLayout>(R.id.fragment_holder)
        val btnCh = findViewById<Button>(R.id.btnCh)


        if(fragSlot!= null){
            setNumFrag()
            btnCh.setOnClickListener{
                if(ifNum)
                    setFragStr()
                else
                    setNumFrag()
            }
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putParcelableArrayList(HISTORY_KEY, history)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        if (savedInstanceState != null && savedInstanceState.containsKey(HISTORY_KEY))
            history = savedInstanceState.getParcelableArrayList<ItemView>(HISTORY_KEY)!!
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_activity_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId==R.id.open_history)
        {
            val intent = Intent(this, HistoryActivity::class.java)
            intent.putExtra(HISTORY_KEY,history)
            Log.d("lol",history.size.toString())
            startActivity(intent)
        }
        else if(item.itemId == R.id.open_service)
        {
            val intent = Intent(this, ServiceActivity::class.java)
            startActivity(intent)
        }
        else if(item.itemId == R.id.open_browser)
        {
            val intent = Intent(this, OpenBrowser::class.java)
            startActivity(intent)
        }
        return super.onOptionsItemSelected(item)
    }

    fun setFrag(fragment: Fragment){
        val manager = supportFragmentManager
        val trans = manager.beginTransaction()
        trans.replace(R.id.fragment_holder, fragment)
        trans.commit()
    }

    fun setFragStr(){
        val fragment = StringFragment()
        setFrag(fragment)
        ifNum = false
    }

    fun setNumFrag(){
        val fragment = NumberFragment()
        setFrag(fragment)
        ifNum = true
    }

    fun addItem(newItem: ItemView){ history.add(newItem)}

}