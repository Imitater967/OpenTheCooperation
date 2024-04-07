package git.imitater967.otc.accounting.po

import java.math.BigDecimal

//记账凭证条目,和记账凭证表配合使用
data class AccountingDocumentItem(
    val bodyId: Long, //凭证体ID
    val summary: String, //摘要
    val firstLevelSubject: UInt, //主科目ID
    val secondLevelObject: UInt, //明细科目ID
    val debit: Boolean, //是否借
    val amount: BigDecimal, //金额
)
