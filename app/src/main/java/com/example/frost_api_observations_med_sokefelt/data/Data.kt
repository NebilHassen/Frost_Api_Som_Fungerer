package com.example.frost_api_observations_med_sokefelt.data

import com.google.gson.annotations.SerializedName


data class Data (

    @SerializedName("sourceId"      ) var sourceId      : String?                 = null,
    @SerializedName("referenceTime" ) var referenceTime : String?                 = null,
    @SerializedName("observations"  ) var observations  : ArrayList<Observations> = arrayListOf()

)


data class Data_For_Koordinater (

    @SerializedName("@type"          ) var type          : String?           = null,
    @SerializedName("id"             ) var id             : String?           = null,
    @SerializedName("name"           ) var name           : String?           = null,
    @SerializedName("shortName"      ) var shortName      : String?           = null,
    @SerializedName("country"        ) var country        : String?           = null,
    @SerializedName("countryCode"    ) var countryCode    : String?           = null,
    @SerializedName("geometry"       ) var geometry       : Geometry?         = Geometry(),
    @SerializedName("masl"           ) var masl           : Int?              = null,
    @SerializedName("validFrom"      ) var validFrom      : String?           = null,
    @SerializedName("county"         ) var county         : String?           = null,
    @SerializedName("countyId"       ) var countyId       : Int?              = null,
    @SerializedName("municipality"   ) var municipality   : String?           = null,
    @SerializedName("municipalityId" ) var municipalityId : Int?              = null,
    @SerializedName("stationHolders" ) var stationHolders : ArrayList<String> = arrayListOf(),
    @SerializedName("externalIds"    ) var externalIds    : ArrayList<String> = arrayListOf(),
    @SerializedName("wigosId"        ) var wigosId        : String?           = null

)

data class Geometry (

    @SerializedName("@type"       ) var type       : String?           = null,
    @SerializedName("coordinates" ) var coordinates : ArrayList<Double> = arrayListOf(),
    @SerializedName("nearest"     ) var nearest     : Boolean?          = null

)