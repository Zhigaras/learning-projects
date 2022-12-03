class Battle(teamSize: Int) {

    var team1 = Team("Red", teamSize)
    var team2 = Team("Blue", teamSize)
    var isOver: Boolean = false

    private fun getBattleState(): BattleState {
        return if (team1.teamList.isEmpty()) {
            isOver = true
            BattleState.Team2Win(team1)
        } else if (team2.teamList.isEmpty()) {
            isOver = true
            BattleState.Team1Win(team1)
        } else BattleState.Progress(team1, team2)
    }

    fun clutch(team1: Team, team2: Team) {
        println("\nThe \"${team1.name}\" team is attacking.")
        val attacker = team1.teamList.random()
        val victim = team2.teamList.random()
        attacker.attack(victim)
        team1.printTeamInfo(attacker, victim)
        team2.printTeamInfo(attacker, victim)
        val iterator = team2.teamList.iterator()
        while (iterator.hasNext()) {
            val it = iterator.next()
            if (!it.isAlive) {
                println("\nThe warrior ${it.rank} was\u001B[31m killed †\u001B[0m in \"${team2.name}\" team.")
                iterator.remove()
            }
        }
        getBattleState()
    }
}