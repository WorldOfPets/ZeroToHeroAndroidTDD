package ru.easycode.zerotoheroandroidtdd

interface Count {

    fun increment(number: String):UiState
    fun initial(number:String):UiState
    fun decrement(number: String):UiState

    class Base(private val step: Int, private val max:Int, private val min:Int):Count{
        init {
            if (step < 1)
                throw IllegalStateException("step should be positive, but was $step")
            if (max < 1)
                throw IllegalStateException("max should be positive, but was $max")
            if (max < min)
                throw IllegalStateException("max should be more than min")
            if (max < step)
                throw IllegalStateException("max should be more than step")
        }
        override fun increment(number: String): UiState {
            var digits = number.toInt() + step
            if (digits + step <= max)
                return UiState.Base(digits.toString())
            else
                return UiState.Max(digits.toString())
        }

        override fun initial(number: String): UiState {
            if (number.toInt() == max)
                return UiState.Max(number)
            else if (number.toInt() == min)
                return UiState.Min(number)
            else
                return UiState.Base(number)
        }

        override fun decrement(number: String): UiState {
            var digits = number.toInt() - step
            if (digits - step < min)
                return UiState.Min(digits.toString())
            else
                return UiState.Base(digits.toString())
        }
    }
}