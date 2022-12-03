class Team(val name: String, teamSize: Int) {

    val teamList = mutableListOf<AbstractWarrior>()

    init {
        for (i in 1..teamSize) {
            when (true) {
                10.chance() -> teamList.add(General())
                30.chance() -> teamList.add(Captain())
                else -> teamList.add(Soldier())
            }
        }
        printTeamInfo(attacker = null, victim = null)
    }

    fun printTeamInfo(attacker: AbstractWarrior?, victim: AbstractWarrior?) {
        println("\n     The \"$name\" team:\n--------------------------")
        teamList.forEachIndexed { i, it ->
            print("${String.format("%2d", i + 1)}. ")
            when {
                it === attacker ->
                    println("\u001B[32m${String.format("%11s", it.rank)}\u001B[0m " +
                                "${String.format("%6.1f", it.currentHP)} HP.")
                it === victim ->
                    println("\u001B[31m${String.format("%11s", it.rank)} " +
                                "${String.format("%6.1f", it.currentHP)} HP.\u001B[0m")
                else ->
                    println("${String.format("%11s", it.rank)} " +
                                "${String.format("%6.1f", it.currentHP)} HP.")
            }
        }
        println("--------------------------")
        println("${String.format("%15s", "Overall")} ${String.format("%6.1f", getOverallHP())} HP.")
    }

    private fun getOverallHP(): Double {
        var overallHP = 0.0
        teamList.forEach { overallHP += it.currentHP }
        return overallHP
    }
}

