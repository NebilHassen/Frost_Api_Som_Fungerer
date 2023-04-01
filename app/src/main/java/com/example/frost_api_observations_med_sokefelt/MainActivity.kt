package com.example.frost_api_observations_med_sokefelt

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.frost_api_observations_med_sokefelt.ui.theme.Frost_Api_Observations_Med_SokefeltTheme
import com.example.frost_api_observations_med_sokefelt.ui.theme.VaerSvarScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Frost_Api_Observations_Med_SokefeltTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    VaerSvarScreen()
                }
            }
        }
    }
}

