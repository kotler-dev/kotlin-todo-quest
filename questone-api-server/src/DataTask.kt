import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*

data class DataTask(
    var id: String = UUID.randomUUID().toString(),
    val title: String? = null,
    val isDone: Boolean = false,
    val createdAt: String? = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS")),
) {

    init {
        println("Init data class...")
    }

}

/*data class DataTask(val title: String, val isDone: Boolean) {
    constructor(id: String, title: String, isDone: Boolean): this (title, isDone) {
        id = UUID.randomUUID().toString()
    }
}*/
/*var id: String = UUID.randomUUID().toString(),
val title: String,
val isDone: Boolean,
val createdAt: String? = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS")),
*/
//    val createdAt: String? = date.format(formatter),
//) {
//    val id: String = UUID.randomUUID().toString()
//val id: String = UUID.randomUUID().toString()
/*    constructor(_title: String, _isDone: Boolean) : this(
        title = _title,
        isDone = _isDone,
    )*/
//    constructor(title: String, isDone: Boolean) : this(title = title, isDone = isDone) {}

//    private var date =
//    private val formatter =
//    val createdAt: String? = date.format(formatter)
//}
