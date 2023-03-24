package ru.aleshin.core.utils.managers

import junit.framework.TestCase.assertEquals
import org.junit.Before
import org.junit.Test

/**
 * @author Stanislav Aleshin on 24.03.2023.
 */
internal class MathManagerTest {

    private lateinit var mathManager: MathManager

    @Before
    fun setUp() {
        mathManager = MathManager.Base()
    }

    @Test
    fun test_calculate_simple_case() {
        val actual = mathManager.calculateValue("3+3*3")
        val expected = 12.0
        assertEquals(expected, actual)
    }

    @Test
    fun test_calculate_easy_case() {
        val actual = mathManager.calculateValue("18/2+5/5+0")
        val expected = 10.0
        assertEquals(expected, actual)
    }

    @Test
    fun test_calculate_medium_case() {
        val actual = mathManager.calculateValue("-5/1-12/12+42/21-4*6+12.22/0.23")
        val expected = 25.1304347826
        assertEquals(expected, expected)
    }

    @Test
    fun test_calculate_hard_case() {
        val actual = mathManager.calculateValue("543223/2131223*0.123/12+12332-123*1/2")
        val expected = 12270.5026126
        assertEquals(expected, expected)
    }
}