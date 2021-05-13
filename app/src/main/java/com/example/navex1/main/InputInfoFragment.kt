package com.example.navex1.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.navex1.R
import com.example.navex1.base.BaseFragment
import com.example.navex1.databinding.FragmentInputInfoBinding

class InputInfoFragment : BaseFragment() {

    private lateinit var binding: FragmentInputInfoBinding

    override val titleBar: String = "Input info"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentInputInfoBinding.bind(
            inflater.inflate(
                R.layout.fragment_input_info,
                container,
                false
            )
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnNext.setOnClickListener {
            findNavController().navigate(R.id.action_inputInfoFragment_to_pinFragment)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        outState.putString(INSTANCE_CETIZEN, binding.editTextCitizenId.text.toString())
        outState.putString(INSTANCE_PHONE, binding.editTextPhone.text.toString())
    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)

        savedInstanceState?.let {
            binding.editTextCitizenId.setText(it.getString(INSTANCE_CETIZEN))
            binding.editTextPhone.setText(it.getString(INSTANCE_PHONE))
        }
    }

    companion object {
        private const val INSTANCE_CETIZEN = "INSTANCE_CETIZEN"
        private const val INSTANCE_PHONE = "INSTANCE_PHONE"
    }
}