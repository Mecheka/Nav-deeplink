package com.example.navex1.main

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import com.example.navex1.R
import com.example.navex1.base.BaseFragment
import com.example.navex1.databinding.FragmentPinBinding
import com.example.navex1.second.VerifyOptionFragment

class PinFragment : BaseFragment() {

    private lateinit var binding: FragmentPinBinding
    override val titleBar: String = "Pin"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentPinBinding.bind(inflater.inflate(R.layout.fragment_pin, container, false))
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding.pinView) {
            addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(
                    s: CharSequence?,
                    start: Int,
                    count: Int,
                    after: Int
                ) {

                }

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                }

                override fun afterTextChanged(s: Editable?) {
                    if (s?.length == 6) {
                        findNavController().navigate(R.id.action_pinFragment_to_SecondGraph,
                        bundleOf(
                            VerifyOptionFragment.BUNDLE_FROM to "Nav"
                        ))
                        text?.clear()
                    }
                }
            })
        }
    }
}