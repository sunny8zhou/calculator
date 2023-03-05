package com.sunny.service.impl;

import com.sunny.action.Action;
import com.sunny.factory.ActionFactory;
import com.sunny.service.CalculatorService;

import java.math.BigDecimal;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Optional;

/**
 * @description: 计算器服务实现类
 * @author: Sunny
 * @date: 2023/3/3
 */
public class CalculatorServiceImpl implements CalculatorService {

    private static final Deque<BigDecimal> UNDO_DEQUE = new ArrayDeque<>();
    private static final Deque<BigDecimal> REDO_DEQUE = new ArrayDeque<>();

    private static final int size = 3;
    private final int max = 10;

    @Override
    public BigDecimal calculate(String[] args) {
        if (args == null || args.length < size) {
            throw new RuntimeException("Need arguments");
        }
        Action action = ActionFactory.getAction(args[1]);
        if (action == null) {
            throw new RuntimeException("Invalid arguments");
        }
        Optional<BigDecimal> optional = action.execute(new BigDecimal(args[0]), new BigDecimal(args[2]));
        if (!optional.isPresent()) {
            throw new RuntimeException("Invalid arguments");
        }
        BigDecimal bigDecimal = optional.get();
        this.push(UNDO_DEQUE, bigDecimal);
        return bigDecimal;
    }

    @Override
    public BigDecimal undo() {
        if (UNDO_DEQUE.isEmpty()) {
            return BigDecimal.ZERO;
        }
        BigDecimal poll = UNDO_DEQUE.poll();
        this.push(REDO_DEQUE, poll);
        // 计算后当前结果在第1位，所以需要再peek一次
        return Optional.ofNullable(UNDO_DEQUE.peek()).orElse(BigDecimal.ZERO);
    }

    @Override
    public BigDecimal redo() {
        if (REDO_DEQUE.isEmpty()) {
            return BigDecimal.ZERO;
        }
        BigDecimal poll = REDO_DEQUE.poll();
        this.push(UNDO_DEQUE, poll);
        return poll;
    }

    /**
     * 插入栈方法
     * @param deque
     * @param b
     */
    private void push(Deque<BigDecimal> deque, BigDecimal b) {
        // FIFO淘汰策略，防止OOM
        if (deque.size() > this.max) {
            deque.removeLast();
        }
        deque.push(b);
    }
}
