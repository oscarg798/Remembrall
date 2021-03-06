package com.oscarg798.remembrall.home

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.pager.ExperimentalPagerApi
import com.oscarg798.remembrall.addtask.ui.addTaskScreen
import com.oscarg798.remembrall.checklist_add.ui.addCheckListScreen
import com.oscarg798.remembrall.checklistdetail.ui.checklistDetailScreen
import com.oscarg798.remembrall.common.viewmodel.ViewModelStore
import com.oscarg798.remembrall.edittask.ui.editTaskScreen
import com.oscarg798.remembrall.login.ui.loginScreen
import com.oscarg798.remembrall.profile.ui.profileScreen
import com.oscarg798.remembrall.splash.ui.splashScreen
import com.oscarg798.remembrall.taskdetail.ui.taskDetailsScreen
import com.oscarg798.remembrall.ui_common.navigation.LocalNavControllerProvider
import com.oscarg798.remembrall.ui_common.navigation.Router

@ExperimentalPagerApi
@Composable
fun MainScreen(onFinishRequest: () -> Unit) {
    val navController = rememberNavController()
    val viewModelStore = remember { ViewModelStore() }

    CompositionLocalProvider(LocalNavControllerProvider provides navController) {
        NavHost(navController = navController, startDestination = Router.Splash.route) {
            splashScreen()
            homeScreen() { onFinishRequest() }
            loginScreen(onFinishRequest = onFinishRequest)
            addTaskScreen()
            profileScreen()
            taskDetailsScreen(viewModelStore = viewModelStore)
            editTaskScreen(viewModelStore = viewModelStore)
            addCheckListScreen()
            checklistDetailScreen()
        }
    }
}
