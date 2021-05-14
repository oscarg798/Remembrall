package com.oscarg798.remembrall.profile.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.unit.dp
import com.oscarg798.remembrall.common.ui.Shimmer
import com.oscarg798.remembrall.common.ui.theming.Dimensions

@Composable
internal fun LoadingProfile() {

    LoadingItem(UserNameId)

    Column(
        Modifier
            .padding(horizontal = Dimensions.Spacing.Medium)
            .layoutId(CalendarSelectorId)
    ) {
        LoadingItem(UserNameId)

        Card(
            modifier = Modifier.padding(
                vertical = Dimensions.Spacing.Small
            ),
            shape = RoundedCornerShape(Dimensions.CornerRadius.Small)
        ) {
            LazyColumn {
                items(listOf(1, 2, 3)) {
                    Shimmer(
                        Modifier.layoutId(UserNameId)
                            .fillMaxWidth()
                            .height(LoadingTextHeight)
                    )
                }
            }
        }
    }

    LoadingItem(NotificationCardId)
    LoadingItem(LogOutButtonId)
}

@Composable
private fun LoadingItem(layoutId: String) = Shimmer(
    Modifier
        .padding(Dimensions.Spacing.Medium)
        .layoutId(layoutId)
        .fillMaxWidth()
        .height(LoadingTextHeight)
)

private val LoadingTextHeight = 50.dp