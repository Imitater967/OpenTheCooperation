package git.imitater967.otc.common.bo

import git.imitater967.otc.common.expection.NotEnoughBudget
import java.math.BigDecimal

//储存的项目资金
open class BaseBudgetHolder : IBudgetHolder{
    private lateinit var budget: BigDecimal;
    override fun addBudget(amount: BigDecimal){
        budget += amount
    }
    override fun extractBudget(amount: BigDecimal){
        if(budget<amount){
            throw NotEnoughBudget()
        }
        budget -= amount
    }

    override fun transfer(target: IBudgetHolder, amount: BigDecimal) {
        TODO("Not yet implemented")
    }
}