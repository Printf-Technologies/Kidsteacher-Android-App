package com.printf.kidsteacher.been;

import android.graphics.Bitmap;

public class CommanBeen
{
    private Bitmap image;
    private byte[] music;
    private byte[] infoMusic;

    public CommanBeen(Bitmap image, byte[] music, byte[] infoMusic) {
        this.image = image;
        this.music = music;
        this.infoMusic = infoMusic;
    }

    public Bitmap getImage() {
        return image;
    }

    public void setImage(Bitmap image) {
        this.image = image;
    }

    public byte[] getMusic() {
        return music;
    }

    public void setMusic(byte[] music) {
        this.music = music;
    }

    public byte[] getInfoMusic() {
        return infoMusic;
    }

    public void setInfoMusic(byte[] infoMusic) {
        this.infoMusic = infoMusic;
    }
}
