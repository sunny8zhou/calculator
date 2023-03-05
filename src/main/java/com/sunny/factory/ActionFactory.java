package com.sunny.factory;

import com.sunny.action.Action;
import com.sunny.action.impl.AddAction;
import com.sunny.action.impl.DivAction;
import com.sunny.action.impl.MultiAction;
import com.sunny.action.impl.SubAction;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: 计算实现类工厂
 * @author: Sunny
 * @date: 2023/3/4
 */
public class ActionFactory {
    private static final Map<String, Action> ACTION_MAP = new HashMap<>();

    static {
        ACTION_MAP.put("+", new AddAction());
        ACTION_MAP.put("-", new SubAction());
        ACTION_MAP.put("*", new MultiAction());
        ACTION_MAP.put("/", new DivAction());
    }

    private ActionFactory() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * 获取实现类
     * @param sign
     * @return
     */
    public static Action getAction(String sign) {
        return ACTION_MAP.get(sign);
    }
}
