package com.example.nativeandroid.data

import com.example.nativeandroid.network.ApiEndPoint
import com.example.nativeandroid.network.RetrofitClient

class DataRepository {
    private val retrofit = RetrofitClient.getRetrofitInstance().create(ApiEndPoint::class.java)

    fun getAllCoworkSpaces() = retrofit.getAllCoworkSpaces()
}