package com.orders.delivery.views.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.orders.delivery.R
import com.orders.delivery.databinding.FragmentRegistrationBinding

class RegistrationFragment : Fragment() {
    private var binding: FragmentRegistrationBinding? = null

    companion object {
        var activity: FragmentActivity? = null
        var fragment: RegistrationFragment? = null

        fun newInstance(activity: FragmentActivity): RegistrationFragment? {
            RegistrationFragment.activity = activity
            if (fragment == null)
                fragment = RegistrationFragment()
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRegistrationBinding.inflate(inflater, container, false)
        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initActivity()
        setup()
    }

    private fun initActivity() {
        if (RegistrationFragment.activity == null)
            RegistrationFragment.activity = activity
    }

    private fun setup() {
        binding?.done?.text = activity?.getString(R.string.log_in)
        binding?.show?.text = activity?.getString(R.string.show_less)
    }
}