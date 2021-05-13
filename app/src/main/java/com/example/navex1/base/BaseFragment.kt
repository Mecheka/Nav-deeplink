package com.example.navex1.base

import android.os.Bundle
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment


open class BaseFragment : Fragment() {

    open val titleBar: String? = null
    private val baseActivity: BaseActivity
        get() = (activity as BaseActivity)

    private val _onBackPressed: () -> Unit = {}

    fun onBackPressed(block: () -> Unit) {

        val callback: OnBackPressedCallback =
            object : OnBackPressedCallback(true /* enabled by default */) {
                override fun handleOnBackPressed() {
                    // Handle the back button event
                    block.invoke()
                }
            }
        requireActivity().onBackPressedDispatcher.addCallback(this, callback)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setUpTitle(titleBar)
    }

    fun setUpTitle(title: String? = null) {
        baseActivity.updateTitleBar(title)
    }
}