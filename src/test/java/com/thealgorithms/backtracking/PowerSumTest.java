package com.thealgorithms.backtracking;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;

public class PowerSumTest {
    @Nested
    @DisplayName("Test cases for PowerSum")
    class powSum {
        @Test
        @DisplayName("Test case for powSum with 100 and 3")
        public void testPowSum() {
            PowerSum ps = new PowerSum();
            int count = ps.powSum(100, 3);
            assert count == 1;
        }

        @Test
        @DisplayName("Test case for powSum with 100 and 2")
        public void testPowSum2() {
            PowerSum ps = new PowerSum();
            int count = ps.powSum(100, 2);
            assert count == 3;
        }
    }
}
