package Task2;

import java.io.*;

import static Task2.FileOperations.*;

public class Main {


    public static void main(String[] args) throws IOException {

        //Прописываем путь файла
        String text = filePath();
        System.out.println();

       //подсчитываем количество слов и количество повторений. И выводим.
        wordCounter(wordSplit(text));
        System.out.println();

        // Сортировка и вывод слов
        printSortWord(wordSplit(text));



    }
}
