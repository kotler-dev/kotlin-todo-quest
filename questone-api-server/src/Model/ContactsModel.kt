package dev.hyperhunt.kotlin.Model

data class ContactsModel(var name: String, var phone: String) {

    constructor() {
    }

    private val contacts = ArrayList<ContactsModel>()

    fun getContacts(): ArrayList<ContactsModel> {
        if (contacts == null) {
            initContacts()
        }
        return contacts
    }

    fun initContacts() {
//        contacts.add(Contact("John", "123-45-67"))
//        contacts.add(Contact("Robert", "452-21-27"))
        contacts.add(ContactsModel())
        contacts.add(ContactsModel())
        contacts.add(ContactsModel())
    }


}