package com.oscarg798.remembrall.common_calendar.domain.model

data class Calendar(
    val id: String,
    val name: String,
    val isPrimary: Boolean = false
)
