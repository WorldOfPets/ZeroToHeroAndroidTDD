package ru.easycode.zerotoheroandroidtdd

interface Count {

    fun increment(number:String):UiState
    class Base(private var step:Int, private val max:Int):Count{
        init {
            if (step < 1)
                throw IllegalStateException("step should be positive, but was $step")
            if (max < 1)
                throw IllegalStateException("max should be positive, but was $max")
            if (max < step)
                throw IllegalStateException("max should be more than step")
        }

        override fun increment(number: String): UiState {
            val digits = step + number.toInt()
            return if (digits + step <= max){
                UiState.Base(digits.toString())
            }else{
                UiState.Max(digits.toString())
            }

        }
    }
}