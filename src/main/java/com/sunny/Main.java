package com.sunny;

import com.sunny.service.impl.CalculatorServiceImpl;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * @description:
 * @author: Sunny
 * @date: 2023/3/4
 */
public class Main {

    public static void main(String[] args) {
        CalculatorServiceImpl calculatorService = new CalculatorServiceImpl();
        boolean exit = false;
        System.out.println("start");
        while (!exit) {
            System.out.println("请输入参数，以空格相隔：");
            Scanner scanner = new Scanner(System.in);
            String s = scanner.nextLine();
            switch (s) {
                case "exit":
                    exit = true;
                    break;
                case "undo":
                    BigDecimal undo = calculatorService.undo();
                    System.out.println(undo);
                    break;
                case "redo":
                    BigDecimal redo = calculatorService.redo();
                    System.out.println(redo);
                    break;
                default:
                    BigDecimal bigDecimal = calculatorService.calculate(s.split(" "));
                    System.out.println(bigDecimal);
                    break;
            }
        }
        System.out.println("end");
    }

}
