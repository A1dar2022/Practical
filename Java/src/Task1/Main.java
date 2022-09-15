package Task1;

import Task1.box.Box;


public class Main {

    public static void main(String[] args) {
        Box box = new Box();
        box.create();

        box.getInfoSweetness();
        System.out.println("");

        /*не стал использовать скане и прочий ввод для экономии времени...
        очень мало сна  =)
         */
        box.deleteMinWeight(670);  //При проверке только по весу
        // box.deleteMinPrice(500, 600);  //При проверке  по цене и весу
        box.getInfoSweetness();
        box.printPriceBox();
        box.printWeightBox();
    }
}
