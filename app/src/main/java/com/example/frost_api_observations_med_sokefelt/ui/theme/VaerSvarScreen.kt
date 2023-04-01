package com.example.frost_api_observations_med_sokefelt.ui.theme

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*

import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.frost_api_observations_med_sokefelt.Frost_API_Respons
import com.example.frost_api_observations_med_sokefelt.data.Frost_API_Respons_for_koordinater

@OptIn(ExperimentalMaterial3Api::class)
@Composable

fun VaerSvarScreen (responseViewModel: ResponseViewModel = viewModel()){


    val UIState by responseViewModel.responsUiState.collectAsState()

    val UIState_SN by responseViewModel.responsUiState1.collectAsState()


    //val myViewModel: ResponseViewModel = viewModel(factory = MyViewModelFactory())
    var text by remember  {mutableStateOf(value=("")) }
    var focusClear = LocalFocusManager.current


    Column (modifier= Modifier
        .fillMaxHeight()
        .wrapContentHeight(Alignment.CenterVertically)) {

        var isClicked by remember {mutableStateOf(false) }


        Text (modifier=Modifier.fillMaxWidth().wrapContentWidth(Alignment.CenterHorizontally),text="Svaret på forespørselen kommer som et card under søkefeltet")



        OutlinedTextField(modifier=Modifier.fillMaxWidth().wrapContentWidth(Alignment.CenterHorizontally),
            value = text,
            onValueChange = { text = it},
            label = { Text("Skriv sted/by: ")}
        )


        Button(modifier = Modifier
            .fillMaxWidth()
            .wrapContentWidth(Alignment.CenterHorizontally),
            onClick = {

                responseViewModel.settSource(text) // Angir SN sensor (lokalisasjon til et api kall)
                isClicked= true
                Log.d("tekst", text)

                text= "" // gjør søkefeltet hvit
                focusClear.clearFocus() // får tastatur fjernet når man trykker på enter
            }
        ){
            Text (modifier=Modifier.fillMaxWidth().wrapContentWidth(Alignment.CenterHorizontally),text="Trykk for å få værmeldingen")

        }

        Text (modifier=Modifier.fillMaxWidth().wrapContentWidth(Alignment.CenterHorizontally),text="Dato er hardkodet til:")
        Text (modifier=Modifier.fillMaxWidth().wrapContentWidth(Alignment.CenterHorizontally),text="17.05.2021")


        if (isClicked== true) {

            var etUiState_MedRespons = UIState.Svar
            var etUiState_MedRespons_Source = UIState_SN.Svar




            if (etUiState_MedRespons_Source != null) { // Gammel betingelse: (etUiState_MedRespons != null && etUiState_MedRespons_Source != null)
                VarResponsCardy(Respons2 = etUiState_MedRespons_Source)
                Log.d("SN_Source",etUiState_MedRespons_Source.toString() )
            }


            if (etUiState_MedRespons != null) { // Gammel betingelse: (etUiState_MedRespons != null && etUiState_MedRespons_Source != null)
                VarResponsCard(Respons = etUiState_MedRespons)
                //VarResponsCardy(Respons = etUiState_MedRespons_Source)
                Log.d("Temp",etUiState_MedRespons.toString() )
            }


        }

    }
}
@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun VarResponsCard (Respons: Frost_API_Respons) {

    Card (modifier = Modifier
        .fillMaxWidth()
        .padding(16.dp)) {
        Text(Respons.data.get(0).observations.get(0).value.toString(), modifier = Modifier.padding (16.dp)) // velg først:data.get(0) fordi data bare har 1 eleemnt i data:  kl.1200. OGså .observations.size.toString(), F

    }
}


// denne tar inn et koordinat, og utgir værhorholdene i området
@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun VarResponsCardy (Respons2: Frost_API_Respons_for_koordinater) {

    Card (modifier = Modifier
        .fillMaxWidth()
        .padding(16.dp)) {
        Text(text="Sted: "+Respons2.data_for_koordinater.get(0).name.toString() +"\nStasjonsid: "+ Respons2.data_for_koordinater.get(0).id.toString()+ "\nKoordinat til stasjon: "+Respons2.data_for_koordinater.get(0).geometry?.coordinates.toString()  , modifier = Modifier.padding (16.dp)) // velg først:data.get(0) fordi data bare har 1 eleemnt i data:  kl.1200. OGså .observations.size.toString(), F

    }
}