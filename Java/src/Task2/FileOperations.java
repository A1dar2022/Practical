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
}