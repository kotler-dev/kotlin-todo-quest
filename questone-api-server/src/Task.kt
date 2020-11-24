package dev.hyperhunt.kotlin

import java.util.*

//{
//    id * string($uuid)
//    title * string
//    isDone * boolean
//    createdAt * string($date - time)
//}

class Task(_id: String, _title: String/*, _isDone: String, _createdAt: String*/) {

    var id: String = _id

    var title = _title
        get() = field.capitalize()
        set(value) {
            field = value.trim()
        }

//    var isDone = _isDone
//        set(value) {
//            field = value.trim()
//        }
//
//    val createdAt = _createdAt
}

