package com.example.nativeandroid.network

import com.example.nativeandroid.data.CoworkingSpace
import retrofit2.Call
import retrofit2.http.GET

interface ApiEndPoint {
    @GET("coworkspaces")
    fun getAllCoworkSpaces() : Call<List<CoworkingSpace>>
}