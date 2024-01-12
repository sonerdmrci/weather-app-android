package com.sonerdmrci.weatherapp.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sonerdmrci.weatherapp.Adapters.HourlyAdapters
import com.sonerdmrci.weatherapp.Domains.Hourly
import com.sonerdmrci.weatherapp.R

class MainActivity : AppCompatActivity() {

    private var adapterHourly: RecyclerView.Adapter<*>? = null

    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initRecyclerview()
        setVeriable()
    }

    private fun setVeriable() {
        val textView:TextView = findViewById(R.id.nextSeccond)
        textView.setOnClickListener {
            val intent = Intent(this@MainActivity, FutureActivity::class.java)
            startActivity(intent)
        }
    }

    private fun initRecyclerview() {
        var items: ArrayList<Hourly> = ArrayList()
        items.add(Hourly("9 pm",28,"cloudy"))
        items.add(Hourly("11 pm",29,"sunny"))
        items.add(Hourly("12 pm",30,"wind"))
        items.add(Hourly("1 pm",27,"rainy"))
        items.add(Hourly("2 pm",25,"storm"))

        recyclerView = findViewById(R.id.recyclerView)

        recyclerView.setLayoutManager(LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL, false))

        adapterHourly = HourlyAdapters(items)
        recyclerView.setAdapter(adapterHourly)

    }
}