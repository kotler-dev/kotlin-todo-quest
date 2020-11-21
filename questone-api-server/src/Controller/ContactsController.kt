package dev.hyperhunt.kotlin.Controller

import io.javalin.Javalin
import io.javalin.http.Context

class ContactsController(app: Javalin) {

    fun get(ctx: Context) {
        ctx.result("Hello")
    }

  /*  app.get("/") { ctx -> ctx.result("Hello") }

    app.get("/contacts") { ctx -> ctx.json(contacts) }

    app.get("/contacts/:id") { ctx ->
        var idx = -1
        try {
            idx = Integer.parseInt(ctx.pathParam("id"))
            if (idx > -1 && idx < contacts.size) {
                ctx.json(contacts[idx])
            } else {
                ctx.result("Index is out boundaries.").status(404)
            }
        } catch (ex: Exception) {
            ctx.result("Invalid input index.").status(404)
        }
    }

    app.post("/contacts/:name/:phone") { ctx ->
//        val name: String
//        val phone: String

        try {
            val name = ctx.pathParam("name")
            val phone = ctx.pathParam("phone")

            if (name.trim().isNotEmpty() && phone.trim().isNotEmpty()) {

                var unique: Boolean = true

                for (item in contacts.indices) {
                    val con = contacts[item]
                    if (name.equals(con.name)) {
                        unique = false
                        break
                    }
                }

                if (unique) {
                    contacts.add(Contact(name, phone))
                    ctx.result("Added data.").status(200)
                } else {
                    ctx.result("Please use unique name.").status(404)
                }

            } else {
                ctx.result("You need to have a value for either the name or the phone.").status(404)
            }

        } catch (ex: Exception) {
            ctx.result("Unknown error when creating phone entry.").status(404)
        }
    }

    app.put("/contacts/:id/:name/:phone") { ctx ->
        try {
            val idx = Integer.parseInt(ctx.pathParam("id"))
            val name = ctx.pathParam("name")
            val phone = ctx.pathParam("phone")

            if (idx > -1 && idx < contacts.size) {
                contacts.add(idx, Contact(name, phone))
                contacts.removeAt(idx + 1)
                ctx.result("Put: Added new contact.")
            } else {
                ctx.result("Put: Invalid ID is out boundaries.").status(404)
            }

        } catch (ex: Exception) {
            ctx.result("Put: Invalid input ID contact.").status(404)
        }
    }

    app.patch("/contacts/:name/:phone") { ctx ->
        try {
            val name = ctx.pathParam("name")
            val phone = ctx.pathParam("phone")

            if (name.trim().isNotEmpty()) {
                for (item in contacts.indices) {
//                    val con = contacts[item]
                    if (name == contacts[item].name) {
                        contacts[item].phone = phone
                        ctx.result("The phone number has been updated.").status(200)
                    } else {
                        ctx.result("Unknown error when updating phone entry.").status(404)
                    }
                }
            } else {
                ctx.result("Empty name.").status(404)
            }
        } catch (ex: Exception) {
            ctx.result("Unknown error when replacing phone entry.").status(404)
        }
    }

    app.patch("/contacts/:id/:name/:phone") { ctx ->
        try {
            val idx = Integer.parseInt(ctx.pathParam("id"))
            val name = ctx.pathParam("name")
            val phone = ctx.pathParam("phone")
            if (idx > -1 && idx < contacts.size) {
                if (name.trim().isNotEmpty()) {
                    contacts[idx].name = name
                    ctx.result("Patch: Name has been changed.").status(200)
                }
                if (phone.trim().isNotEmpty()) {
                    contacts[idx].phone = phone
                    ctx.result("Patch: Phone number has been changed.").status(200)
                }
            } else {
                ctx.result("Patch: ID is out boundaries.").status(404)
            }
        } catch (ex: Exception) {
            ctx.result("Patch: Invalid input ID contact.").status(404)
        }
    }

    app.delete("/contacts/:id") { ctx ->
        try {
            val idx = Integer.parseInt(ctx.pathParam("id"))
//            val name = ctx.pathParam("name")
//            val phone = ctx.pathParam("phone")

            if (idx > -1 && idx < contacts.size) {
                contacts.removeAt(idx)
                ctx.result("Delete: Deleted record with id (${idx}).").status(200)
            } else {
                ctx.result("Delete: Index is out boundaries.").status(404)
            }

        } catch (ex: Exception) {
            ctx.result("Delete: Unknown error when deleting record.").status(404)
        }
    }*/
}