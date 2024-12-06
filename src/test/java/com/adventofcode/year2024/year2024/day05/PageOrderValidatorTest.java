package com.adventofcode.year2024.year2024.day05;

import com.adventofcode.year2024.day05.PageOrderValidator;
import com.adventofcode.year2024.day05.PageOrderingRules;
import com.adventofcode.year2024.day05.PageUpdates;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PageOrderValidatorTest {

  private PageOrderValidator validator;
  private PageOrderingRules pageOrderingRules;
  private PageUpdates pageUpdates;

  @BeforeEach
  void setUp() {
    validator = new PageOrderValidator();
    pageOrderingRules = new PageOrderingRules();
    pageUpdates = new PageUpdates();
  }

  @Test
  void testIsValidUpdate_ValidUpdate() {
    pageOrderingRules.addRule(1,2);
    pageOrderingRules.addRule(1,3);
    pageOrderingRules.addRule(2,3);
    pageUpdates.addUpdate(List.of(1, 2, 3));

    // Call the method under test
    boolean isValid = validator.isValidUpdate(pageUpdates.getUpdates().get(0), pageOrderingRules);

    // Verify the results
    assertTrue(isValid);
  }

  @Test
  void testIsValidUpdate_InvalidUpdate() {
    pageOrderingRules.addRule(1,2);
    pageOrderingRules.addRule(1,3);
    pageOrderingRules.addRule(2,3);
    pageUpdates.addUpdate(List.of(2, 1, 3));

    // Call the method under test
    boolean isValid = validator.isValidUpdate(pageUpdates.getUpdates().get(0), pageOrderingRules);

    // Verify the results
    assertFalse(isValid);
  }

  @Test
  void testIsValidUpdate_UpdateWithUnrelatedPages() {
    pageOrderingRules.addRule(1,2);
    pageOrderingRules.addRule(1,3);
    pageUpdates.addUpdate(List.of(1, 2, 3, 4));

    // Call the method under test
    boolean isValid = validator.isValidUpdate(pageUpdates.getUpdates().get(0), pageOrderingRules);

    // Verify the results
    assertTrue(isValid);
  }

  @Test
  void testGetCorrectedUpdatesSomeCorrections() {
    pageOrderingRules.addRule(1,2);
    pageOrderingRules.addRule(1,3);
    pageOrderingRules.addRule(2,3);
    pageUpdates.addUpdate(List.of(2, 1, 3));

    PageOrderValidator validator = new PageOrderValidator();
    PageUpdates correctedUpdates = validator.getCorrectedUpdates(pageUpdates.getUpdates(), pageOrderingRules);
    assertFalse(correctedUpdates.getUpdates().isEmpty());

  }
}
