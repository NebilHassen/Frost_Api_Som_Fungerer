package com.example.frost_api_observations_med_sokefelt.data

import com.google.gson.annotations.SerializedName


data class Observations (

    @SerializedName("elementId"           ) var elementId           : String? = null,
    @SerializedName("value"               ) var value               : Double? = null,
    @SerializedName("unit"                ) var unit                : String? = null,
    @SerializedName("level"               ) var level               : Level?  = Level(),
    @SerializedName("timeOffset"          ) var timeOffset          : String? = null,
    @SerializedName("timeResolution"      ) var timeResolution      : String? = null,
    @SerializedName("timeSeriesId"        ) var timeSeriesId        : Int?    = null,
    @SerializedName("performanceCategory" ) var performanceCategory : String? = null,
    @SerializedName("exposureCategory"    ) var exposureCategory    : String? = null,
    @SerializedName("qualityCode"         ) var qualityCode         : Int?    = null

)