package git.imitater967.otc.accounting

import git.imitater967.otc.accounting.so.AccountingService
import git.imitater967.otc.database.DatabaseManager
import git.imitater967.otc.database.DatabaseManagerImpl
import io.ktor.server.application.call
import io.ktor.server.response.respondText
import io.ktor.server.routing.Route
import io.ktor.server.routing.get
import org.koin.core.KoinApplication
import org.koin.core.module.Module
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module


fun Route.registerAccountingRoute(){
    get("/accounting") {
        call.respondText("Accounting Module")
    }
}
val accountingModule = module {
    single<AccountingService>(null, true) { AccountingService() }
}