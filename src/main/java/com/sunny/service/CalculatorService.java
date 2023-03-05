package com.sunny.service;

import java.math.BigDecimal;

/**
 * @description: 计算器服务类
 * @author: Sunny
 * @date: 2023/3/3
 */
public interface CalculatorService {

    /**
     * 计算
     * @param args
     * @return
     */
    BigDecimal calculate(String[] args);

    /**
     * 后退
     * @return
     */
    BigDecimal undo();

    /**
     * 重算
     * @return
     */
    BigDecimal redo();
}
