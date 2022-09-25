package show;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        String fileName = "src/main/resources/Shares.json";

        Companyes obj = Operations.parseJson(fileName);
        List<InfoCompany> companyes;

        if (obj != null){
            companyes = obj.getInfoCompany();

            Operations.levelOne(companyes);

            Operations.levelTwo(companyes);

            Operations.LevelThree(companyes);

            Operations.levelFour(companyes);
        }
    }

   }