package com.example.lesson8task2kotlin.Fragments

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.annotation.Nullable
import androidx.fragment.app.Fragment
import com.example.lesson8task2kotlin.Model.User
import com.example.lesson8task2kotlin.R

class FirstFragment: Fragment() {
    lateinit var user: User
    private var listener: FirstListener? = null
     lateinit var textView: TextView
     lateinit var tv_first: TextView
     var TAG: String = "Message"

  fun FirstFragment(users: User, listener: FirstListener) {
        this.user = users
        this.listener = listener
    }

    fun FirstFragment(){}

    @Nullable
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val view: View = inflater.inflate(R.layout.fragment_first, container, false)

        tv_first = view.findViewById(R.id.tv_first)
       val b_first: Button = view.findViewById(R.id.b_first)
        b_first.setOnClickListener{
            getData()
        }
        return view
    }

    fun getData(){
        var users = User("Nick", 20)
        Log.d(TAG, users.toString())

        listener?.onFirstSend(users)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        listener = if (context is FirstListener) {
            context
        } else {
            throw RuntimeException("$context must implement FirstListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null

    }

    fun updateFirstText(user: User ){
        tv_first.setText(user.toString())
    }

    interface FirstListener{
        fun onFirstSend(user: User)
    }
}