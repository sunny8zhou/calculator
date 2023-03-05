package com.sunny.action.impl;

import com.sunny.action.AbstractAction;
import com.sunny.action.ActionType;

import java.math.BigDecimal;
import java.util.Optional;

/**
 * @description: 除法实现
 * @author: Sunny
 * @date: 2023/3/3
 */
public class DivAction extends AbstractAction {

    @Override
    public ActionType type() {
        return ActionType.DIV;
    }

    @Override
    public Optional<BigDecimal> doExecute(BigDecimal a, BigDecimal b) {
        if (b.equals(BigDecimal.ZERO)) {
            return Optional.empty();
        }
        return Optional.of(a.divide(b));
    }
}
