package dev.hyperhunt.kotlin

class Contact(_name: String, _phone: String) {
    var name = _name
        get() = field.capitalize()
        set(value) {
            field = value.trim()
        }
    var phone = _phone
        get() = field.capitalize()
        set(value) {
            field = value.trim()
        }
}
