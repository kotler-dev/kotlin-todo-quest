package dev.hyperhunt.kotlin

//import com.eclipsesource.json.Json
//import dev.hyperhunt.kotlin.Model.Recording
import io.javalin.Javalin
import kotlinx.coroutines.*
import java.util.*

suspend fun main() {
    val app = Javalin.create().start(7777)

    val task = ArrayList<Task>()

    suspend fun initTasks() {
//        task.add(Task(UUID.randomUUID().toString(), "title1"))
//        task.add(Task(UUID.randomUUID().toString(), "title2"))
//        task.add(Task(UUID.randomUUID().toString(), "title3"))

        task.add(Task("title1", false))
        delay(2000L)
        task.add(Task("title2", false))
        delay(2000L)
        task.add(Task("title3", true))
    }
    initTasks()

    app.get("/") { ctx ->
        try {
            ctx.json(task)
        } catch (ex: Exception) {
            ctx.result("Get: Invalid input.").status(404)
        }
    }

//    val contact = RecordingsModel().getRecordings()
//    val todo = Recording()

    /*
    val todo = ArrayList<Recording>()

//    private val todo = ArrayList<Recording>()

    fun initRecordings() {
//        todo.add(Recording("John", "123-45-67"))
//        todo.add(Recording("Robert", "452-21-27"))
        todo.add(Recording("Tony", "151-67-23"))
        todo.add(Recording("Jully", "126-27-41"))
        todo.add(Recording("Harper", "133-57-75"))
    }

    fun getRecordings(): ArrayList<Recording> {
        if (todo == null) initRecordings()
        return todo
    }

    initRecordings()

    app.get("/") { ctx -> ctx.result("Hello") }

    app.get("/todo") { ctx -> ctx.json(todo) }

    app.get("/todo/:id") { ctx ->
        var idx = -1
        try {
            idx = Integer.parseInt(ctx.pathParam("id"))
            if (idx > -1 && idx < todo.size) {
                ctx.json(todo[idx])
            } else {
                ctx.result("Index is out boundaries.").status(404)
            }
        } catch (ex: Exception) {
            ctx.result("Invalid input index.").status(404)
        }
    }

    app.get("/todo/:name/:phone") { ctx ->
        try {
            val name = ctx.pathParam("name")
            val phone = ctx.pathParam("phone")

            if (name.isNotEmpty()) {
                for (item in todo.indices) {
                    if (name.equals(todo[item].name)) {
                        ctx.json(todo[item]).status(200)
                    } else {
                        ctx.result("Get: The record (${name}) is missing from the database.").status(404)
                    }
                }
            } else {
                ctx.result("Get: Empty name.").status(404)
            }
        } catch (ex: Exception) {
            ctx.result("Get: Invalid inpit.").status(404)
        }
    }

    app.post("/todo/:name/:phone") { ctx ->
//        val name: String
//        val phone: String

        try {
            val name = ctx.pathParam("name")
            val phone = ctx.pathParam("phone")

            if (name.trim().isNotEmpty() && phone.trim().isNotEmpty()) {

                var unique: Boolean = true

                for (item in todo.indices) {
                    val con = todo[item]
                    if (name.equals(con.name)) {
                        unique = false
                        break
                    }
                }

                if (unique) {
                    todo.add(Recording(name, phone))
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

    app.put("/todo/:id/:name/:phone") { ctx ->
        try {
            val idx = Integer.parseInt(ctx.pathParam("id"))
            val name = ctx.pathParam("name")
            val phone = ctx.pathParam("phone")

            if (idx > -1 && idx < todo.size) {
                todo.add(idx, Recording(name, phone))
                todo.removeAt(idx + 1)
                ctx.result("Put: Added new contact.")
            } else {
                ctx.result("Put: Invalid ID is out boundaries.").status(404)
            }

        } catch (ex: Exception) {
            ctx.result("Put: Invalid input ID contact.").status(404)
        }
    }

    app.patch("/todo/:name/:phone") { ctx ->
        try {
            val name = ctx.pathParam("name")
            val phone = ctx.pathParam("phone")

            if (name.trim().isNotEmpty()) {
                for (item in todo.indices) {
//                    val con = todo[item]
                    if (name == todo[item].name) {
                        todo[item].phone = phone
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

    app.patch("/todo/:id/:name/:phone") { ctx ->
        try {
            val idx = Integer.parseInt(ctx.pathParam("id"))
            val name = ctx.pathParam("name")
            val phone = ctx.pathParam("phone")
            if (idx > -1 && idx < todo.size) {
                if (name.trim().isNotEmpty()) {
                    todo[idx].name = name
                    ctx.result("Patch: Name has been changed.").status(200)
                }
                if (phone.trim().isNotEmpty()) {
                    todo[idx].phone = phone
                    ctx.result("Patch: Phone number has been changed.").status(200)
                }
            } else {
                ctx.result("Patch: ID is out boundaries.").status(404)
            }
        } catch (ex: Exception) {
            ctx.result("Patch: Invalid input ID contact.").status(404)
        }
    }

    app.delete("/todo/:id") { ctx ->
        try {
            val idx = Integer.parseInt(ctx.pathParam("id"))
//            val name = ctx.pathParam("name")
//            val phone = ctx.pathParam("phone")

            if (idx > -1 && idx < todo.size) {
                todo.removeAt(idx)
                ctx.result("Delete: Deleted record with id (${idx}).").status(200)
            } else {
                ctx.result("Delete: Index is out boundaries.").status(404)
            }

        } catch (ex: Exception) {
            ctx.result("Delete: Unknown error when deleting record.").status(404)
        }
    }
    */
}



