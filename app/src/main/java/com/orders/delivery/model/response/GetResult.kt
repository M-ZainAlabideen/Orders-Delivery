package com.orders.delivery.model.response

data class GetResult(
    val Result: Result
)

data class Result(
    val ErrMsg: String,
    val ErrNo: Int
)