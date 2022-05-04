package com.example.lesson8task2kotlin.Model

class User (var name: String, var age: Int){
     fun User( name: String, age: Int){
        this.name = name
        this.age = age
    }

    override fun toString(): String {
        return "User(name='$name', age=$age)"
    }
}