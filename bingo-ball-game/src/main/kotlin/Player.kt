class Player(numberOfCards: Int, var playerID: Int) {
    var cardsList: MutableList<Card> = mutableListOf()
    var isWinner = false

    init {
        for (i in 1..numberOfCards) {
            cardsList.add(Card(i))
        }
    }

    fun checkNumber(generatedNumber: Int) {
        cardsList.forEach { card ->
            card.card.forEach { row ->
                row.forEach { number ->
                    if (number.value == generatedNumber) number.isMarkered = true
                    if (row.all { it.isMarkered }) {
                        isWinner = true
                        card.isWinning = true
                    }
                }
            }
        }
    }
}
