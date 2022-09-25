package aidar.sad;

import java.util.List;

import static aidar.sad.Operations.*;

public class Main {



    public static void main(String[] args) {
        String fileName = "src/main/resources/Shares.json";

        Companyes obj = parseJson(fileName);
        List<InfoCompany> companies;

        if (obj != null){
            companies = obj.getInfoCompany();

            task1(companies);

            task2(companies);

            task3(companies);

            task4(companies);
        }
    }

   }