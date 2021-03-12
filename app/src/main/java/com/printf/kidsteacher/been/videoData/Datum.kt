package com.printf.kidsteacher.been.videoData;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class Datum implements Serializable {

@SerializedName("VideoName")
@Expose
private String videoName;
@SerializedName("ThumbnailUrl")
@Expose
private String thumbnailUrl;
@SerializedName("VideoUrl")
@Expose
private String videoUrl;

public String getVideoName() {
return videoName;
}

public void setVideoName(String videoName) {
this.videoName = videoName;
}

public String getThumbnailUrl() {
return thumbnailUrl;
}

public void setThumbnailUrl(String thumbnailUrl) {
this.thumbnailUrl = thumbnailUrl;
}

public String getVideoUrl() {
return videoUrl;
}

public void setVideoUrl(String videoUrl) {
this.videoUrl = videoUrl;
}

}
