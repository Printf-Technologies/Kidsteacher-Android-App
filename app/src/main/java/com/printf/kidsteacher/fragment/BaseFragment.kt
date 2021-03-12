package com.printf.kidsteacher.fragment

import android.content.Context
import com.google.gson.Gson
import android.os.Bundle
import androidx.fragment.app.Fragment

open class BaseFragment : Fragment() {
    var gson: Gson? = null

    @JvmField
    protected var activity: Context? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        gson = Gson()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        activity = context
    }
}