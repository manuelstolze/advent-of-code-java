package year2024.day04;

import com.adventofcode.year2024.day04.WordSearch;
import com.adventofcode.common.Direction;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class WordSearchTest {

  @Test
  void testIsWordPresent() {
    char[][] grid = {
            {'C', 'O', 'D', 'E'},
            {'A', 'B', 'C', 'D'},
            {'D', 'E', 'F', 'G'}
    };
    WordSearch wordSearch = new WordSearch("CODE");
    assertTrue(wordSearch.isWordPresent(grid, 0, 0, Direction.HORIZONTAL_RIGHT));
    assertFalse(wordSearch.isWordPresent(grid, 0, 0, Direction.VERTICAL_UP));
  }

  @Test
  void testIsWordPresentAtEdge() {
    char[][] grid = {
            {'C', 'O', 'D', 'E'},
            {'G', 'F', 'E', 'D'},
            {'D', 'E', 'F', 'G'}
    };
    WordSearch wordSearch = new WordSearch("DEFG");
    assertTrue(wordSearch.isWordPresent(grid, 2, 0, Direction.HORIZONTAL_RIGHT));
    assertTrue(wordSearch.isWordPresent(grid, 1, 3, Direction.HORIZONTAL_LEFT));
    assertFalse(wordSearch.isWordPresent(grid, 2, 1, Direction.VERTICAL_UP)); // Edge case
  }

  @Test
  void testCountWordOccurrences() {
    char[][] grid = {
            {'C', 'O', 'D', 'E'},
            {'A', 'B', 'C', 'D'},
            {'D', 'E', 'F', 'G'}
    };
    WordSearch wordSearch = new WordSearch("CD");
    assertEquals(2, wordSearch.countWordOccurrences(grid));
  }

  @Test
  void testCountWordOccurrencesNoMatch() {
    char[][] grid = {
            {'C', 'O', 'D', 'E'},
            {'A', 'B', 'C', 'D'},
            {'D', 'E', 'F', 'G'}
    };
    WordSearch wordSearch = new WordSearch("XYZ");
    assertEquals(0, wordSearch.countWordOccurrences(grid));
  }

  @Test
  void testCountWordOccurrencesWithDifferentDirections() {
    char[][] grid = {
            {'C', 'O', 'D', 'E'},
            {'O', 'C', 'O', 'D'},
            {'D', 'O', 'C', 'O'}
    };
    WordSearch wordSearch = new WordSearch("COD");
    assertEquals(5, wordSearch.countWordOccurrences(grid)); // Horizontal, Vertical, Diagonal
  }

  @Test
  void testInvalidGrid() {
    char[][] grid = {}; // Empty grid
    WordSearch wordSearch = new WordSearch("CODE");
    assertEquals(0, wordSearch.countWordOccurrences(grid));
  }

  @Test
  void testNullGrid() {
    char[][] grid = null; // Null grid
    WordSearch wordSearch = new WordSearch("CODE");
    assertThrows(NullPointerException.class, () -> wordSearch.countWordOccurrences(grid));
  }
}
