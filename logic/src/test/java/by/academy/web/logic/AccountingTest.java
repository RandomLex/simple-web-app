package by.academy.web.logic;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AccountingTest {



    @Test
    void averageInteger() {
        //given
        List<Integer> integers = List.of(6, 8);
        BigDecimal expectedAverage = BigDecimal.valueOf(7);
        //when
        Accounting accounting = new Accounting();
        BigDecimal actualAverage = accounting.average(integers);
        //then
        assertEquals(expectedAverage, actualAverage);
    }

    @Test
    void averageDecimal() {
        //given
        List<Integer> integers = List.of(5, 6);
        BigDecimal expectedAverage = BigDecimal.valueOf(5.5);
        //when
        Accounting accounting = new Accounting();
        BigDecimal actualAverage = accounting.average(integers);
        //then
        assertEquals(expectedAverage, actualAverage);
    }

}