package git.imitater967.otc

import Greeting
import SERVER_PORT
import git.imitater967.otc.accounting.registerAccountingModule
import git.imitater967.otc.accounting.registerAccountingRoute
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.server.resources.Resources
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.ktor.plugin.Koin


fun main() {

    embeddedServer(Netty, port = SERVER_PORT, host = "0.0.0.0", module = Application::module).start(wait = true)

}
fun Application.module() {
    install(Resources)
    // Install Koin
    install(Koin) {
        allowOverride(false)
        registerAccountingModule();
    }

    routing {
        registerAccountingRoute()
        get("/") {
            call.respondText("Ktor: ${Greeting().greet()}")
        }
    }
}