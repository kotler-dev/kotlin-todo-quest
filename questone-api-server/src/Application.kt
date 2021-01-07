import io.javalin.Javalin
import io.javalin.http.Context
import io.javalin.http.InternalServerErrorResponse
import io.javalin.http.NotFoundResponse
import java.util.*
import kotlin.collections.ArrayList
import kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType

val task = ArrayList<DataTask>()

fun initTasks() {
    task.add(DataTask(title = "Read about Kotlin", isDone = true))
    task.add(DataTask(title = "Create API server", isDone = false))
    task.add(DataTask(title = "Create UI client", isDone = true))
}

object TaskController {

    /* GET */

    fun getAllTasks(ctx: Context) {
        ctx.json(task)
    }

    fun getIdTask(ctx: Context) {
        var idx = -1
        try {
            idx = Integer.parseInt(ctx.pathParam("id"))
            if (idx > -1 && idx < task.size) {
                ctx.json(task[idx])
            } else {
                ctx.result("Index is out boundaries.").status(404)
            }
        } catch (ex: Exception) {
            ctx.result("Invalid input index.").status(404)
        }
    }

    fun getTaskFilter(ctx: Context) {
        try {
            when (ctx.pathParam("isDone")) {
                "all" -> ctx.json(task).status(200)
                "done" -> ctx.json(task.filter { it.isDone }).status(200)
                "undone" -> ctx.json(task.filter { !it.isDone }).status(200)
                else -> throw Exception("Request parameter filter is not correct. Only one of ['all', 'done', 'undone'] are allowed.")
            }
        } catch (ex: Exception) {
            ctx.result("Get filter: [${ex.message}]").status(400)
        }
    }

    /* POST */

    // Create new task with specified title (Read about Ktor)
    fun postCreateTask(ctx: Context) {
        try {
            val title = ctx.pathParam("title")
            var unique = true
            task.forEach {
                if (it.title == title) {
                    unique = false
                }
            }

            if (title.trim().isNotEmpty() && unique) {
                task.add(DataTask(title = title, isDone = false))
                ctx.result("Post: $title [Task added]").status(200)
            } else {
                ctx.result("Post: Title not unique.").status(400)
            }
        } catch (ex: Exception) {
            ctx.result("Post: ${ex.message}").status(400)
        }
    }

    /* PATCH */

    // /task/{uuid} Change task status: ['all', 'done', 'undone']
    // Mark task as done/undone
    // path "/tasks/:uuid/:isDone"
    fun patchChangeTaskStatus(ctx: Context) {
        try {
            val uuid = ctx.pathParam("uuid")

            task.forEach {
                if (it.id == uuid) {
                    it.isDone = !it.isDone // Mark task as done/undone
                }
            }

            task.find { it.id == uuid }?.let { ctx.json(it) } ?: ctx.result("Patch: Not found task for change status.").status(400)
//            val data = task.find { it.id == uuid } ?: NotFoundResponse()
//            ctx.json(data).status(200)

//            if (uuid.trim().isNotEmpty() && unique) {
//
////                ctx.result("Post: [Id unique]").status(200)
//            } else {
//                ctx.result("Post: Id not unique.").status(400)
//            }


        } catch (ex: Exception) {
            ctx.result("Patch: ${ex.message}").status(400)
        }
    }

}

fun main() {
    val app = Javalin.create().start(7777)

    initTasks()

    app.exception(InternalServerErrorResponse::class.java) { e, ctx ->
        ctx.result("500").status(500)
    }

    app.get("/") { ctx ->
        try {
            ctx.result("Welcome in Todo app.")
        } catch (ex: Exception) {
            ctx.result("Get: Invalid input.").status(400)
        }
    }


    /* GET */

    app.get("/tasks", TaskController::getAllTasks)

    app.get("/tasks/:id", TaskController::getIdTask)

    app.get("/tasks/filter/:isDone", TaskController::getTaskFilter)


    /* POST */

    // Create new task with specified title (Read about Ktor)
    app.post("/tasks/:title", TaskController::postCreateTask)


    /* PATCH */

    // /task/{uuid} Change task status: ['done', 'undone']
    // Mark task as done/undone
    app.patch("/tasks/:uuid", TaskController::patchChangeTaskStatus)

/*


    app.post("/todo/:name/:phone") { ctx ->
//        val name: String
//        val phone: String

        try {
            val name = ctx.pathParam("name")
            val phone = ctx.pathParam("phone")

            if (name.trim().isNotEmpty() && phone.trim().isNotEmpty()) {

                var unique: Boolean = true

                for (item in task.indices) {
                    val con = task[item]
                    if (name.equals(con.name)) {
                        unique = false
                        break
                    }
                }

                if (unique) {
                    task.add(DataTask(name, phone))
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

            if (idx > -1 && idx < task.size) {
                task.add(idx, DataTask(name, phone))
                task.removeAt(idx + 1)
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
                for (item in task.indices) {
//                    val con = todo[item]
                    if (name == task[item].name) {
                        task[item].phone = phone
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
            if (idx > -1 && idx < task.size) {
                if (name.trim().isNotEmpty()) {
                    task[idx].name = name
                    ctx.result("Patch: Name has been changed.").status(200)
                }
                if (phone.trim().isNotEmpty()) {
                    task[idx].phone = phone
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

            if (idx > -1 && idx < task.size) {
                task.removeAt(idx)
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



