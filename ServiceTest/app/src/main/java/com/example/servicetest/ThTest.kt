package com.example.servicetest

import kotlin.concurrent.thread

fun main() {
//    println(Thread.currentThread().name)
//    Thread{
//        println(Thread.currentThread().name)
//    }.start()

    thread {
        println(Thread.currentThread().name)
    }
}