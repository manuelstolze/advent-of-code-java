package year2024.day03;

import com.adventofcode.year2024.day03.InstructionStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class InstructionStatusTest {

  @BeforeEach
  void resetSingleton() throws ReflectiveOperationException {
    // Use reflection to reset the singleton instance before each test
    var field = InstructionStatus.class.getDeclaredField("instance");
    field.setAccessible(true);
    field.set(null, null);
  }

  @Test
  void getInstance_ShouldReturnSameInstance() {
    InstructionStatus firstInstance = InstructionStatus.getInstance();
    InstructionStatus secondInstance = InstructionStatus.getInstance();
    assertSame(firstInstance, secondInstance, "getInstance should return the same instance");
  }

  @Test
  void isEnabled_ShouldInitiallyBeTrue() {
    InstructionStatus status = InstructionStatus.getInstance();
    assertTrue(status.isEnabled(), "isEnabled should initially be true");
  }

  @Test
  void setEnabled_ShouldChangeStatus() {
    InstructionStatus status = InstructionStatus.getInstance();
    status.setEnabled(false);
    assertFalse(status.isEnabled(), "setEnabled should change the status");
  }
}
