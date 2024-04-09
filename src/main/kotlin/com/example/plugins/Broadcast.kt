package com.example.plugins

import org.jetbrains.kotlinx.spark.api.broadcast
import org.jetbrains.kotlinx.spark.api.map
import org.jetbrains.kotlinx.spark.api.withSpark
import java.io.Serializable

// From kotlin-spark-api examples

object Broadcast {
    data class SomeClass(val a: IntArray, val b: Int) : Serializable

    fun broadcast(): MutableList<Int> {
        lateinit var result: MutableList<Int>
        withSpark(master = "local") {
            val broadcastVariable = spark.broadcast(SomeClass(a = intArrayOf(5, 6), b = 3))
            result = listOf(1, 2, 3, 4, 5)
                .toDS()
                .map {
                    val receivedBroadcast = broadcastVariable.value
                    it + receivedBroadcast.a.first()
                }
                .collectAsList()
            println(result)
        }
        return result
    }
}