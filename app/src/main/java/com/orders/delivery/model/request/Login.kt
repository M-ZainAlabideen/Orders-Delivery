package com.orders.delivery.model

data class Login(
    val Value: Value
)

data class Value(
    val P_DLVRY_NO: String,
    val P_LANG_NO: String,
    val P_PSSWRD: String
)