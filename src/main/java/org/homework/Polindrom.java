package org.homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Polindrom {
    public static void main(String[] args) throws IOException {
        System.out.println("Введите числа через запятую:");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String inputString = reader.readLine();
        String[] inputArray = inputString.split("");

        ArrayList<String> arrayOfInputNums = new ArrayList<>(Arrays.asList(inputArray));

        boolean isPolindrom = true;

        for (int i = 0; i < (arrayOfInputNums.size() / 2); i++) {
            if (arrayOfInputNums.get(i).equals(arrayOfInputNums.get(arrayOfInputNums.size() - i - 1))) {
                continue;
            } else {
                isPolindrom = false;
                break;
            }
        }

        if (isPolindrom) System.out.println("Вы ввели полиндром");
        else System.out.println("Массив не является полиндромом");
    }
}
