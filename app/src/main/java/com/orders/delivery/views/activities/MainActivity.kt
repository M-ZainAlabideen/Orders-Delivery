package com.orders.delivery.views.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.orders.delivery.R
import com.orders.delivery.classes.Navigator
import com.orders.delivery.views.fragments.LoginFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Navigator.loadFragment(this,LoginFragment.newInstance(this),R.id.fragment_container,true)
    }
}