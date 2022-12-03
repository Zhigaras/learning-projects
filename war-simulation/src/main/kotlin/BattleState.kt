sealed class BattleState {

    class Progress(team1: Team, team2: Team) : BattleState() {
        init {
            println("\nThe battle continues." +
                    "\nThe \"${team1.name}\" team has ${team1.teamList.size} warriors." +
                    "\nthe \"${team2.name}\" team has ${team2.teamList.size} warriors." +
                    "\nNext turn.")
        }
    }

    class Team1Win(team: Team) : BattleState() {
        init {
            println("Congratulations! The \"${team.name}\" team won!")
        }
    }

    class Team2Win(team: Team) : BattleState() {
        init {
            println("Congratulations! The \"${team.name}\" team won!")
        }
    }
}
