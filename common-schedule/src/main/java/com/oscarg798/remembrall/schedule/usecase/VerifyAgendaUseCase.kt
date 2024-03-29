package com.oscarg798.remembrall.schedule.usecase

import android.util.Log
import com.oscarg798.remembrall.common.provider.StringProvider
import com.oscarg798.remembrall.schedule.R
import com.oscarg798.remembrall.common.R as CommonR
import com.oscarg798.remembrall.schedule.notification.NotificationScheduler
import com.oscarg798.remembrall.task.Task
import com.oscarg798.remembrall.task.TaskPriority
import javax.inject.Inject

class VerifyAgendaUseCase @Inject constructor(
    private val getTodayScheduleUseCase: GetTodayScheduleUseCase,
    private val notificationScheduler: NotificationScheduler,
    private val stringProvider: StringProvider
) {

    suspend fun execute() {
        val tasks = getTodayScheduleUseCase.execute()

        Log.i("Scheduler", "Verifying")
        notificationScheduler.schedule(
            if (tasks.isEmpty()) {
                getSmallNotificationType()
            } else {
                getBigNotificationType(tasks)
            }
        )
    }

    private fun getBigNotificationType(
        tasks:
            Collection<Task>
    ): NotificationScheduler.Type.BigText {
        val taskCountByPriority = getTaskCountByPriorityLabel(tasks)

        return NotificationScheduler.Type.BigText(
            title = stringProvider.get(CommonR.string.big_notification_title),
            content = stringProvider.get(CommonR.string.busy_agenda_notification_content),
            subtext = String.format(
                stringProvider.get(CommonR.string.busy_agenda_notification_subtext),
                tasks.size.toString()
            ),
            subTitle = stringProvider.get(CommonR.string.busy_agenda_notification_subtitle),
            bigText = String.format(
                stringProvider.get(CommonR.string.busy_agenda_notification_big_text),
                taskCountByPriority
            )
        )
    }

    private fun getSmallNotificationType() = NotificationScheduler.Type.Small(
        title = stringProvider.get(CommonR.string.small_notification_title),
        content = stringProvider.get(CommonR.string.free_agenda_notification_content),
        subtext = stringProvider.get(CommonR.string.free_agenda_notification_subtext),
        subTitle = stringProvider.get(CommonR.string.free_agenda_notification_subtitle)
    )

    private fun getTaskCountByPriorityLabel(
        tasks: Collection<Task>
    ): String {
        val urgentTasksCount = tasks.count { it.priority == TaskPriority.Urgent }
        val highTaskCount = tasks.count { it.priority == TaskPriority.High }
        val mediumTaskCount = tasks.count { it.priority == TaskPriority.Medium }
        val lowTaskCount = tasks.count { it.priority == TaskPriority.Low }

        return listOf(
            getTaskCountLabel(TaskPriority.Urgent, urgentTasksCount),
            getTaskCountLabel(TaskPriority.High, highTaskCount),
            getTaskCountLabel(TaskPriority.Medium, mediumTaskCount),
            getTaskCountLabel(TaskPriority.Low, lowTaskCount)
        ).joinToString(TaskCountSeparator)
    }

    private fun getTaskCountLabel(
        priority: TaskPriority,
        taskCount: Int
    ) = if (taskCount != NoTaskByPriorityCount) {
        String.format(
            stringProvider.get(CommonR.string.tasks_by_priority_bullet_point),
            taskCount.toString(),
            stringProvider.get(getPriorityLabel(priority))
        )
    } else {
        String.format(
            stringProvider.get(CommonR.string.no_tasks_by_priority_bullet_point),
            stringProvider.get(getPriorityLabel(priority))
        )
    }

    private fun getPriorityLabel(priority: TaskPriority) = when (priority) {
        TaskPriority.High -> CommonR.string.high_task_priority_label
        TaskPriority.Low -> CommonR.string.low_task_priority_label
        TaskPriority.Medium -> CommonR.string.medium_task_priority_label
        TaskPriority.Urgent -> CommonR.string.urgent_task_priority_label
    }
}

private const val TaskCountSeparator = "\n"
private const val NoTaskByPriorityCount = 0
