package Shop;

import Shop.Items.Item;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Customer {
    String name, pass, email;

    int id;


    ArrayList<Order> orders = new ArrayList<>();
    Set<Item> favItems = new HashSet<>();

    Cart cart;

    public Customer(String name, String pass, String email) {


        this.name = name;
        this.pass = pass;
        this.email = email;
        this.cart = new Cart(this);
        ArrayList<Order> orders = new ArrayList<>();
        ArrayList<Item> favItems = new ArrayList<>();


    }

    public void addFavItem(Item item) {
        favItems.add(item);
        item.addFavorites(this);
    }

    public void delFavItem(Item item) {
        favItems.remove(item);
    }
}
