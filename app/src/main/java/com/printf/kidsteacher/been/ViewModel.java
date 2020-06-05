package com.printf.kidsteacher.been;

/**
 * Created by baps on 01-10-2018.
 */

public class ViewModel {

    private Integer image;
    private Integer background;
    private String name;
    private Integer music;
    private String capital;
    private String small;
    private Integer infoMusic;
    private int nameMusic;
    private String textColor;


    public ViewModel(Integer image, Integer background, String name, Integer music, String textColor) {
        this.image = image;
        this.background = background;
        this.name = name;
        this.music = music;
        this.capital = "";
        this.small = "";
        this.infoMusic = -1;
        this.nameMusic = -1;
        this.textColor = textColor;
    }

    public ViewModel(Integer background, String name, Integer music, String textColor) {
        this.background = background;
        this.name = name;
        this.music = music;
        this.capital = "";
        this.small = "";
        this.infoMusic = -1;
        this.nameMusic = -1;
        this.textColor = textColor;
    }

    public ViewModel(Integer image, String name, Integer music, String capital, String small, Integer infoMusic, int nameMusic) {
        this.image = image;
        this.name = name;
        this.music = music;
        this.capital = capital;
        this.small = small;
        this.infoMusic = infoMusic;
        this.nameMusic = nameMusic;
    }

    public ViewModel(Integer image, Integer background, String name, Integer music, String capital, String small, int infoMusic, String textColor) {
        this.image = image;
        this.background = background;
        this.name = name;
        this.music = music;
        this.capital = capital;
        this.small = small;
        this.infoMusic = infoMusic;
        this.nameMusic = -1;
        this.textColor = textColor;
    }

    public ViewModel(Integer image, Integer background, String name, Integer music, int infoMusic, String textColor) {
        this.image = image;
        this.background = background;
        this.textColor = textColor;
        this.name = name;
        this.music = music;
        this.infoMusic = infoMusic;
    }

    public ViewModel(Integer image, String name, Integer music, int infoMusic) {
        this.image = image;
        this.name = name;
        this.music = music;
        this.capital = "";
        this.small = "";
        this.infoMusic = infoMusic;
        this.nameMusic = -1;
    }

    public Integer getImage() {
        return image;
    }

    public void setImage(Integer image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getMusic() {
        return music;
    }

    public void setMusic(Integer music) {
        this.music = music;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public String getSmall() {
        return small;
    }

    public void setSmall(String small) {
        this.small = small;
    }

    public Integer getInfoMusic() {
        return infoMusic;
    }

    public void setInfoMusic(Integer infoMusic) {
        this.infoMusic = infoMusic;
    }

    public int getNameMusic() {
        return nameMusic;
    }

    public void setNameMusic(int nameMusic) {
        this.nameMusic = nameMusic;
    }

    public Integer getBackground() {
        return background;
    }

    public void setBackground(Integer background) {
        this.background = background;
    }

    public String getTextColor() {
        return textColor;
    }

    public void setTextColor(String textColor) {
        this.textColor = textColor;
    }
}
