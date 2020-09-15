package org.homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;


public class PolindromString {
    public static void main(String[] args) throws IOException {
        boolean ifCorrectString;
        boolean isPolindrom = true;
        String str;

        do {
            System.out.println("Введите строку:");
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            str = reader.readLine();
            ifCorrectString = checkInputString(str);
        } while (ifCorrectString == false);

        if (ifCorrectString) {
            String[] convertedSts = str.replaceAll(" ", "").toLowerCase().split("");
            ArrayList<String> arrayStr = new ArrayList<>(Arrays.asList(convertedSts));

            for (int i = 0; i < (arrayStr.size() / 2); i++) {
                String letterFromBegin = arrayStr.get(i);
                String letterFromEnd = arrayStr.get(arrayStr.size() - i - 1);

                if (letterFromBegin.equals(letterFromEnd)) {
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


    public static boolean checkInputString(String inputString) {
        if (inputString.equals("")) {
            System.out.println("Вы ввели пустой массив");
            return false;
        }
        return true;
    }
}

