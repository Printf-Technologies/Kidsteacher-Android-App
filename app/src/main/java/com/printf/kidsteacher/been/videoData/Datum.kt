package com.printf.kidsteacher.been.videoData

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

class Datum : Serializable {
    @SerializedName("VideoName")
    @Expose
    var videoName: String? = null

    @SerializedName("ThumbnailUrl")
    @Expose
    var thumbnailUrl: String? = null

    @SerializedName("VideoUrl")
    @Expose
    var videoUrl: String? = null
}