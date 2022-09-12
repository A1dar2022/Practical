package Task1;

public abstract class Sweetness {
 private String nameOfSweets;
 private int weight;
 private int price;
 private String uniqueParameter;

    public String getNameOfSweets() {
        return nameOfSweets;
    }

    public void setNameOfSweets(String nameOfSweets) {
        this.nameOfSweets = nameOfSweets;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getUniqueParameter() {
        return uniqueParameter;
    }

    public void setUniqueParameter(String uniqueParameter) {
        this.uniqueParameter = uniqueParameter;
    }

    public Sweetness(String nameOfSweets, int weight, int price, String uniqueParameter) {
        this.nameOfSweets = nameOfSweets;
        this.weight = weight;
        this.price = price;
        this.uniqueParameter = uniqueParameter;
    }

    private  String getInfo(){
        return "Сладость - " + nameOfSweets + ", уникальный параметр - " +
                 uniqueParameter + ", цена = " + price + " рублей, " +
                "вес = " + weight + "грамм";
    }
    
    public String toString(){
        return getInfo();
    }

}
