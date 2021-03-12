package com.printf.kidsteacher.been

/**
 * Created by baps on 01-10-2018.
 */
class ViewModel {
    var image: Int? = null
    var background: Int? = null
    var name: String
    var music: Int
    var capital: String? = null
    var small: String? = null
    var infoMusic: Int
    var nameMusic = 0
    var textColor: String? = null

    constructor(image: Int?, background: Int?, name: String, music: Int, textColor: String?) {
        this.image = image
        this.background = background
        this.name = name
        this.music = music
        capital = ""
        small = ""
        infoMusic = -1
        nameMusic = -1
        this.textColor = textColor
    }

    constructor(background: Int?, name: String, music: Int, textColor: String?) {
        this.background = background
        this.name = name
        this.music = music
        capital = ""
        small = ""
        infoMusic = -1
        nameMusic = -1
        this.textColor = textColor
    }

    constructor(image: Int?, name: String, music: Int, capital: String?, small: String?, infoMusic: Int, nameMusic: Int) {
        this.image = image
        this.name = name
        this.music = music
        this.capital = capital
        this.small = small
        this.infoMusic = infoMusic
        this.nameMusic = nameMusic
    }

    constructor(image: Int?, background: Int?, name: String, music: Int, capital: String?, small: String?, infoMusic: Int, textColor: String?) {
        this.image = image
        this.background = background
        this.name = name
        this.music = music
        this.capital = capital
        this.small = small
        this.infoMusic = infoMusic
        nameMusic = -1
        this.textColor = textColor
    }

    constructor(image: Int?, background: Int?, name: String, music: Int, infoMusic: Int, textColor: String?) {
        this.image = image
        this.background = background
        this.textColor = textColor
        this.name = name
        this.music = music
        this.infoMusic = infoMusic
    }

    constructor(image: Int?, name: String, music: Int, infoMusic: Int) {
        this.image = image
        this.name = name
        this.music = music
        capital = ""
        small = ""
        this.infoMusic = infoMusic
        nameMusic = -1
    }
}