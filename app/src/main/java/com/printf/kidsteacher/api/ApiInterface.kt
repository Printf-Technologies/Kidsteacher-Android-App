package com.printf.kidsteacher.api


import com.printf.kidsteacher.been.AppSettingModel
import com.printf.kidsteacher.been.videoData.VideoData
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {

    @GET("api/video/GetVideos")
    fun getVideos(): Call<VideoData>

    @GET("api/Settings/GetAppSettings")
    fun getAppSettings(): Call<AppSettingModel>
}