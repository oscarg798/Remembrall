package com.oscarg798.remembrall.common.model

data class Task(
    val id: String,
    val owner: String,
    val owned: Boolean,
    val name: String,
    val priority: TaskPriority,
    val calendarSyncInformation: CalendarSyncInformation,
    val dueDate: Long,
    val completed: Boolean = false,
    val description: String?
)
