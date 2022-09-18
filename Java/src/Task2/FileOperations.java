package Task2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class FileOperations {

    /*
    Принятие пути файла,пример:
    D:\IBS\GIT\Practical\Java\File_task2.txt
    После возвращает его в виде String
     */

    public static String filePath() throws IOException {
        String path = "";
        System.out.println("Введите путь файла: ");

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            path = reader.readLine();
        } catch (Exception e) {
            System.out.println(e);
        }

        StringBuilder text = new StringBuilder();
        byte[] buffer = new byte[1000];

        try (FileInputStream fileInputStream = new FileInputStream(path)) {

            while (fileInputStream.available() > 0) {
                fileInputStream.read(buffer);
                String bufferString = new String(buffer, "UTF-8");
                text.append(bufferString);
            }

        } catch (Exception e) {
            System.out.println(e);

        }

        return text.toString();
    }

    /*
    Приобразования текста в массив
     */

    public static String[] wordSplit(String text) {

        text = text.replaceAll("[^a-zA-Zа-яА-Я]", " ").replaceAll("\\s+", " ");

        return text.split(" ");
    }


    /*
    Метод для подсчета количесва слов и вывода повторяемости
     */

    public static void wordCounter(String[] textFile) {
        Map<String, Integer> map = new HashMap<>();
        int max = 0;
        int count;
        List<String> list = new ArrayList<>();

        for (int i = 0; i < textFile.length; i++) {
            count = 1;
            if (map.containsKey(textFile[i])) {
                count = map.get(textFile[i]) + 1;
            }
            map.put(textFile[i], count);
            if (count > max) {
                max = count;
                list.clear();
                list.add(textFile[i]);

            } else if (count == max) {
                list.add(textFile[i]);
            }
        }

        System.out.println("Все слова и количество повторений:");
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }

        System.out.println();

        System.out.println("Самые частые слова:");
        for (String s : list) {
            System.out.println(s + " повторений = " + max);
        }


    }

    //Вывод в отсортированном порядке
    public static void printSortWord(String[] text) {
        Arrays.sort(text);
        System.out.println("Список всех слов:");
        for (String s : text) {
            System.out.println(s);
        }
    }


}
