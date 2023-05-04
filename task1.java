/* 1) Реализуйте структуру телефонной книги с помощью HashMap, учитывая, что 1 человек 
может иметь несколько телефонов.
1.1). Дан список сотрудников: 
Иван Иванов,Светлана Петрова,Кристина Белова,Анна Мусина,Анна Крутова,Иван Юрин,
Петр Лыков,Павел Чернов,Петр Чернышов,Мария Федорова,Марина Светлова,Мария Савина,
Мария Рыкова,Марина Лугова,Анна Владимирова,Иван Мечников,Петр Петин,Иван Ежов.
Написать программу, которая найдёт и выведет повторяющиеся имена с количеством 
повторений. Отсортировать по убыванию популярности. */

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class task1 {
    public static void main(String[] args) {
        ex1();
    }

    public static void ex2(){
        String text = "Иван Иванов,Светлана Петрова,Кристина Белова,Анна Мусина,Анна Крутова,Иван Юрин,Петр Лыков,Павел Чернов,Петр Чернышов,Мария Федорова,Марина Светлова,Мария Савина,Мария Рыкова,Марина Лугова,Анна Владимирова,Иван Мечников,Петр Петин,Иван Ежов.";
        text = text.replaceAll("[-|–|—]|\\p{Punct}", " ");
        while (text.contains("  ")){
            text = text.replace("  ", " ");
        }

        String findWord = "";

        String[] arrayText = text.split(" ");
        Map<String, Integer> map = new HashMap<>();
        for (String currentWord : arrayText){
            if (!findWord.toLowerCase().equals(currentWord.toLowerCase())){
                continue;
            }

            int count = map.getOrDefault(findWord.toLowerCase(), 0);
            map.put(currentWord.toLowerCase(), ++count);
        }
    }

    public static void ex1(){
        String text = "Иван Иванов,Светлана Петрова,Кристина Белова,Анна Мусина,Анна Крутова,Иван Юрин,Петр Лыков,Павел Чернов,Петр Чернышов,Мария Федорова,Марина Светлова,Мария Савина,Мария Рыкова,Марина Лугова,Анна Владимирова,Иван Мечников,Петр Петин,Иван Ежов.";
        text = text.replaceAll("[-|–|—]|\\p{Punct}", " ");
        while (text.contains("  ")){
            text = text.replace("  ", " ");
        }
        String[] arrayText = text.split(" ");

        Map<String, Integer> map = getCountWords(arrayText);

        for(Map.Entry<String, Integer> entry : map.entrySet()){
            
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }

    public static Map<String, Integer> getCountWords(String[] array){
        Map<String, Integer> map = new HashMap<>();

        for (String current : array){
            int count = map.getOrDefault(current.toLowerCase(), 0);
            map.put(current.toLowerCase(), ++count);
        }

        return map;
    }
}

