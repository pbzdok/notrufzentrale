package commands.dice

import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

internal class DiceTest {

    @Test
    fun `test fromString 2d6`() {
        val result = Dice.fromString("2d6")
        assertTrue(result.isRight())
        result.map { assertTrue(it.roll().size == 2) }
    }

    @Test
    fun `test wrong fromString`() {
        val result = Dice.fromString("abc")
        assertTrue(result.isLeft())
        result.mapLeft { assertTrue(it is Error.Parse) }
    }

    @Test
    fun `test wrong fromString 2d7`() {
        val result = Dice.fromString("2d7")
        assertTrue(result.isLeft())
        result.mapLeft { assertTrue(it is Error.Size) }
    }
}