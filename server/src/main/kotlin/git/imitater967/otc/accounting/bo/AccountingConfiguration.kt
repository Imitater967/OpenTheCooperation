package git.imitater967.otc.accounting.bo

//记账配置信息,记载着账本的id
class AccountingConfiguration {
    val subjectAcceptDonate: AccountingSubject = AccountingSubject("接受捐赠", 0u)
    val subjectBankBalance: AccountingSubject = AccountingSubject("银行存款", 1u)
    val subjectProjectBalance: AccountingSubject = AccountingSubject("项目资金", 2u)
    val subjectDevelopExpense: AccountingSubject = AccountingSubject("研发费用", 3u)
    val subjectPayrollTeam: AccountingSubject = AccountingSubject("应付团队薪酬",4u)
    val subjectPayrollIndividual: AccountingSubject = AccountingSubject("应付职工薪酬",5u)
    val accountSubjects : ArrayList<AccountingSubject> = ArrayList();
    constructor(){
        accountSubjects.add(subjectAcceptDonate)
        accountSubjects.add(subjectBankBalance)
        accountSubjects.add(subjectProjectBalance)
        accountSubjects.add(subjectDevelopExpense)
    }
}