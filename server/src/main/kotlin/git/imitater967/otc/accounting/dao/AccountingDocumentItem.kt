package git.imitater967.otc.accounting.dao

import org.jetbrains.exposed.sql.Table
import java.math.BigDecimal

//记账凭证条目,和记账凭证表配合使用
data class AccountingDocumentItem(
    val id: UInt,
    val tableId: UInt, //凭证体ID
    val summary: String, //摘要
    val firstLevelSubject: UShort, //主科目ID
    val secondLevelSubject: UShort, //明细科目ID
    val isDebit: Boolean, //是否借
    val amount: BigDecimal, //金额
)


object AccountingDocumentItems: Table("accounting_document_item"){
    val id = uinteger("id").autoIncrement()
    val tableId = uinteger(ACCOUNTING_DOCUMENT_TABLE_ID)
    val summary = varchar("attachmentId",16)
    val firstLevelSubject = ushort("firstLevelSubject")
    val secondLevelSubject = ushort("secondLevelSubject")
    val isDebit = bool("isDebit")
    val amount = decimal("amount",16,2)

    override val  primaryKey = PrimaryKey(id)
}

