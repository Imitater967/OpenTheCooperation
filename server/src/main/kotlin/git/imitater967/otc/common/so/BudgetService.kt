package git.imitater967.otc.common.so

import git.imitater967.otc.accounting.so.AccountingService
import git.imitater967.otc.common.bo.Organization
import git.imitater967.otc.common.bo.Sponsor
import java.math.BigDecimal

class BudgetService (val accountingService : AccountingService){


    //接受钱服务
    //1. 会计记账
    // 借 银行存款
    // 贷 公共资金-项目名称
    public fun DonateMoney(sponsor: Sponsor,organization: Organization,amount: BigDecimal){
        accountingService.donateMoney(sponsor,organization,amount)
    }
}