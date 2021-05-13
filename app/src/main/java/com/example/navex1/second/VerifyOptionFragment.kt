package com.example.navex1.second

import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.navex1.R
import com.example.navex1.base.BaseFragment
import com.example.navex1.databinding.FragmentVerifyOptionBinding

class VerifyOptionFragment : BaseFragment() {

    override val titleBar: String = "Verify"
    private val args: VerifyOptionFragmentArgs by navArgs()

    private lateinit var binding: FragmentVerifyOptionBinding
    private var state: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        state = arguments?.getString(BUNDLE_FROM) ?: args.text
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
            findNavController().navigate(R.id.action_verifyOptionFragment2_to_inputInfoFragment)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            findNavController().navigate(R.id.action_verifyOptionFragment2_to_inputInfoFragment)
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    companion object {
        const val BUNDLE_FROM = "BUNDLE_FROM"
    }
}