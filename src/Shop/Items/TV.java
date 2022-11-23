package Shop.Items;

public class TV extends Item {

    int diag;

    public TV(String name, Color color, Brand brand, int price, int diag) {
        this.name = name;
        this.color = color;
        this.brand = brand;
        this.price = price;
        this.diag = diag;
        this.category = Category.TV;

    }

    @Override
    public String toString() {
        return this.category + " " + brand + " " + name + " " + diag + " " + color + " " + price;
    }
}
