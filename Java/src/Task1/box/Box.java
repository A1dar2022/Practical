package Task1.box;

import Task1.Sweetness.*;

import java.util.ArrayList;

public class Box implements BoxOperations {

    public ArrayList<Sweetness> arraySweetness = new ArrayList<>();

    private int maxWeight = 700;
    private int maxPrice = 912;

    public void create() {
        addSweetness(new Candy());
        addSweetness(new Chocolate());
        addSweetness(new ChocoPie());
        addSweetness(new ChupaChups());
        addSweetness(new Kinder());
        addSweetness(new Lollipop());
    }

    //метод для удаления сладостей с минимальным весом
    public void deleteMinWeight(int requiredWeight) {
        Sweetness minWeightSweetness = null;

        while (requiredWeight < maxWeight) {
            int minWeight = 1000;
            for (Sweetness sweetness : arraySweetness) {
                if (sweetness.getWeight() <= minWeight) {
                    minWeightSweetness = sweetness;
                    minWeight = sweetness.getWeight();
                }
            }
            maxWeight -= minWeightSweetness.getWeight();
            arraySweetness.remove(minWeightSweetness);
        }
    }

    //метод для удаления по минимальной цена,  но при этом основным показателем условия является вес
    public void deleteMinPrice(int requiredWeight, int requiredPrice) {
        Sweetness minPriceSweetness = null;

        while (requiredWeight < maxWeight) {
            int minPrice = 1000;
            for (Sweetness sweetness : arraySweetness) {
                if (sweetness.getPrice() <= minPrice) {
                    minPriceSweetness = sweetness;
                    minPrice = sweetness.getPrice();
                }
            }
            maxWeight -= minPriceSweetness.getWeight();
            maxPrice -= minPriceSweetness.getPrice();
            arraySweetness.remove(minPriceSweetness);
        }
    }


    @Override
    public void addSweetness(Sweetness sweetness) {
        arraySweetness.add(sweetness);
    }

    @Override
    public void deleteSweetness(Sweetness sweetness) {
        arraySweetness.remove(sweetness);
    }

    @Override
    public void printWeightBox() {
        int weightBox = 0;
        for (Sweetness sweetness : arraySweetness
        ) {
            weightBox += sweetness.getWeight();
        }
        System.out.println("Вес коробки составляет: " + weightBox + " грамм");

    }

    @Override
    public void printPriceBox() {
        int priceBox = 0;
        for (Sweetness sweetness : arraySweetness
        ) {
            priceBox += sweetness.getPrice();
        }
        System.out.println("Стоимость коробки составляет: " + priceBox + " рублей");

    }

    @Override
    public void getInfoSweetness() {
        for (Sweetness sweetness : arraySweetness) {
            sweetness.getInfo();
        }

    }
}
