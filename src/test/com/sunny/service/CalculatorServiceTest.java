package com.sunny.service;

import com.sunny.service.impl.CalculatorServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

/**
 * @description:
 * @author: Sunny
 * @date: 2023/3/5
 */
class CalculatorServiceTest {

    private CalculatorService calculatorService;

    @BeforeEach
    void setUp() {
        calculatorService = new CalculatorServiceImpl();
    }

    @Test
    void testAddCalculate() {
        String[] args = {"1", "+", "2"};
        BigDecimal bigDecimal = calculatorService.calculate(args);
        Assertions.assertEquals(bigDecimal.compareTo(new BigDecimal(3)), 0);
    }

    @Test
    void testSubCalculate() {
        String[] args = {"1", "-", "2"};
        BigDecimal bigDecimal = calculatorService.calculate(args);
        Assertions.assertEquals(bigDecimal.compareTo(new BigDecimal(-1)), 0);
    }

    @Test
    void testMultiCalculate() {
        String[] args = {"2", "*", "2"};
        BigDecimal bigDecimal = calculatorService.calculate(args);
        Assertions.assertEquals(bigDecimal.compareTo(new BigDecimal(4)), 0);
    }

    @Test
    void testDivCalculate() {
        String[] args = {"1", "/", "2"};
        BigDecimal bigDecimal = calculatorService.calculate(args);
        Assertions.assertEquals(bigDecimal.compareTo(new BigDecimal(0.5)), 0);
    }

    @Test
    void testUndo() {
        String[] args = {"1", "+", "2"};
        // 3
        calculatorService.calculate(args);
        args = new String[]{"1", "-", "2"};
        // -1
        calculatorService.calculate(args);
        args = new String[]{"1", "*", "2"};
        // 2
        calculatorService.calculate(args);
        // -1
        BigDecimal bigDecimal = calculatorService.undo();
        Assertions.assertEquals(bigDecimal.compareTo(new BigDecimal(-1)), 0);
        // 3
        bigDecimal = calculatorService.undo();
        Assertions.assertEquals(bigDecimal.compareTo(new BigDecimal(3)), 0);
    }

    @Test
    void testRedo() {
        String[] args = {"1", "+", "2"};
        // 3
        calculatorService.calculate(args);
        args = new String[]{"1", "-", "2"};
        // -1
        calculatorService.calculate(args);
        args = new String[]{"1", "*", "2"};
        // 2
        calculatorService.calculate(args);
        // -1
        calculatorService.undo();
        // 3
        calculatorService.undo();
        // -1
        BigDecimal bigDecimal = calculatorService.redo();
        Assertions.assertEquals(bigDecimal.compareTo(new BigDecimal(-1)), 0);
        // 2
        bigDecimal = calculatorService.redo();
        Assertions.assertEquals(bigDecimal.compareTo(new BigDecimal(2)), 0);
    }
}