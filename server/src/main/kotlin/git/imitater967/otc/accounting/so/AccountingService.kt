package git.imitater967.otc.accounting.so

import git.imitater967.otc.accounting.bo.AccountingConfiguration
import git.imitater967.otc.accounting.dao.AccountingDocumentItems
import git.imitater967.otc.accounting.dao.AccountingDocumentTables
import git.imitater967.otc.common.bo.Organization
import git.imitater967.otc.common.bo.Project
import git.imitater967.otc.common.bo.Sponsor
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.statements.InsertStatement
import org.jetbrains.exposed.sql.transactions.transaction
import java.math.BigDecimal
import java.time.LocalDateTime

//记账服务
//1. 记录从捐款者那边收到的捐款
//2. 记录贡献组提取的捐款
//3. 记录捐款者是为哪一个Issue捐的钱

class AccountingService(val configuration: AccountingConfiguration) {
    //捐赠金钱
    fun donateMoney(sponsor: Sponsor, organization: Organization, amount: BigDecimal) {

        //借： 银行存款
        //贷： 接受捐赠
        val donateSubjectName = configuration.subjectSponsorDonate;
        val bankSubjectName = configuration.subjectBankBalance;
        transaction {
            //先执行插入
            val table = insertDocumentTable()
            var tableId = table.get(AccountingDocumentTables.id);
            //贷
            AccountingDocumentItems.insert {
                it[this.tableId] = tableId
                it[summary] = "${sponsor.name}捐赠${amount}"
                it[firstLevelSubject] = donateSubjectName.id
                it[secondLevelSubject] = sponsor.id
                it[isDebit] = false
                it[this.amount] = amount
            }
            //借
            AccountingDocumentItems.insert {
                it[this.tableId] = tableId
                it[summary] = "${sponsor.name}捐赠${amount}"
                it[firstLevelSubject] = bankSubjectName.id
                it[secondLevelSubject] = sponsor.id
                it[isDebit] = true
                it[this.amount] = amount
            }

        }
        sponsor.addBudget(amount)

    }
    //把捐赠给组织的金钱，分配给项目
    fun assignProjectBudget(organization: Organization, project: Project, amount: BigDecimal) {

        //借： 项目资金
        //贷： 银行存款
        val donateSubjectName = configuration.subjectProjectBalance;
        val bankSubjectName = configuration.subjectBankBalance;
        transaction {
            //先执行插入
            val table = insertDocumentTable()
            var tableId = table.get(AccountingDocumentTables.id);
            //贷
            AccountingDocumentItems.insert {
                it[this.tableId] = tableId
                it[summary] = "${project.name}分配${amount}"
                it[firstLevelSubject] = bankSubjectName.id
                it[secondLevelSubject] = project.id
                it[isDebit] = false
                it[this.amount] = amount
            }
            //借
            AccountingDocumentItems.insert {
                it[this.tableId] = tableId
                it[summary] = "${project.name}分配${amount}"
                it[firstLevelSubject] = project.id
                it[secondLevelSubject] = 0u
                it[isDebit] = true
                it[this.amount] = amount
            }

        }
    }

    //把项目的金钱，分配给团队
    fun assignIssueBudget(organization: Organization, project: Project, amount: BigDecimal) {

        //借： 项目资金
        //贷： 银行存款
        val donateSubjectName = configuration.subjectProjectBalance;
        val bankSubjectName = configuration.subjectBankBalance;
        transaction {
            //先执行插入
            val table = insertDocumentTable()
            var tableId = table.get(AccountingDocumentTables.id);
            //贷
            AccountingDocumentItems.insert {
                it[this.tableId] = tableId
                it[summary] = "${project.name}分配${amount}"
                it[firstLevelSubject] = bankSubjectName.id
                it[secondLevelSubject] = project.id
                it[isDebit] = false
                it[this.amount] = amount
            }
            //借
            AccountingDocumentItems.insert {
                it[this.tableId] = tableId
                it[summary] = "${project.name}分配${amount}"
                it[firstLevelSubject] = project.id
                it[secondLevelSubject] = 0u
                it[isDebit] = true
                it[this.amount] = amount
            }

        }
    }


    fun insertDocumentTable(): InsertStatement<Number> {
        val table = transaction {
            AccountingDocumentTables.insert {
                it[date] = LocalDateTime.now(configuration.zoneId);
            }

        }
        return table
    }

}