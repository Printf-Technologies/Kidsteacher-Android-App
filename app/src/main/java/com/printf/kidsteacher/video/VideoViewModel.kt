package com.printf.kidsteacher.video

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.printf.kidsteacher.api.ProjectRepository
import com.printf.kidsteacher.been.AppSettingModel
import com.printf.kidsteacher.been.videoData.VideoData


class VideoViewModel(application: Application) : AndroidViewModel(application) {

    var errorObservable = MutableLiveData<String>()
    val isLoading = MutableLiveData<Boolean>()
    var dataObservable = MutableLiveData<VideoData>()


    fun getVideo() {
        ProjectRepository.getInstance(getApplication()).getVideo(dataObservable, errorObservable, isLoading)
    }

}