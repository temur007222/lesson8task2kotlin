package com.example.lesson8task2kotlin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.lesson8task2kotlin.Fragments.FirstFragment
import com.example.lesson8task2kotlin.Fragments.SecondFragment
import com.example.lesson8task2kotlin.Model.User

 class MainActivity : AppCompatActivity(), FirstFragment.FirstListener, SecondFragment.SecondListener {

  lateinit var firstFragment: FirstFragment
    lateinit var secondFragment: SecondFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
    }

    override fun onFirstSend(user: User) {
        secondFragment.updateSecondText(user)
    }

    override fun onSecondSend(user: User) {
        firstFragment.updateFirstText(user)
    }

    fun initViews(){
        firstFragment = FirstFragment()
        secondFragment = SecondFragment()
        supportFragmentManager.beginTransaction()
            .replace(R.id.frameFirst, firstFragment)
            .replace(R.id.frameSecond, secondFragment)
            .commit()
    }
}