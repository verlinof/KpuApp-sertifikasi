package com.example.kpuapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.kpuapp.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    companion object{
        private val TAB_TITLES = intArrayOf(
            R.string.Informasi,
            R.string.Tambah
        )
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding){
            val sectionPager = FragmentAdapter(this@MainActivity)
            viewPager.adapter=sectionPager
            TabLayoutMediator(TabLayout,viewPager){
                    tab,position->tab.text= resources.getString((TAB_TITLES[position]))
            }.attach()
        }


    }
}