package org.homework;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class CollectionsAndClasses {
    /*
    Работа с файлами и коллекциями и объектами Цель: получить основные навыки вычитки данных из файла, добавление данных в коллекции и манипуляции с последними
Дано: Файл с данными data.txt с данными по типу csv.
Разделителем является запятая
Нужно:
1. Вычитать файл в коллекцию вида Map<Integer, User>.
Реализовать функцию Map<Integer, User> getDataFromFile(File dataFile)
2. Реализовать функцию поиска по id в Map.
User getDataById(Map<Integer, String> mapData, Integer id)
3. Реализовать функцию подсчета вхождения одинаковый фамилий
int getGetNumberOfOccurrences(Map<Integer, User> mapData, String lastName)
4. Реализовать функцию проверки пользователей у которых возраст более чем age.
List<User> getUsersAgeMoreThen(Map<Integer, User>, int age)
5. Реализовать функцию проверки пользователей, которая выявляет полных тёзок. На выходе должна быть коллекция вида Map<String, List<Integer>>,
где String - Имя и фамилия пользователя, List<Integer>> - коллекция айдишников
Map<String, List<Integer>> findEqualUsers(Map<Integer,User> users)

 User - это внутренний статический класс у которого есть такие поля:
 firstName - строка
lastName - строка
age - целое

должны быть стандартные геттеры и сеттеры должен быть конструктор, equals
    * */

    public static void main(String[] args) {

        String filePath = "/Users/izahorodniy/IdeaProjects/QA_Automation_Course_Brit_Sergey/src/main/resources/data1.txt";
        Map<Integer, User> map = getDataFromFile(new File(filePath));

        System.out.println(getDataById(map, 8965));
        System.out.println(getGetNumberOfOccurrences(map, "Ivanov"));
        System.out.println(getUsersAgeMoreThen(map, 39));
        System.out.println(findEqualUsers(map).toString());
    }


    public static Map<Integer, User> getDataFromFile(File dataFile) {
        Map<Integer, User> mapData = new HashMap<>();
        Scanner scanner;

        {
            try {
                scanner = new Scanner(dataFile);
                while (scanner.hasNextLine()) {
                    String lineStr = scanner.nextLine();
                    String[] arrayStr = lineStr.split(",");
                    User user = new User(arrayStr[1], arrayStr[2], Integer.parseInt(arrayStr[3]));
                    mapData.put(Integer.parseInt(arrayStr[0]), user);
                }
                scanner.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        return mapData;
    }


    public static User getDataById(Map<Integer, User> mapData, Integer id) {
        User user = null;
        for (Map.Entry<Integer, User> entry : mapData.entrySet()) {
            if (entry.getKey().equals(id))
                user = entry.getValue();
        }
        return user;
    }


    public static int getGetNumberOfOccurrences(Map<Integer, User> mapData, String lastName) {
        int count = 0;
        for (Map.Entry<Integer, User> entrySet : mapData.entrySet()) {
            String value = entrySet.getValue().getFirstName();
            if (value.equals(lastName))
                count++;
        }
        return count;
    }

    public static List<User> getUsersAgeMoreThen(Map<Integer, User> map, int age) {
        List<User> resultList = new ArrayList<>();

        for (Map.Entry<Integer, User> entrySet : map.entrySet()) {
            int userAge = entrySet.getValue().getAge();
            if (userAge > age)
                resultList.add(entrySet.getValue());
        }
        return resultList;
    }

    public static Map<String, List<Integer>> findEqualUsers(Map<Integer, User> users) {
        Map<String, List<Integer>> resultMap = new HashMap<>();

        for (Map.Entry<Integer, User> entrySet : users.entrySet()) {
            List<Integer> list = new ArrayList<>();

            for (Map.Entry<Integer, User> entrySet2 : users.entrySet()) {
                if (entrySet.getValue().equals(entrySet2.getValue())) {
                    list.add(entrySet2.getKey());
                }
            }

            String fullName = entrySet.getValue().getFirstName() + " " + entrySet.getValue().getLastName();
            if (list.size() > 1)
                resultMap.put(fullName, list);
        }

        return resultMap;
    }


    public static class User {
        private String firstName;
        private String lastName;
        private int age;

        public User(String firstName, String lastName, int age) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
        }

        public String getFirstName() {
            return firstName;
        }

        public User setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public String getLastName() {
            return lastName;
        }

        public User setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public int getAge() {
            return age;
        }

        public User setAge(int age) {
            this.age = age;
            return this;
        }

        public boolean equals(User usr) {
            if (this.firstName.equals(usr.firstName) && this.lastName.equals(usr.lastName))
                return true;
            else return false;
        }
    }
}
