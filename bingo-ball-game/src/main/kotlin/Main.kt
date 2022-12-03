import kotlinx.coroutines.*

fun main() {

    val numberOfPlayers = inputRequest(100, "players")
    val numberOfCards = inputRequest(50, "cards")
    val team = Team(numberOfPlayers, numberOfCards)

    team.printTeamCards()

    runBlocking {
        launch {
            println("The game started.")
            var counter = 0
            Generator.sharedFlow.collect { generatedNumber ->
                counter++
                println("$counter number - $generatedNumber")
                team.playersList.forEach { player ->
                    launch {
                        player.checkNumber(generatedNumber)
                        if (player.isWinner) {
                            team.hasWinnner = true
                        }
                        cancel()
                    }
                }
                delay(200)
                if (team.hasWinnner) {
                    team.printWinner()
                    cancel()
                }
            }
        }
    }
}

fun inputRequest(maxNumber: Int, requestItem: String): Int {
    println("Enter the number of $requestItem ($maxNumber max!).")
    var requestResult: Int?
    do {
        requestResult = readLine()?.toIntOrNull()
        if (requestResult == null) println("Incorrect input. Try again.")
        else if (requestResult > maxNumber || requestResult == 0) println("Input is out of bounds.")
    } while (requestResult == null || requestResult > maxNumber || requestResult == 0)
    return requestResult
}