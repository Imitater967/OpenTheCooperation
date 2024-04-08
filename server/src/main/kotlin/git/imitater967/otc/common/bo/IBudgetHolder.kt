package git.imitater967.otc.common.bo

import git.imitater967.otc.common.expection.NotEnoughBudget
import java.math.BigDecimal

//金钱持有者, 记录着资金的流动
interface IBudgetHolder {
    //从一个金钱对象转移到另一个金钱持有对象
    fun transfer(target: IBudgetHolder,amount: BigDecimal)
    fun addBudget(amount: BigDecimal)
    fun extractBudget(amount: BigDecimal)
}