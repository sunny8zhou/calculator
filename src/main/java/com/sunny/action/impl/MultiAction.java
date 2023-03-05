package com.sunny.action.impl;

import com.sunny.action.AbstractAction;
import com.sunny.action.ActionType;

import java.math.BigDecimal;
import java.util.Optional;

/**
 * @description: 乘法实现
 * @author: Sunny
 * @date: 2023/3/3
 */
public class MultiAction extends AbstractAction {

    @Override
    public ActionType type() {
        return ActionType.MULTI;
    }

    @Override
    public Optional<BigDecimal> doExecute(BigDecimal a, BigDecimal b) {
        return Optional.of(a.multiply(b));
    }
}
