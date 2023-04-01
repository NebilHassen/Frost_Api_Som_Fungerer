package com.example.frost_api_observations_med_sokefelt.data


import android.util.Log
import com.example.frost_api_observations_med_sokefelt.Frost_API_Respons

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.serialization.gson.*
import io.ktor.client.plugins.auth.*
import io.ktor.client.plugins.auth.providers.*

class DataSource (val path: String ) {


    private val client = HttpClient () {

        install(Auth) {
            basic {
                credentials {
                    BasicAuthCredentials(username = "1cf3b8eb-0fbd-46c9-803d-32206f191ccf", password = "")
                }
            }
        }


        install( ContentNegotiation ) {
            gson()

        }
    }




    suspend fun fetchApiSvar() : Frost_API_Respons {

        val respons : Frost_API_Respons = client.get(path).body()
        Log.d("API call", respons.toString())
        return respons
    }



    suspend fun fetchApiSvarkoordinater() : Frost_API_Respons_for_koordinater {

        val respons2 : Frost_API_Respons_for_koordinater = client.get(path).body()
        Log.d("API call2", respons2.toString())
        return respons2
    }




}