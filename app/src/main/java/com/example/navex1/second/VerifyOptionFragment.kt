package com.example.navex1.second

import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.navex1.R
import com.example.navex1.base.BaseFragment
import com.example.navex1.databinding.FragmentVerifyOptionBinding

class VerifyOptionFragment : BaseFragment() {

    override val titleBar: String = "Verify"

    private lateinit var binding: FragmentVerifyOptionBinding
    private var state: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        state = arguments?.getString(BUNDLE_FROM)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        setHasOptionsMenu(true)
        binding = FragmentVerifyOptionBinding.bind(
            inflater.inflate(
                R.layout.fragment_verify_option,
                container,
                false
            )
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.textState.text = state

        onBackPressed {
            findNavController().navigate(R.id.action_second_to_inputInfo)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            findNavController().navigate(R.id.action_second_to_inputInfo)
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    companion object {
        const val BUNDLE_FROM = "BUNDLE_FROM"
    }
}