package dev.hyperhunt.kotlin

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*

//{
//    id * string($uuid)
//    title * string
//    isDone * boolean
//    createdAt * string($date - time)
//}

class Task(_title: String, _isDone: Boolean) {
    val id: String = UUID.randomUUID().toString()

    var title = _title
        get() = field.capitalize()
        set(value) {
            field = value.trim()
        }

    val isDone = _isDone

    private var date = LocalDateTime.now()
    val createdAt: String? = date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS"))
}

