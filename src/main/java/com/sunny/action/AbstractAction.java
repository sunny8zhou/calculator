package com.sunny.action;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.Optional;

/**
 * @description: 计算抽象类
 * @author: Sunny
 * @date: 2023/3/3
 */
public abstract class AbstractAction implements Action {

    /**
     * 核心逻辑
     * @param a
     * @param b
     * @return
     */
    protected abstract Optional<BigDecimal> doExecute(BigDecimal a, BigDecimal b);

    @Override
    public Optional<BigDecimal> execute(BigDecimal a, BigDecimal b) {
        if (Objects.isNull(a) || Objects.isNull(b)) {
            return Optional.empty();
        }
        return this.doExecute(a, b);
    }
}
