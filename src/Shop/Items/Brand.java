package Shop.Items;

public class Brand {
    String name;
    int Rating;

    public Brand(String name, int rating) {
        this.name = name;
        Rating = rating;
    }

    @Override
    public String toString() {
        return name;
    }
}
