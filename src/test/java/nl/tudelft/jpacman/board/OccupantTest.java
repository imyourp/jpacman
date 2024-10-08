package nl.tudelft.jpacman.board;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Test suite to confirm that {@link Unit}s correctly (de)occupy squares.
 */
class OccupantTest {

    /**
     * The unit under test.
     */
    private Unit unit;

    /**
     * The square used in the tests.
     */
    private Square square1;
    private Square square2;

    /**
     * Resets the unit under test.
     */
    @BeforeEach
    void setUp() {
        unit = new BasicUnit();
        square1 = new BasicSquare();
        square2 = new BasicSquare();
    }

    /**
     * Asserts that a unit has no square to start with.
     */
    @Test
    void noStartSquare() {
        assertThat(unit.hasSquare()).isFalse();
    }

    /**
     * Tests that the unit indeed has the target square as its base after
     * occupation.
     */
    @Test
    void testOccupy() {
        unit.occupy(square1);
        assertThat(unit.getSquare()).isEqualTo(square1);
    }

    /**
     * Test that the unit indeed has the target square as its base after
     * double occupation.
     */
    @Test
    void testReoccupy() {
        unit.occupy(square1);
        unit.occupy(square2);
        assertThat(unit.getSquare()).isEqualTo(square2);
    }
}
