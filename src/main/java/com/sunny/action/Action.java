package com.sunny.action;

import java.math.BigDecimal;
import java.util.Optional;

/**
 * @description: 计算协议
 * @author: Sunny
 * @date: 2023/3/3
 */
public interface Action {

    /**
     * 计算类型
     * @return
     */
    ActionType type();

    /**
     * 计算行为
     * @param a
     * @param b
     * @return
     */
    Optional<BigDecimal> execute(BigDecimal a, BigDecimal b);
}
