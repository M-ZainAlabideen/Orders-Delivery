package com.orders.delivery.views.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModelProvider
import com.orders.delivery.R
import com.orders.delivery.classes.GlobalFunctions
import com.orders.delivery.classes.Navigator
import com.orders.delivery.databinding.FragmentRegistrationBinding
import com.orders.delivery.model.Login
import com.orders.delivery.model.Value
import com.orders.delivery.view_model.LoginViewModel

class LoginFragment : Fragment() {
    private var binding: FragmentRegistrationBinding? = null
    private var viewModel: LoginViewModel? = null

    companion object {
        var activity: FragmentActivity? = null
        var fragment: LoginFragment? = null

        fun newInstance(activity: FragmentActivity): LoginFragment? {
            LoginFragment.activity = activity
            if (fragment == null)
                fragment = LoginFragment()
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
        initVisibility()
        setup()
        initViewModel()
        clicks()
    }

    private fun initActivity() {
        if (LoginFragment.activity == null)
            LoginFragment.activity = activity
    }

    private fun initVisibility() {
        binding?.year?.visibility = View.GONE
        binding?.financialUnit?.visibility = View.GONE
        binding?.branchNumber?.visibility = View.GONE
    }

    private fun setup() {
        binding?.done?.text = activity?.getString(R.string.login)
        binding?.show?.text = activity?.getString(R.string.show_more)
    }

    private fun initViewModel() {
        viewModel = ViewModelProvider(this)[LoginViewModel::class.java]
    }

    private fun loginApi(request: Login) {
        viewModel?.login(request)
            ?.observe(requireActivity()) { responseResult ->
                if (responseResult?.Result != null) {
                    Toast.makeText(activity, responseResult.Result.ErrMsg, Toast.LENGTH_LONG).show()
                    Navigator.loadFragment(
                        activity, OrdersFragment.newInstance(requireActivity()),
                        R.id.fragment_container, true
                    )
                }
            }
    }

    private fun clicks() {
        binding?.show?.setOnClickListener {
            Navigator.loadFragment(
                activity, RegistrationFragment.newInstance(requireActivity()),
                R.id.fragment_container, true
            )
        }

        binding?.done?.setOnClickListener {
            val value = Value("0", "1010", "1")
            var request = Login(value)
            loginApi(request)
        }
    }


}