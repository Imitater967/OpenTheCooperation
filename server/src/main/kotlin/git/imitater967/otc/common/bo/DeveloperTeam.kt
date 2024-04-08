package git.imitater967.otc.common.bo

class DeveloperTeam(name: String, description: String) : NamedBudgetHolder(name, description) {
    val members: List<DeveloperUser> = ArrayList()
}