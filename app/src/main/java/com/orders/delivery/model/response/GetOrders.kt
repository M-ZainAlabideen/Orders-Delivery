package com.orders.delivery.model.response

data class GetOrders(
    val Data: Data,
    val Result: Result
)

data class Data(
    val DeliveryBills: List<DeliveryBill>
)

data class DeliveryBill(
    val BILL_AMT: String,
    val BILL_DATE: String,
    val BILL_NO: String,
    val BILL_SRL: String,
    val BILL_TIME: String,
    val CSTMR_ADDRSS: String,
    val CSTMR_APRTMNT_NO: String,
    val CSTMR_BUILD_NO: String,
    val CSTMR_FLOOR_NO: String,
    val CSTMR_NM: String,
    val DLVRY_AMT: String,
    val DLVRY_STATUS_FLG: String,
    val LATITUDE: String,
    val LONGITUDE: String,
    val MOBILE_NO: String,
    val RGN_NM: String,
    val TAX_AMT: String
)