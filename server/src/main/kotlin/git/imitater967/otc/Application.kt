package git.imitater967.otc

import Greeting
import SERVER_PORT
import git.imitater967.otc.accounting.accountingModule
import git.imitater967.otc.accounting.registerAccountingRoute
import git.imitater967.otc.common.commonModule
import git.imitater967.otc.database.DatabaseManager
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.server.resources.Resources
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.core.context.startKoin
import org.koin.ktor.ext.inject
import org.koin.ktor.plugin.Koin
import org.koin.logger.slf4jLogger


fun main() {

    embeddedServer(Netty, port = SERVER_PORT, host = "0.0.0.0", module = Application::module).start(wait = true)

}
fun Application.module() {
    install(Resources)
    // Install Koin
    install(Koin){
        slf4jLogger()
        allowOverride(false)
        modules(
            accountingModule,
            commonModule,
        )
    }
    routing {
        get("/") {
        }
        registerAccountingRoute()
    }
}