package year2024.day02;

import com.adventofcode.common.AdventOfCodeFileReader;
import com.adventofcode.year2024.day02.ProblemDumper;
import com.adventofcode.year2024.day02.ReportChecker;
import com.adventofcode.year2024.day02.RiddleResolver;
import org.junit.jupiter.api.Test;

import java.util.List;

public class RiddleResolverTest {

  AdventOfCodeFileReader fileReader = new AdventOfCodeFileReader();
  RiddleResolver riddleResolver = new RiddleResolver();

  @Test
  void testExtractCodeFromReport() {
    String report = "1 2 3 4 5";
    assert riddleResolver.extractCodeFromReport(report).equals(List.of(1, 2, 3, 4, 5));
  }

  @Test
  void testSolveRiddleOne() {
    // Todo: Call the actual solveRiddleOne method
    List<String> lines = fileReader.readFile("src/test/resources/2024/02.txt");

    int numberOfSaveReports = 0;

    for (String line : lines) {
      List<Integer> codes = riddleResolver.extractCodeFromReport(line);

      if (ReportChecker.isIncreasingOrDecreasing(codes)) {
        numberOfSaveReports++;
      }
    }

    assert numberOfSaveReports == 2;
  }

  @Test
  void testSolveRiddleTwo() {
    List<String> lines = fileReader.readFile("src/test/resources/2024/02.txt");
    int numberOfSaveReports = 0;

    for (String line : lines) {
      List<Integer> codes = riddleResolver.extractCodeFromReport(line);

      if(ProblemDumper.isSave(codes)){
        numberOfSaveReports++;
      }
    }
    assert numberOfSaveReports == 4;
  }
}
