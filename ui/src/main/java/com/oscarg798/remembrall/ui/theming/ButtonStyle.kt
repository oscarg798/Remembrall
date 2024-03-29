package com.oscarg798.remembrall.ui.theming

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import com.oscarg798.remembrall.ui.dimensions.dimensions

@Composable
fun getButtonShape() = RoundedCornerShape(MaterialTheme.dimensions.Medium)

@Composable
fun getButtonTextStyle() = MaterialTheme.typography.bodyMedium.merge(
    TextStyle(
        color = MaterialTheme.colorScheme.onSecondary,
        fontWeight = FontWeight.Bold
    )
)
