package com.orders.delivery.view_model

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.orders.delivery.model.Login
import com.orders.delivery.model.response.GetResult
import com.orders.delivery.repository.LoginRepository

class LoginViewModel (application: Application) : AndroidViewModel(application) {
    var repository: LoginRepository
    init {
        repository = LoginRepository(application)
    }
    fun login(login: Login): LiveData<GetResult?> {
        return repository.loginApi(login)
    }
}