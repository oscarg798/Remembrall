package com.oscarg798.remembrall.ui

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.oscarg798.remembrall.ui.dimensions.dimensions
import com.oscarg798.remembrall.ui.theming.getButtonShape
import com.oscarg798.remembrall.ui.theming.getButtonTextStyle

@Composable
fun RemembrallButton(
    text: String,
    modifier: Modifier = Modifier,
    loading: Boolean = false,
    onButtonClick: () -> Unit
) {
    Button(
        onClick = {
            onButtonClick()
        },
        enabled = !loading,
        modifier = modifier
            .fillMaxWidth()
            .padding(MaterialTheme.dimensions.Medium),
        shape = getButtonShape(),
        colors = ButtonDefaults.buttonColors(
            disabledContainerColor = MaterialTheme.colorScheme.secondaryContainer,
            disabledContentColor = MaterialTheme.colorScheme.secondaryContainer
        )
    ) {
        if (loading) {
            CircularProgressIndicator(color = MaterialTheme.colorScheme.onBackground)
        } else {
            Text(
                text,
                style = getButtonTextStyle()
            )
        }
    }
}
