package Shop.Items;

import Shop.Customer;
import Shop.NotificationImpl;

import java.util.ArrayList;
import java.util.List;


//Класс Item абстрактный и содержит необходимый минимум сведений о товаре, любой новый тип товара интегрируется
//через наслелование от Item (Open-closed principle)
public abstract class Item {

    String name;
    Color color;
    Category category;
    Brand brand;

    double price;
    List<Customer> subs = new ArrayList<>();


    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void addFavorites(Customer customer) {
        subs.add(customer);
    }

    public void setPrice(double price) {
        if (price < this.price) {
            NotificationImpl.getNotificator().discountNotification(this, subs);
        }
        this.price = price;
    }


}
