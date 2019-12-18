package com.zuhlke.claimEazy.codeSample

class RomanNumeralConverter {
    private var romanNumeralIntMapping: MutableMap<String, Int> = mutableMapOf()
    var romanNumeralAssistService: AssistService = RomanNumeralAssistService()

    constructor() {
        this.romanNumeralIntMapping["I"] = 1
        this.romanNumeralIntMapping["V"] = 5
        this.romanNumeralIntMapping["X"] = 10
    }

    fun convertRomanNumeralToInt(s: String): Int {
        if(romanNumeralAssistService.shouldRun(10))
            return -1

        var sum = 0

        s.forEachIndexed forEach@{ index, element ->
            if(hasNextNumeral(index, s)) {
                val currentValue = this.romanNumeralIntMapping[s[index].toString()]!!
                val nextValue = this.romanNumeralIntMapping[s[index+1].toString()]!!

                if(currentValue < nextValue) {
                    sum -= currentValue
                    return@forEach
                }
            }

            sum += this.romanNumeralIntMapping[element.toString()]!!
        }

        return sum
    }

    private fun hasNextNumeral(index: Int, s: String): Boolean {
        return index < (s.length - 1)
    }
}

interface AssistService {
    fun shouldRun(value: Int) : Boolean
}

open class RomanNumeralAssistService : AssistService {
    override fun shouldRun(value: Int): Boolean {
        return false
    }
}
