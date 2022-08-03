package com.example.myapplication

import java.lang.StringBuilder

fun main(){
    val list = listOf<String>("Apple", "Banana","Pear", "Grape")
    val result = with(StringBuilder()){
        append("Start eating fruit").append("\n")
        for (fruit in list){
            append(fruit).append("\n")
        }
        append("Ate all fruit")
        toString()
    }
    print(result)
}