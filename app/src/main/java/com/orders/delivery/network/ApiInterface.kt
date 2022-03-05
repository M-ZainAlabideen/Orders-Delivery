package com.orders.delivery.network

import com.orders.delivery.model.Login
import com.orders.delivery.model.response.GetOrders
import com.orders.delivery.model.response.GetResult
import io.reactivex.Observable
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiInterface {
    @POST("CheckDeliveryLogin")
    fun login(@Body login : Login): Observable<GetResult?>

    @POST("GetDeliveryBillsItems")
    fun orders(): Observable<GetOrders?>
}