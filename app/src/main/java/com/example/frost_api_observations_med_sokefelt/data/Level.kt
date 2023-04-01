package com.example.frost_api_observations_med_sokefelt.data

import com.google.gson.annotations.SerializedName


data class Level (

    @SerializedName("levelType" ) var levelType : String? = null,
    @SerializedName("unit"      ) var unit      : String? = null,
    @SerializedName("value"     ) var value     : Int?    = null

)