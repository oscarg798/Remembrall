package com.oscarg798.remembrall.schedule

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.oscarg798.remembrall.schedule.usecase.AreNotificationEnableUseCase
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class BootReceiver : BroadcastReceiver() {

    @Inject
    lateinit var areNotificationEnableUseCase: AreNotificationEnableUseCase

    @Inject
    lateinit var scheduleWorkerScheduler: ScheduleWorkerScheduler

    override fun onReceive(context: Context, intent: Intent?) {

        if (!intent?.action.equals(BootCompleted) || !areNotificationEnableUseCase.execute()) {
            return
        }

        scheduleWorkerScheduler.schedule()
    }
}

private const val BootCompleted = "android.intent.action.BOOT_COMPLETED"
