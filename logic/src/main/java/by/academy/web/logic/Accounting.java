package by.academy.web.logic;

import java.math.BigDecimal;
import java.util.List;

public class Accounting {

    /**
     * Returns a {@link BigDecimal} average of {@link List<Integer>}
     * @param integers {@link List<Integer>}
     * @return {@link BigDecimal}
     */
    public BigDecimal average(List<Integer> integers) {
        double average = integers.stream()
                .mapToInt(i -> i)
                .average()
                .orElse(0.0);
        return new BigDecimal(average);
    }

}
