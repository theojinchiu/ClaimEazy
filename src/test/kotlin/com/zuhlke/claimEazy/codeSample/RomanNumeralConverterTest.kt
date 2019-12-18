package com.zuhlke.claimEazy.codeSample

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.times
import org.mockito.Mockito.verify

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class RomanNumeralConverterTest {
    @InjectMocks
    private val service = RomanNumeralConverter()

    @Mock
    private val romanNumeralAssistMock: AssistService = Mockito.mock(RomanNumeralAssistService::class.java)

    @BeforeAll
    fun init() {
        Mockito.`when`(romanNumeralAssistMock.shouldRun(10)).thenReturn(false)
        service.romanNumeralAssistService = romanNumeralAssistMock
    }

    companion object {
        @JvmStatic
        fun romanNumeralToIntTestCases(): List<Arguments> {
            return listOf(
                    Arguments.of("I", 1),
                    Arguments.of("II", 2),
                    Arguments.of("III", 3),
                    Arguments.of("IV", 4),
                    Arguments.of("V", 5),
                    Arguments.of("VI", 6),
                    Arguments.of("VII", 7),
                    Arguments.of("IX", 9)
            )
        }
    }

    @ParameterizedTest
    @MethodSource("romanNumeralToIntTestCases")
    fun convertRomanNumeralToInt_Test(romanNumeral: String, expected: Int) {
        val result = service.convertRomanNumeralToInt(romanNumeral)

        assertEquals(expected, result)
    }

    @Test
    fun normal_RomanNumeralToInt_Test() {
        var result = service.convertRomanNumeralToInt("XIII")

        assertEquals(13, result)

        verify(romanNumeralAssistMock, times(1)).shouldRun(10)
    }
}