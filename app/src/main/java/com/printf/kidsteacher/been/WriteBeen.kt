package com.printf.kidsteacher.been

class WriteBeen {
    var name: String
    var img: Int

    constructor(name: String, img: Int) {
        this.name = name
        this.img = img
    }

    constructor(img: Int, name: String) {
        this.name = name
        this.img = img
    }
}