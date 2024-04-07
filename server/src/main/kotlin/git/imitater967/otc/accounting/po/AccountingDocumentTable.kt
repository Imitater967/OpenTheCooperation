package git.imitater967.otc.accounting.po

//这里采用util.Date,因为是会计凭证所以我们需要精确到小时
import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.javatime.datetime
import java.util.Date

//记账凭证表, 不包含条目
data class AccountingDocumentTable(
    val id: UInt,
    val tableId: UInt, //表ID
    val date: Date, //表编写日期
    val supervisorId: UInt, //会计主管ID
    val clerkId: UInt, //会计员ID
    val reviewerId: UInt, //复核员ID
)

object AccountingDocumentTables: Table() {
    val id = uinteger("id")
    val tableId = uinteger(ACCOUNTING_DOCUMENT_TABLE_ID)
    val date = datetime("date")
    val supervisorId = uinteger("supervisorId")
    val clerkId = uinteger("clerkId")
    val reviewerId = uinteger("reviewerId")
    override val  primaryKey = PrimaryKey(id)

}
