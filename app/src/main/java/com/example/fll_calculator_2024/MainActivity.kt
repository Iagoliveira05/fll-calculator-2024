package com.example.fll_calculator_2024

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModelProvider
import com.example.fll_calculator_2024.ui.theme.FLLCalculator2024Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel = ViewModelProvider(this)[MissionViewModel::class.java]
        enableEdgeToEdge()
        setContent {
            FLLCalculator2024Theme {
                Scaffold(
                    containerColor = Color(0xFF7FE5F7),
                ) { innerPadding ->
                    CalculatorPage(modifier = Modifier.padding(innerPadding), viewModel = viewModel)
                }
            }
        }
    }
}
