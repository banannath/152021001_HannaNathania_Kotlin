package com.example.uts

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import com.example.uts.fragments.fArticle1
import com.example.uts.fragments.fArticle2
import com.example.uts.fragments.fArticles
import com.example.uts.fragments.fGraph
import com.example.uts.fragments.fHome
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    private var name : String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        loadFragment(fHome())
//        name = intent.getStringExtra(USER)

        var bottomnavmenu = findViewById<BottomNavigationView>(R.id.bottom_nav)
        bottomnavmenu.setOnItemSelectedListener {
            when(it.itemId){
                R.id.bot_menu_home -> {
                    loadFragment(fHome())
                    true
                }
                R.id.bot_menu_graph -> {
                    loadFragment(fGraph())
                    true
                }
                R.id.bot_menu_articles -> {
                    loadFragment(fArticles())
                    true
                }
                R.id.bot_menu_profile -> {
                    val moveToMyProfileActivity= Intent(this, MyProfileActivity::class.java)
                    var username = intent.getStringExtra("username")
                    var pass = intent.getStringExtra("pass")
                    moveToMyProfileActivity.putExtra("username", username)
                    Log.d("tag", "onCreate: $username")
                    Log.d("tag", "onCreate: $pass")
                    moveToMyProfileActivity.putExtra("pass", pass)
                    startActivity(moveToMyProfileActivity)
                    true
                } R.id.articles1 -> {
                    loadFragment(fArticle1())
                    true
                } R.id.articles2 -> {
                    loadFragment(fArticle2())
                    true
                }

                else -> {
                    false
                }
            }
        }
    }

    private  fun loadFragment(fragment: Fragment){
        val transaction = supportFragmentManager.beginTransaction()
//        name?.let {
//            val mBundle = Bundle()
//            mBundle.putString("mText",name)
//            fragment.arguments = mBundle
//        }
        transaction.replace(R.id.container,fragment)
        transaction.commit()
    }


}

