package com.printf.kidsteacher.splash

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.printf.kidsteacher.api.ProjectRepository
import com.printf.kidsteacher.been.AppSettingModel


class SplashViewModel(application: Application) : AndroidViewModel(application) {

    var errorObservable = MutableLiveData<String>()
    val isLoading = MutableLiveData<Boolean>()
    var dataObservable = MutableLiveData<AppSettingModel>()


    fun getAppAdSettings() {
        ProjectRepository.getInstance(getApplication()).getAppAdSettings(dataObservable, errorObservable, isLoading)
    }

}