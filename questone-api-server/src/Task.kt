package dev.hyperhunt.kotlin

import io.netty.handler.codec.http.HttpHeaders.getDate
import java.time.Instant.now
import java.time.LocalDate
import java.time.LocalDateTime
import java.util.*

//{
//    id * string($uuid)
//    title * string
//    isDone * boolean
//    createdAt * string($date - time)
//}

class Task(_title: String, _isDone: Boolean) {

    //    var id: String = _id
    val id: String = UUID.randomUUID().toString()

    var title = _title
        get() = field.capitalize()
        set(value) {
            field = value.trim()
        }

//    fun generateUUID (): String {
//        return UUID.randomUUID().toString()
//    }

    val isDone = _isDone

    private var date = LocalDateTime.now()
    val createdAt = date.toString()
}

