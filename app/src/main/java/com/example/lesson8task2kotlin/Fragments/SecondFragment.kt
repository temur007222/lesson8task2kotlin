package com.example.lesson8task2kotlin.Fragments

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.lesson8task2kotlin.Model.User
import com.example.lesson8task2kotlin.R

final class SecondFragment: Fragment(){
    private var listener: SecondListener? = null
    lateinit var tv_second: TextView
    var TAG = SecondFragment::class.java.toString()
    lateinit var user: User

    @SuppressLint("CutPasteId")
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view: View = inflater.inflate(R.layout.fragment_second, container, false)

        tv_second = view.findViewById(R.id.tv_second)
        var b_second: Button = view.findViewById(R.id.b_second)
        b_second.setOnClickListener{
            getData()
        }
        return view
    }

    private fun getData(){
        val users = User("Mark", 21)
        Log.d(TAG, users.toString())

        listener?.onSecondSend(users)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = if (context is SecondListener) {
            context
        } else {
            throw RuntimeException("$context must implement SecondListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    fun updateSecondText(data: User){
        tv_second.text = data.toString()
    }

    interface SecondListener{
        fun onSecondSend(user: User)
    }
}