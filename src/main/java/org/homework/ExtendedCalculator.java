package org.homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ExtendedCalculator {
    /*Написать программу которая реализует минимальный функционал калькулятора, используя коллекцию, перечисления

    Программа должна вызывать публичную функцию calculate, которая берет как параметр List<String> и возвращает любое число,
    где List<String> - коллекция вида: любое число, операция, любое число. например "5","PLUS","5" операция - это строковое представление enum Operations.

    Функция должна возвращать любое число либо null.
            null возвращается тогда и только тогда, когда возникает исключительная ситуация.

    Использовать switch.
    Договоримся использовать строчные представления операции ТОЛЬКО из enum

    String prepareResults(List<String> inputData, Float result), функция которая подготавливает строку для вывода,
    где List<String> inputData - исходная коллекция, result - результат вычесления функция должна возвращать строку вида 5+5=10

    При этом возможна строка вида 5+-5=0.0 Так же нужна отдельная функция по выводу результата на экран.


    enum Operations - это перечисление из четырех операций*/

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



    public static float calculate(List<String> expression) {
        Float result = null;
        Operations operation = Operations.valueOf(expression.get(1).toUpperCase());

        switch (operation) {
            case PLUS:
                result = Float.parseFloat(expression.get(0)) + Float.parseFloat(expression.get(2));
                break;
            case MINUS:
                result = Float.parseFloat(expression.get(0)) - Float.parseFloat(expression.get(2));
                break;
            case MULTIPLY:
                result = Float.parseFloat(expression.get(0)) * Float.parseFloat(expression.get(2));
                break;
            case DIVIDE:
                if (Float.parseFloat(expression.get(2)) != 0) {
                    result = Float.parseFloat(expression.get(0)) / Float.parseFloat(expression.get(2));
                }
                break;
        }
        return result;
    }

    public static void printResult(List<String> expression) {
        float result = calculate(expression);
        System.out.println(prepareResults(expression, result));
    }

    public static String prepareResults(List<String> inputData, Float result) {
        String operationStr = "";
        Operations operation = Operations.valueOf(inputData.get(1).toUpperCase());

        switch (operation) {
            case PLUS:
                operationStr = "+";
                break;
            case MINUS:
                operationStr = "-";
                break;
            case MULTIPLY:
                operationStr = "*";
                break;
            case DIVIDE:
                operationStr = "/";
                break;
        }
        return inputData.get(0) + operationStr + inputData.get(2) + " = " + result;
    }


    public enum Operations {
        PLUS,
        MINUS,
        DIVIDE,
        MULTIPLY
    }
}