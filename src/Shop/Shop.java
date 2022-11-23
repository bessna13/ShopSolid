package Shop;

import Shop.Items.Item;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class Shop {
    public final int MAXADDINCART = 10;

    Map<String, Customer> customers = new HashMap<>();
    ArrayList<Item> items = new ArrayList<>();

    static Shop shop;


    public static Shop getShop() {
        if (shop == null) {
            shop = new Shop();
        }
        return shop;
    }


    public void newCustomer(String name, String pass, String email) {

        customers.put(email, new Customer(name, pass, email));

    }

    public Shop newItem(Item item) {

        items.add(item);

        return this;
    }


    public Customer login(String email, String pass) {

        if (customers.containsKey(email)) {
            if (customers.get(email).pass.equals(pass)) {

                return shop.customers.get(email);

            }
        }


        return null;
    }

}



