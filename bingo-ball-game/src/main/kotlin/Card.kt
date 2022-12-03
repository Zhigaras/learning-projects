import kotlin.random.Random

class Card(var cardID: Int) {

    var card = Array(3) { Array(9) { Number(null) } }
    var isWinning = false

    init {
        card = fillCard().sortCells().deleteRedundant()
    }

    private fun fillCard(): Array<Array<Int>> {
        val resultArray = Array(3) { Array(9) { 0 } }
        for (rowIndex in 0..2) {
            for (columnIndex in 0..8) {
                var currentNumber: Int
                do {
                    currentNumber = when (columnIndex) {
                        0 -> Random.nextInt(1, 9)
                        8 -> Random.nextInt(80, 90)
                        else -> Random.nextInt(columnIndex * 10, columnIndex * 10 + 9)
                    }
                } while (resultArray.hasTheSame(currentNumber))
                resultArray[rowIndex][columnIndex] = currentNumber
            }
        }
        return resultArray
    }

    private fun Array<Array<Int>>.hasTheSame(element: Int): Boolean {
        var result = false
        this.forEach { row -> row.forEach { if (it == element) result = true } }
        return result
    }

    private fun Array<Array<Int>>.sortCells(): Array<Array<Number>> {
        val transposedArray = Array(9) { Array(3) { 0 } }
        this.forEachIndexed { rowIndex, row ->
            row.forEachIndexed { columnIndex, element ->
                transposedArray[columnIndex][rowIndex] = element
            }
        }
        val resultArray = Array(3) { Array(9) { Number(null) } }
        transposedArray.forEach { it.sort() }
        transposedArray.forEachIndexed { rowIndex, row ->
            row.forEachIndexed { columnIndex, cell ->
                resultArray[columnIndex][rowIndex] = Number(cell)
            }
        }
        return resultArray
    }

    private fun Array<Array<Number>>.deleteRedundant(): Array<Array<Number>> {
        this.forEach {
            for (i in 1..4) it
                .filter { it.value != null }
                .random()
                .let {
                    it.value = null
                    it.isMarkered = true
                }
        }
        return this
    }

    fun printCard() {
        print("┌──")
        for (i in 1 until card[0].size) print("──┬──")
        println("──┐")
        for (row in card) {
            print("│")
            for (cell in row) {
                if (cell.value == null) print("    │")
                else if (cell.isMarkered) print(" \u001B[32m${String.format("%2d", cell.value)}\u001B[0m │")
                else print(" ${String.format("%2d", cell.value)} │")
            }
            if (row.contentEquals(card.last())) {
                print("\n└──")
                for (i in 1 until card[0].size) print("──┴──")
                println("──┘")
            } else {
                print("\n├──")
                for (i in 1 until card[0].size) print("──┼──")
                println("──┤")
            }
        }
    }
}