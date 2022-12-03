import kotlinx.coroutines.*
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow

object Generator {
    private val bagOfNumbers = mutableSetOf<Int>()
    private val scope = CoroutineScope(Job() + Dispatchers.Default)
    private val _sharedFlow = MutableSharedFlow<Int>()
    val sharedFlow = _sharedFlow.asSharedFlow()

    init {
        for (i in 1..90) {
            bagOfNumbers.add(i)
        }

        scope.launch {
            while (bagOfNumbers.isNotEmpty()) {
                _sharedFlow.emit(getNumber())
                delay(200)
            }
        }
    }

    private fun getNumber(): Int {
        val number = bagOfNumbers.random()
        bagOfNumbers.remove(number)
        return number
    }
}