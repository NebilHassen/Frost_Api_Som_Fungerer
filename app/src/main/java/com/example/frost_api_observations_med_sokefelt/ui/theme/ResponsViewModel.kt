package com.example.frost_api_observations_med_sokefelt.ui.theme

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.frost_api_observations_med_sokefelt.data.DataSource

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ResponseViewModel: ViewModel() {


    // Vi separer query parameters med egne variabler(source, elements, baseurl, referencetime):
    // Videre så følger vi standarden om at tegnet: "?" skiller path og query: Så er et søk lesbart

    private val baseurl = "https://frost.met.no/observations/v0.jsonld?"
    private val elements = "air_temperature"// Dette er værmålingen vi ønsker: For enkelthetsskyld så velges bare: air temperature
    private val referencetime ="2021-05-17%2F2021-05-17" // Frost API, bruker UTC-tidsformat, denne ønskes senere å kunne bestemmes av en bruker ved hjelp av en Date picker (en bibloteksfunskjon i jetpack compose)

    var source = "SN55770"// Sensor stedskode: Denne stringen beskriver stedet til der du gjør kallet: SN= angir typen sensor (SN står for "sensory system"). Tallet 18700 er koden for en konkrekt lokalisasjon.%3A0: Angir hvilket kvalitet



    fun settSource ( text: String ): Unit {
        source=text
    }

    var url = "${baseurl}sources=${source}&referencetime=${referencetime}&elements=${elements}" // den kontruerste urlen




//------------------------------------------------------------------------------------------------------------------------------------
    var url_med_Polygon_utenVariabler ="https://frost.met.no/sources/v0.jsonld?types=SensorSystem&elements=air_temperature&geometry=POLYGON((7.9982%2058.1447%20%2C%208.0982%2058.1447%20%2C7.9982%2058.2447%20%2C%208.0982%2058.2447%20))"

    var polygon_uten_variabler= "POLYGON((7.9982%2058.1447%20%2C%208.0982%2058.1447%20%2C7.9982%2058.2447%20%2C%208.0982%2058.2447%20))"


// POLYGON((7.9982 58.1447 , 8.0982 58.1447 ,7.9982 58.2447 , 8.0982 58.2447 ))



    var long_Point1 : Double =0.0
    var lat_Point1  : Double =0.0


    var long_Point2 : Double =0.0
    var lat_Point2 : Double =0.0

    var long_Point3 : Double =0.0
    var lat_Point3 : Double =0.0

    var long_Point4 : Double =0.0
    var lat_Point4 : Double =0.0



    // Dette er en firkant: kan endres til en seks- eller åttekant
    var polygon_med_variabler= "POLYGON((${long_Point1}%20${lat_Point1}%2C${long_Point2}%20${lat_Point2}%2C${long_Point3}%20${lat_Point3}%2C${long_Point4}%20${lat_Point4}))"





    var url_med_Polygon_med_variabler ="https://frost.met.no/sources/v0.jsonld?types=SensorSystem&elements=air_temperature&geometry=${polygon_med_variabler}"



    var url_med_Polygon ="https://frost.met.no/sources/v0.jsonld?types=SensorSystem&elements=air_temperature&geometry=POLYGON((7.9982%2058.1447%20%2C%208.0982%2058.1447%20%2C7.9982%2058.2447%20%2C%208.0982%2058.2447%20))"


    init {
        Log.d("tekst", source)
    
    }



    /*

     fun setturl (  ): Unit {
        if (source != "SN55770") {
             url = "${baseurl}sources=${source}&referencetime=${referencetime}&elements=${elements}"
        }
    }


    */











/*

    fun koordinat_Til_Polygon_konverter ( longitutde: Double , latitude: Double): String  {

        var long_Point1 =longitutde
        var lat_Point1 =latitude


        var long_Point2 =longitutde+0.1
        var lat_Point2 =latitude

        var long_Point3 =longitutde
        var lat_Point3 =latitude+0.1

        var long_Point4 =longitutde+0.1
        var lat_Point4 =latitude+0.1


        // Dette er en firkant: kan endres til en seks- eller åttekant
        var polygon= "POLYGON((${long_Point1} ${lat_Point1} , ${long_Point2} ${lat_Point2} ,${long_Point3} ${lat_Point3} , ${long_Point4} ${lat_Point4} ))"

        return polygon
    }


    fun main () {

        println(koordinat_Til_Polygon_konverter ( 18.9503, 69.6613 )) // Tromsø
        println(koordinat_Til_Polygon_konverter ( 10.757933, 59.911491)) // oslo
        println(koordinat_Til_Polygon_konverter ( 7.9982,58.1447)) // kristiansand


    }
*/


















// funker ikke å ha en egen url-variable: Og heller ikke å lage en streng som




    private val url_uten_variable_erstatninger = "https://frost.met.no/observations/v0.jsonld?sources=SN18700%3A0&referencetime=2021-05-17%2F2021-05-17&elements=air_temperature"


    private var url1_uten_variable_erstatninger = "https://frost.met.no/observations/v0.jsonld?sources=${source}%3A0&referencetime=2021-05-17%2F2021-05-17&elements=air_temperature"



    private var dataSource= DataSource(url_uten_variable_erstatninger)




    private var dataSource2= DataSource(url_med_Polygon)





    private val _responsUIState = MutableStateFlow (ResponsUiState(Svar = null))
    val responsUiState: StateFlow<ResponsUiState> = _responsUIState.asStateFlow()





    private val _responsUIState1 = MutableStateFlow (ResponsUiState_For_SN_Id(Svar = null))
    val responsUiState1: StateFlow<ResponsUiState_For_SN_Id> = _responsUIState1.asStateFlow()




    init {
        loadUsers()
        loadSN_Id()
    }

    private fun loadUsers() {
        viewModelScope.launch (Dispatchers.IO) {
            val innhold = dataSource.fetchApiSvar()
            _responsUIState.value = ResponsUiState( Svar = innhold )
        }
    }



    private fun loadSN_Id() {
        viewModelScope.launch (Dispatchers.IO) {
            val innhold1 = dataSource2.fetchApiSvarkoordinater()
            _responsUIState1.value = ResponsUiState_For_SN_Id(innhold1)
        }
    }





    //Filen: JokeUiState skrives med liten i , og den vi er i nå skrives med stor J
}