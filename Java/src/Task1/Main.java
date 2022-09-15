package Task1;

import Task1.box.Box;


public class Main {

    public static void main(String[] args) {
        Box box = new Box();
        box.create();

        /*не стал использовать скане и прочий ввод для экономии времени...
        очень мало сна  =)
         */

        box.deleteMinWeight(670);  //При проверки только по весу
        // box.deleteMinPrice(500, 600);  //При проверки  по цене и весу

        box.getInfoSweetness();
        box.printPriceBox();
        box.printWeightBox();
    }
}
