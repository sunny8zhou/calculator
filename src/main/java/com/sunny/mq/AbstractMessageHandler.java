package com.sunny.mq;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @description:
 * @author: Sunny
 * @date: 2023/3/3
 */
public abstract class AbstractMessageHandler {

    private static final BlockingQueue QUEUE = new ArrayBlockingQueue<>(10);
}
