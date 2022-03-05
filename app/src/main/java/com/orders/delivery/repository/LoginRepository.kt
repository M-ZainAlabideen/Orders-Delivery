package com.orders.delivery.repository

import android.app.Application
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.orders.delivery.classes.Constants
import com.orders.delivery.model.Login
import com.orders.delivery.model.response.GetResult
import com.orders.delivery.network.Retrofit
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers

class LoginRepository (application: Application) {
    private var application: Application? = null
    private var mutableLiveData: MutableLiveData<GetResult>? = null

    init {
        this.application = application
    }

    fun loginApi(login: Login): LiveData<GetResult?> {
        mutableLiveData = MutableLiveData<GetResult>()
        val leagues: Observable<GetResult?> =
            Retrofit.getRetrofitServices(application)!!.login(login)
        leagues.subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                Consumer { getLeagues: GetResult? -> handleResults(getLeagues!!) },
                Consumer { t: Throwable -> handleError(t) }
            )
        return mutableLiveData as MutableLiveData<GetResult>
    }


    private fun handleResults(getLeagues: GetResult) {
        mutableLiveData!!.value = getLeagues
    }

    private fun handleError(t: Throwable) {
        Log.d(Constants.PRINT,t.message.toString());
    }

}