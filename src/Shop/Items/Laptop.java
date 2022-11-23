package Shop.Items;

public class Laptop extends Item {
    Double displaySize;
    String os;
    String cp;

    public Laptop(String name, Color color, Brand brand, int price, double displaySize, String os, String cp) {
        this.name = name;
        this.color = color;
        this.brand = brand;
        this.price = price;
        this.category = Category.LAPTOP;
        this.displaySize = displaySize;
        this.os = os;
        this.cp = cp;


    }

    @Override
    public String toString() {
        return this.category + " " + brand + " " + name + " " + displaySize + " " + cp + " " + os + " " + color + " " + price;
    }


}
