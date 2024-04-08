package git.imitater967.otc.accounting.dao

import org.jetbrains.exposed.sql.Table

//记账凭证附件
data class AccountingDocumentAttachment(
    val id: UInt,
    val tableId: UInt, //绑定的主表ID
    val attachmentId: UInt //附件ID, 存bucket用
)

object AccountingDocumentAttachments: Table("accounting_document_attachment"){
    val id = uinteger("id")
    val tableId = uinteger(ACCOUNTING_DOCUMENT_TABLE_ID)
    val attachmentID = uinteger("attachmentId")

    override val  primaryKey = PrimaryKey(id)
}
