package com.oscarg798.remembrall.common.viewmodel

import androidx.lifecycle.ViewModel
import java.util.HashMap

class ViewModelStore {
    private val cachedViewModels = HashMap<String, ViewModel>()

    fun <T : ViewModel> get(key: String, create: () -> T) =
        cachedViewModels[key] ?: create.invoke().also {
            cachedViewModels[key] = it
        }
}

fun <T : ViewModel> ViewModelStore.viewModel(
    key: String,
    create: () -> T,
): T = get(key, create) as T
