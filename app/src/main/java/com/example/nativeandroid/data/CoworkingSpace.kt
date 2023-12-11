package com.example.nativeandroid.data

import com.google.gson.annotations.SerializedName

data class CoworkingSpace (
  @SerializedName("organisation" ) var organisation : String?   = null,
  @SerializedName("address"      ) var address      : String?   = null,
  @SerializedName("website"      ) var website      : String?   = null,
  @SerializedName("latitude"     ) var latitude     : Double?   = null,
  @SerializedName("longitude"    ) var longitude    : Double?   = null,
  @SerializedName("geopoint"     ) var geopoint     : Geopoint? = Geopoint()
)