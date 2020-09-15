package org.homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class MiniCalculator {
    public static void main(String[] args) throws IOException {
        List<String> arrayList = new ArrayList<>();

        System.out.println("Введите первое число");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String number1 = reader.readLine();
        System.out.println("Введите второе число ");
        String number2 = reader.readLine();
        System.out.println("Введите операцию");
        String operation = reader.readLine();

        arrayList.add(number1);
        arrayList.add(operation);
        arrayList.add(number2);

        printResult(arrayList);
    }


    public static double calculate(List<String> expression) {
        double operand1 = Double.parseDouble(expression.get(0));
        double operand2 = Double.parseDouble(expression.get(2));

        if (expression.get(1).equals("+")) {
            return operand1 + operand2;
        } else if (expression.get(1).equals("-")) {
            return operand1 - operand2;
        } else if (expression.get(1).equals("*")) {
            return operand1 * operand2;
        } else if (expression.get(1).equals("/") && operand2 != 0.0) {
            return operand1 / operand2;
        } else {
            System.out.println("На ноль делить нельзя");
            return 0;
        }
    }



    public static void printResult(List<String> expression) {
        double result = calculate(expression);
        System.out.println(expression.get(0) + expression.get(1) + expression.get(2) + " = " + result);
    }


}