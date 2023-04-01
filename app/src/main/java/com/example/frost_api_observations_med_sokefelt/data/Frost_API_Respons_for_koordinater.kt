package com.example.frost_api_observations_med_sokefelt.data

import com.google.gson.annotations.SerializedName

data class Frost_API_Respons_for_koordinater (



    @SerializedName("@context"         ) var context         : String?         = null,
    @SerializedName("@type"            ) var type            : String?         = null,
    @SerializedName("apiVersion"       ) var apiVersion       : String?         = null,
    @SerializedName("license"          ) var license          : String?         = null,
    @SerializedName("createdAt"        ) var createdAt        : String?         = null,
    @SerializedName("queryTime"        ) var queryTime        : Double?         = null,
    @SerializedName("currentItemCount" ) var currentItemCount : Int?            = null,
    @SerializedName("itemsPerPage"     ) var itemsPerPage     : Int?            = null,
    @SerializedName("offset"           ) var offset           : Int?            = null,
    @SerializedName("totalItemCount"   ) var totalItemCount   : Int?            = null,
    @SerializedName("currentLink"      ) var currentLink      : String?         = null,
    @SerializedName("data"             ) var data_for_koordinater: ArrayList<Data_For_Koordinater> = arrayListOf()


)