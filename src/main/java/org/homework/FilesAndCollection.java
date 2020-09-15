package org.homework;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FilesAndCollection<line> {
    /*
    Работа с файлами и коллекциями
    Цель: получить основные навыки вычитки данных из файла, добавление данных в коллекции и манипуляции с последними
    Дано: Файл с данными data.txt с данными по типу csv. Разделителем является запятая
    Нужно:
    1. Вычитать файл в коллекцию вида Map<Integer, String>.
    Реализовать функцию Map<Integer, String> getDataFromFile(File dataFile)
    2. Реализовать функцию поиска по id в Map.
            String getDataById(Map<Integer, String> mapData, Integer id)
    3. Реализовать функцию подсчета вхождения одинаковый фамилий
    int getGetNumberOfOccurrences(Map<Integer, String> mapData, String lastName)

    Note! Иванов И. и Иванов В. - это будем считать 2 вхождения. Считаем именно фамилии.*/

    public static void main(String[] args) {

        String filePath = "/Users/izahorodniy/IdeaProjects/QA_Automation_Course_Brit_Sergey/src/main/resources/data.txt";
        Map<Integer, String> map = getDataFromFile(new File(filePath));

        System.out.println(getDataById(map, 8965));
        System.out.println(getGetNumberOfOccurrences(map,  "Ivanov"));
    }


    public static Map<Integer, String> getDataFromFile(File dataFile) {
        Map<Integer, String> mapData = new HashMap<>();
        Scanner scanner;

        {
            try {
                scanner = new Scanner(dataFile);
                while (scanner.hasNextLine()) {
                    String lineStr = scanner.nextLine();
                    String[] arrayStr = lineStr.split(",");
                    mapData.put(Integer.parseInt(arrayStr[0]), arrayStr[1]);
                }
                scanner.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        return mapData;
    }


    public static String getDataById(Map<Integer, String> mapData, Integer id) {
        return mapData.get(id);
    }

    public static int getGetNumberOfOccurrences(Map<Integer, String> mapData, String lastName) {
        int count = 0;
        for (Map.Entry<Integer, String> entrySet : mapData.entrySet()) {
            String value = entrySet.getValue().split(" ")[0];
            if (value.equals(lastName))
                count++;
        }

        return count;
    }
}
