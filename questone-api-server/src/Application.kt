package dev.hyperhunt.kotlin

import com.eclipsesource.json.Json
import com.eclipsesource.json.JsonObject
import io.ktor.application.call
import io.ktor.http.ContentType
import io.ktor.response.respondText
import io.ktor.routing.get
import io.ktor.routing.routing
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty

fun main() {
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
}

