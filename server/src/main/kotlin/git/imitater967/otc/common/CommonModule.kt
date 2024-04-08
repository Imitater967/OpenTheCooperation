package git.imitater967.otc.common

import git.imitater967.otc.common.so.ReceiveMoneyService
import org.koin.dsl.module

val commonModule = module {
    single<ReceiveMoneyService>(null, true) { ReceiveMoneyService() }
}