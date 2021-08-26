package com.sarikaya.weatherforecastapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.OrientationHelper
import com.sarikaya.weatherforecastapp.R
import com.sarikaya.weatherforecastapp.adapter.MyAdapter
import com.sarikaya.weatherforecastapp.databinding.ActivityMainBinding
import com.sarikaya.weatherforecastapp.model.Sehir

class MainActivity : AppCompatActivity() {


    private lateinit var sehirList: ArrayList<Sehir>
    private lateinit var binding: ActivityMainBinding
    private lateinit var myAdapter : MyAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        sehirList = arrayListOf()
        sehirList.add(
            Sehir(
                "İstanbul",
                "Güneşli",
                "8:00 AM",
                "32",
                R.drawable.istanbul2,
                R.drawable.istanbul,
                R.drawable.sun,
                "0%",
                "14%",
                "3km/s",
                "29"
            )
        )
        sehirList.add(
            Sehir(
                "Ankara",
                "Bulutlu",
                "8:00 AM",
                "23",
                R.drawable.ankara,
                R.drawable.ankara2,
                R.drawable.cloud,
                "2%",
                "73%",
                "24km/s",
                "19"
            )
        )
        sehirList.add(
            Sehir(
                "Los Angeles",
                "Yağmurlu",
                "10:00 PM",
                "15",
                R.drawable.losangeles,
                R.drawable.losangeles2,
                R.drawable.yagmurlu,
                "100%",
                "56%",
                "34km/s",
                "12"
            )
        )
        sehirList.add(
            Sehir(
                "New York",
                "Bulutlu",
                "01:00 PM",
                "34",
                R.drawable.newyork,
                R.drawable.newyork2,
                R.drawable.cloud,
                "3%",
                "44%",
                "10km/s",
                "33"
            )
        )
        initView()
        val backFragment = BackFragment(sehirList[0])
        makeFragment(backFragment)
    }

    private fun initView(){
        binding.recyclerView.layoutManager = LinearLayoutManager(this, OrientationHelper.HORIZONTAL,false)
        binding.recyclerView.setHasFixedSize(true)

        myAdapter = MyAdapter(sehirList)
        binding.recyclerView.adapter = myAdapter
    }

    private fun makeFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragment,fragment)
            commit()
        }
    }
}