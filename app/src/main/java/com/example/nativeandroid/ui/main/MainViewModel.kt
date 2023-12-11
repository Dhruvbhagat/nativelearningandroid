package com.example.nativeandroid.ui.main

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.nativeandroid.JsonExtension
import com.example.nativeandroid.data.CoworkingSpace
import com.example.nativeandroid.data.DataRepository
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import retrofit2.Call
import retrofit2.Response
import java.lang.reflect.Type

class MainViewModel(private val repository: DataRepository, private val context: Context?) : ViewModel() {

    private val jsonFile = "coworking-spaces.json"
    private val repo = "kotlin"
    val responseData = MutableLiveData<List<CoworkingSpace>?>()

    init {
        makeApiCall()
    }

    private fun makeApiCall() {
        repository.getAllCoworkSpaces(repo).enqueue(object : retrofit2.Callback<List<CoworkingSpace>> {
            override fun onFailure(call: Call<List<CoworkingSpace>?>, t: Throwable) {
                responseData.value = fetchJson()
            }

            override fun onResponse(
                call: Call<List<CoworkingSpace>>,
                response: Response<List<CoworkingSpace>>
            ) {
                if (!response.isSuccessful) responseData.value = fetchJson()
                else responseData.value = response.body()
            }
        })
    }

    private fun fetchJson() : List<CoworkingSpace>?
    {
        if (context == null)
        {
            return null
        }
        val jsonExtension = JsonExtension()
        val gson = Gson()
        val listType: Type = object : TypeToken<ArrayList<CoworkingSpace?>?>() {}.type
        return gson.fromJson(jsonExtension.loadJSONFromAsset(context, jsonFile), listType)
    }
}