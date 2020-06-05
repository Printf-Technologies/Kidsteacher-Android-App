package com.printf.kidsteacher.been;

public class WriteBeen
{
    String name;
    int img;

    public WriteBeen(String name, int img) {
        this.name = name;
        this.img = img;
    }

    public WriteBeen(int img,String name) {
        this.name = name;
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }
}
