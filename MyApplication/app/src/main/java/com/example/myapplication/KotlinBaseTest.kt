package com.example.myapplication

data class CellPhone(val brand: String, val price: String)

fun largerNumber(a: Int, b: Int) = if (a >= b) a else b;

fun getScore(name: String) = when (name) {
    "Michael" -> 99
    "Lebron" -> 95
    "Leon" -> 100
    else -> 60
}

fun checkNum(num: Number) = when (num) {
    is Int -> println("is Int")
    is Double -> println("is double")
    else -> println("nothing")
}

//but I don't think it's a good function
fun getScore2(name: String) = when {
    name == "Tom" -> 99
    name == "Jim" -> 99
    name == "Lisa" -> 99
    else -> "ad"
}

fun getSore3(name: String) = when {
    name.startsWith("Tom") -> 98
    name == "KiKi" -> 99
    else -> 60
}

fun main() {
    val classTest = ClassTest()
    classTest.dosomething2()
}