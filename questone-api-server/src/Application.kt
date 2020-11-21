package dev.hyperhunt.kotlin

//import com.eclipsesource.json.Json
import dev.hyperhunt.kotlin.Model.ContactsModel
import io.javalin.Javalin

fun main() {
    val app = Javalin.create().start(7777)
    val contact = ContactsModel().getContacts()
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

