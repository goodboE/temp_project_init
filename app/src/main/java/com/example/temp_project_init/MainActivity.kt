package com.example.temp_project_init


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.temp_project_init.databinding.ActivityMainBinding
import com.example.temp_project_init.fragment.ChatListFragment
import com.example.temp_project_init.fragment.HomeFragment
import com.example.temp_project_init.fragment.InfoFragment

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    private val bottomNavigationView by lazy {
        binding.bottomNavigationView
    }
    private val homeFragment by lazy {
        HomeFragment()
    }
    private val chatListFragment by lazy {
        ChatListFragment()
    }
    private val infoFragment by lazy {
        InfoFragment()
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        changeFragment(homeFragment)

        bottomNavigationView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.menu_home -> {
                    changeFragment(homeFragment)
                }
                R.id.menu_chat -> {
                    changeFragment(chatListFragment)
                }
                R.id.menu_info -> {
                    changeFragment(infoFragment)
                }
            }
            true
        }
    }

    private fun changeFragment(frag: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, frag).commit()
    }

}