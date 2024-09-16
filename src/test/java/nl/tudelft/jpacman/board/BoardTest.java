package nl.tudelft.jpacman.board;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Test class for the Board class.
 */
public class BoardTest {

    private Board board;

    @BeforeEach
    void setUp() {
        // Create a 1x1 grid with a BasicSquare
        Square[][] grid = new Square[][] {
            { new BasicSquare() }
        };
        board = new Board(grid);
    }

    @Test
    void testBoardCreation() {
        // Ensure that the board width and height are correct
        assertEquals(1, board.getWidth());
        assertEquals(1, board.getHeight());

        // Ensure the squareAt method returns a non-null square
        assertNotNull(board.squareAt(0, 0));
    }

    @Test
    void testWithinBorders() {
        // Check that withinBorders returns true for valid coordinates
        assertTrue(board.withinBorders(0, 0));

        // Check that withinBorders returns false for out-of-bounds coordinates
        assertFalse(board.withinBorders(-1, 0));
        assertFalse(board.withinBorders(0, 1));
    }
    @Test
    void testBoardWithNullSquare() {
        // Create a 1x1 grid with a null square
        Square[][] nullGrid = new Square[][] { { null } };

        // Initialize a new board with the grid containing the null square
        board = new Board(nullGrid);

        // Test that accessing the null square throws a NullPointerException or another exception
        assertThatThrownBy(() -> board.squareAt(0, 0))
            .isInstanceOf(NullPointerException.class);  // Change exception if board handles it differently
    }

}
