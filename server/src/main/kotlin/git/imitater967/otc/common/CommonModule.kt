package git.imitater967.otc.common

import git.imitater967.otc.common.so.BudgetService
import org.koin.core.module.dsl.createdAtStart
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val commonModule = module {
    singleOf(::BudgetService){
        createdAtStart()
    }
}