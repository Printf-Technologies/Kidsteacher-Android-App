package com.printf.kidsteacher.been

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class AppSettingModel {
    @SerializedName("Status")
    @Expose
    var status: Boolean? = false

    @SerializedName("HttpStatus")
    @Expose
    var httpStatus: Int? = 0

    @SerializedName("Data")
    @Expose
    var data: Data? = null

    @SerializedName("Message")
    @Expose
    var Message: String? = ""

    class Data {
        @SerializedName("AdSettings")
        @Expose
        var adSettings: ArrayList<AdSettings>? = null

        @SerializedName("ShowBannerAd")
        @Expose
        var showBannerAd: Int? = 0

        @SerializedName("GeoLocation")
        @Expose
        var geoLocation: String? = ""

        @SerializedName("MinVersion")
        @Expose
        var minVersion: String? = ""

        @SerializedName("CurrerntVersion")
        @Expose
        var currerntVersion: String? = ""

    }

    class AdSettings {
        @SerializedName("Id")
        @Expose
        var id: Int? = 0

        @SerializedName("ScreenName")
        @Expose
        var screenName: String? = ""

        @SerializedName("Action")
        @Expose
        var action: String? = ""

        @SerializedName("VideoAd")
        @Expose
        var videoAd: Boolean? = false

        @SerializedName("InterAd")
        @Expose
        var interAd: Boolean? = false
    }

}