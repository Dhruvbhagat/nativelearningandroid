package com.example.nativeandroid.data

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Geopoint (
  @SerializedName("lon" ) var lon : Double? = null,
  @SerializedName("lat" ) var lat : Double? = null
) : Serializable