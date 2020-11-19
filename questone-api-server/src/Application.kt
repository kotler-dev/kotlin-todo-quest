package dev.hyperhunt.kotlin

//import com.eclipsesource.json.Json
import com.eclipsesource.json.Json
import com.eclipsesource.json.JsonObject
import io.ktor.application.call
import io.ktor.http.ContentType
import io.ktor.response.respondText
import io.ktor.routing.get
import io.ktor.routing.routing
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty
import io.javalin.Javalin

import kotlinx.serialization.*
import kotlinx.serialization.json.*

fun main() {

    val contacts = ArrayList<Contact>()
    fun initContacts() {
//        contacts.add(Contact("John", "123-45-67"))
//        contacts.add(Contact("Robert", "452-21-27"))
        contacts.add(Contact("Tony", "151-67-23"))
        contacts.add(Contact("Jully", "126-27-41"))
        contacts.add(Contact("Harper", "133-57-75"))
    }

    initContacts()

    val app = Javalin.create().start(7777)
    app.get("/") { ctx -> ctx.result("Hello") }

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
                    ctx.result("Added data.").status(202)
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

}

/*
fun main(args: Array<String>) {
val app = Javalin.create().start(7777)
app.get("/") {ctx -> ctx.result("Hello Javalin!")}
}
*/

/*fun main() {
    val server = embeddedServer(Netty, port = 8082) {
        routing {
            get("/") {
                val user: JsonObject = Json.`object`().add("name", "Tony").add("points", 42)
                call.respondText("$user", ContentType.Text.Plain)
            }
            get("/demo") {
                call.respondText("HELLO WORLD!")
            }
        }
    }
    server.start(wait = true)
}*/

