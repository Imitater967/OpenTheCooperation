package git.imitater967.otc.database

import git.imitater967.otc.accounting.po.AccountingDocumentAttachments
import git.imitater967.otc.accounting.po.AccountingDocumentItems
import git.imitater967.otc.accounting.po.AccountingDocumentTables
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.exposedLogger
import org.jetbrains.exposed.sql.transactions.transaction

class DatabaseManagerImpl: DatabaseManager {
    val driverClassName = "org.h2.Driver"
    val jdbcURL = "jdbc:h2:file:./build/db"
    val database: Database;
    constructor(){
        database = connect();
        exposedLogger.info("Connecting to database")
        transaction(database) {
            SchemaUtils.create(AccountingDocumentAttachments)
            SchemaUtils.create(AccountingDocumentItems)
            SchemaUtils.create(AccountingDocumentTables)
        }
    }
    fun connect(): Database {
        return Database.connect(jdbcURL,driverClassName)
    }
}