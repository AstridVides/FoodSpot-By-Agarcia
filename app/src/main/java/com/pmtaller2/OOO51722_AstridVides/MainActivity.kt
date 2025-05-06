package com.pmtaller2.OOO51722_AstridVides

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.pmtaller2.OOO51722_AstridVides.ui.theme.FoodSpotByAgarciaTheme
import com.pmtaller2.OOO51722_AstridVides.ui.navigation.AppNavigation

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FoodSpotByAgarciaTheme {
                AppNavigation()
            }
        }
    }
}


