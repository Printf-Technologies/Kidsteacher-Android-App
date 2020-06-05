package com.printf.kidsteacher.been.aphabet;

import android.graphics.Bitmap;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.crypto.SecretKey;

public class Datum {

@SerializedName("ShortSound")
@Expose
private String shortSound;
@SerializedName("LongSound")
@Expose
private String longSound;
@SerializedName("ReadImage")
@Expose
private String readImage;
@SerializedName("WriteImage")
@Expose
private String writeImage;
@SerializedName("UpdatedDate")
@Expose
private String updatedDate;


    @SerializedName("ContentId")
    @Expose
    private int ContentId;
    @SerializedName("ShortSoundUpdatedDate")
    @Expose
    private String ShortSoundUpdatedDate;
    @SerializedName("LongSoundUpdatedDate")
    @Expose
    private String LongSoundUpdatedDate;
    @SerializedName("ReadImageUpdatedDate")
    @Expose
    private String ReadImageUpdatedDate;
    @SerializedName("WriteImageUpdatedDate")
    @Expose
    private String WriteImageUpdatedDate;

    SecretKey readKey;
    SecretKey writeKey;

private Bitmap imgeRead;
private Bitmap imgeWrite;
    private byte[] rawShort;
    private byte[] rawLong;

    public SecretKey getReadKey() {
        return readKey;
    }

    public void setReadKey(SecretKey readKey) {
        this.readKey = readKey;
    }

    public SecretKey getWriteKey() {
        return writeKey;
    }

    public void setWriteKey(SecretKey writeKey) {
        this.writeKey = writeKey;
    }

    public Bitmap getImgeRead() {
        return imgeRead;
    }

    public void setImgeRead(Bitmap imgeRead) {
        this.imgeRead = imgeRead;
    }

    public Bitmap getImgeWrite() {
        return imgeWrite;
    }

    public void setImgeWrite(Bitmap imgeWrite) {
        this.imgeWrite = imgeWrite;
    }

    public byte[] getRawShort() {
        return rawShort;
    }

    public void setRawShort(byte[] rawShort) {
        this.rawShort = rawShort;
    }

    public byte[] getRawLong() {
        return rawLong;
    }

    public void setRawLong(byte[] rawLong) {
        this.rawLong = rawLong;
    }

    public String getShortSound() {
return shortSound;
}

public void setShortSound(String shortSound) {
this.shortSound = shortSound;
}

public String getLongSound() {
return longSound;
}

public void setLongSound(String longSound) {
this.longSound = longSound;
}

public String getReadImage() {
return readImage;
}

public void setReadImage(String readImage) {
this.readImage = readImage;
}

public String getWriteImage() {
return writeImage;
}

public void setWriteImage(String writeImage) {
this.writeImage = writeImage;
}

public String getUpdatedDate() {
return updatedDate;
}

public void setUpdatedDate(String updatedDate) {
this.updatedDate = updatedDate;
}

    public int getContentId() {
        return ContentId;
    }

    public void setContentId(int contentId) {
        ContentId = contentId;
    }

    public String getShortSoundUpdatedDate() {
        return ShortSoundUpdatedDate;
    }

    public void setShortSoundUpdatedDate(String shortSoundUpdatedDate) {
        ShortSoundUpdatedDate = shortSoundUpdatedDate;
    }

    public String getLongSoundUpdatedDate() {
        return LongSoundUpdatedDate;
    }

    public void setLongSoundUpdatedDate(String longSoundUpdatedDate) {
        LongSoundUpdatedDate = longSoundUpdatedDate;
    }

    public String getReadImageUpdatedDate() {
        return ReadImageUpdatedDate;
    }

    public void setReadImageUpdatedDate(String readImageUpdatedDate) {
        ReadImageUpdatedDate = readImageUpdatedDate;
    }

    public String getWriteImageUpdatedDate() {
        return WriteImageUpdatedDate;
    }

    public void setWriteImageUpdatedDate(String writeImageUpdatedDate) {
        WriteImageUpdatedDate = writeImageUpdatedDate;
    }
}
