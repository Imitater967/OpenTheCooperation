package git.imitater967.otc

import Greeting
import SERVER_PORT
import git.imitater967.otc.accounting.accountingRoute
import io.ktor.resources.Resource
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.server.resources.Resources
import io.ktor.server.response.*
import io.ktor.server.routing.*


fun main() {

    embeddedServer(Netty, port = SERVER_PORT, host = "0.0.0.0", module = Application::module).start(wait = true)

}

fun Application.module() {
    install(Resources)
    routing {
        accountingRoute()
        get("/") {
            call.respondText("Ktor: ${Greeting().greet()}")
        }
    }
}