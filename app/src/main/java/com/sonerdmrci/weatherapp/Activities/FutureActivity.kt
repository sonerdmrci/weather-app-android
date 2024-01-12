package com.sonerdmrci.weatherapp.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sonerdmrci.weatherapp.Adapters.FutureAdapters
import com.sonerdmrci.weatherapp.Adapters.HourlyAdapters
import com.sonerdmrci.weatherapp.Domains.FutureDomain
import com.sonerdmrci.weatherapp.R

class FutureActivity : AppCompatActivity() {
    private var adapterTomorow: RecyclerView.Adapter<*>? = null
    private lateinit var recyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_future)

        initRecyclerView()
        setVariable()
    }

    private fun setVariable() {
        val backgButton: ConstraintLayout = findViewById(R.id.baskgButtonConstraint)

        backgButton.setOnClickListener {
            val intent = Intent(this@FutureActivity, MainActivity::class.java)
            startActivity(intent)
        }
    }

    private fun initRecyclerView() {
        var items: ArrayList<FutureDomain> = ArrayList()
        items.add(FutureDomain("Sat","storm","Fırtına",20,10))
        items.add(FutureDomain("Sun","cloudy","Bulutlu",25,14))
        items.add(FutureDomain("Mon","windy","Rüzgarlı",19,14))
        items.add(FutureDomain("Tue","cloudy_sunny","Bulutlu Güneşli",22,10))
        items.add(FutureDomain("Wen","sunny","Güneşli",24,11))
        items.add(FutureDomain("Thu","rainy","Yağmurlu",26,13))

        recyclerView = findViewById(R.id.recyclerView2)

        recyclerView.layoutManager = LinearLayoutManager(this)
        adapterTomorow = FutureAdapters(items)
        recyclerView.adapter = adapterTomorow
    }
}