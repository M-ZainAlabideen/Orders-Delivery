package com.orders.delivery.views.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.orders.delivery.databinding.FragmentOrdersBinding

class OrdersFragment : Fragment() {
    private var binding: FragmentOrdersBinding? = null

    companion object {
        var activity: FragmentActivity? = null
        var fragment: OrdersFragment? = null

        fun newInstance(activity: FragmentActivity): OrdersFragment? {
            OrdersFragment.activity = activity
            if (fragment == null)
                fragment = OrdersFragment()
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentOrdersBinding.inflate(inflater, container, false)
        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initActivity()
    }

    private fun initActivity() {
        if (OrdersFragment.activity == null)
            OrdersFragment.activity = activity
    }

}