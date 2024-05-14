package com.example.firebasestorage.models

class Book {
    var name:String = ""
    var genre:String = ""
    var price:String = ""
    var imageUrl:String = ""
    var id:String = ""

    constructor(name: String, quantity: String, price: String, imageUrl: String, id: String) {
        this.name = name
        this.genre = quantity
        this.price = price
        this.imageUrl = imageUrl
        this.id = id
    }

    constructor()
}