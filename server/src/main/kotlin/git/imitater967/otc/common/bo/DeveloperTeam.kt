package git.imitater967.otc.common.bo

class DeveloperTeam(id:UShort,name: String, description: String) : NamedBudgetHolder(id,name, description) {
    val members: List<DeveloperUser> = ArrayList()
}