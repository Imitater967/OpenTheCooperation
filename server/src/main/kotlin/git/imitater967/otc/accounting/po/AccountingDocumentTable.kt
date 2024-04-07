package git.imitater967.otc.accounting.po

//这里采用util.Date,因为是会计凭证所以我们需要精确到小时
import java.util.Date

//记账凭证表, 不包含条目
data class AccountingDocumentTable(val date: Date)

