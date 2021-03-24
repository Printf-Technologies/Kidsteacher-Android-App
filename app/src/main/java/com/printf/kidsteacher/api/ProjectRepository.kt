package com.printf.kidsteacher.api

import android.content.Context
import androidx.lifecycle.MutableLiveData
import com.printf.kidsteacher.been.AppSettingModel
import com.printf.kidsteacher.been.videoData.VideoData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProjectRepository(var context : Context) {
    private var apiInterface: ApiInterface = ApiClient.instance(context).apiInterface

    companion object {
        private var sInstance: ProjectRepository? = null

        @Synchronized
        fun getInstance(context : Context): ProjectRepository {
            if (sInstance == null) {
                if (sInstance == null) {
                    sInstance = ProjectRepository(context)
                }
            }
            return sInstance!!
        }
    }



    fun getVideo(data: MutableLiveData<VideoData>, error: MutableLiveData<String>, isLoading: MutableLiveData<Boolean>) {
        isLoading.value = true
        apiInterface.getVideos().enqueue(object : Callback<VideoData> {
            override fun onResponse(
                    call: Call<VideoData>,
                    response: Response<VideoData>
            ) {
                if (response.isSuccessful) {
                    data.value = response.body()
                } else {
                    error.value = "Something is wrong.."
                }
                isLoading.value = false
            }

            override fun onFailure(call: Call<VideoData>, t: Throwable) {
                isLoading.value = false
                error.value = "Something is wrong.."
            }
        })
    }

    fun getAppAdSettings(data: MutableLiveData<AppSettingModel>, error: MutableLiveData<String>, isLoading: MutableLiveData<Boolean>) {
        isLoading.value = true
        apiInterface.getAppSettings().enqueue(object : Callback<AppSettingModel> {
            override fun onResponse(
                    call: Call<AppSettingModel>,
                    response: Response<AppSettingModel>
            ) {
                if (response.isSuccessful) {
                    data.value = response.body()
                } else {
                    error.value = "Something is wrong.."
                }
                isLoading.value = false
            }

            override fun onFailure(call: Call<AppSettingModel>, t: Throwable) {
                isLoading.value = false
                error.value = "Something is wrong.."
            }
        })
    }


}