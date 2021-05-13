package com.example.navex1.second

import android.os.Bundle
import androidx.core.os.bundleOf
import androidx.navigation.fragment.NavHostFragment
import com.example.navex1.R
import com.example.navex1.base.BaseActivity
import com.example.navex1.databinding.ActivitySecondBinding

class SecondActivity : BaseActivity() {

    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHost = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHost.navController
        navController.setGraph(R.navigation.nav_second_graph, bundleOf(
            VerifyOptionFragment.BUNDLE_FROM to "Deeplink"
        ))
    }
}