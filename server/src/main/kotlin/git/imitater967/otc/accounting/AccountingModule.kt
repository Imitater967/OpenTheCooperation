package git.imitater967.otc.accounting

import git.imitater967.otc.database.DatabaseManager
import git.imitater967.otc.database.DatabaseManagerImpl
import io.ktor.server.routing.Route
import io.ktor.server.routing.get
import org.koin.core.KoinApplication
import org.koin.dsl.module


fun Route.registerAccountingRoute(){
    get("/accounting") {
        
    }
}
fun KoinApplication.registerAccountingModule(){
    module {
        single<DatabaseManager> { DatabaseManagerImpl() }
    }
}