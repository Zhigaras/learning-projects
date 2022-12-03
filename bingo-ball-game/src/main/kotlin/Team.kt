import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class Team(numberOfPlayers: Int, numberOfCards: Int) {
    val playersList = mutableListOf<Player>()
    var hasWinnner = false

    init {
        runBlocking {
            for (i in 1..numberOfPlayers) {
                launch {
                    playersList.add(Player(numberOfCards, i))
                }
            }
        }
    }

    fun printTeamCards() {
        playersList.forEach { player ->
            player.cardsList.forEach { card ->
                println("Player ${player.playerID}, card ${card.cardID}")
                card.printCard()
            }
        }
    }

    fun printWinner() {
        playersList.forEach { player ->
            player.cardsList.forEach { card ->
                if (player.isWinner && card.isWinning) {
                    println(
                        "STOP GAME! We have a winner!! " +
                                "Player ${player.playerID} won with card ${card.cardID}! "
                    )
                    println("Winning card:")
                    card.printCard()
                }
            }
        }
    }
}