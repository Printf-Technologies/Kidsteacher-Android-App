package com.printf.kidsteacher.been.videoData

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

class VideoData : Serializable {
    @SerializedName("Status")
    @Expose
    var status: Boolean? = null

    @SerializedName("Data")
    @Expose
    var data: List<Datum>? = null
}