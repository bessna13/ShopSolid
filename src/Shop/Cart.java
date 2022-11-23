package Shop;

import Shop.Items.Item;

import java.util.HashMap;
import java.util.Map;

public class Cart extends OrderContent {

    public Cart(Customer customer) {
        this.customer = customer;
    }

    void makeOrder() {


        Map<Item, Integer> orderContent = new HashMap<>();
        for (Item item : content.keySet()
        ) {
            orderContent.put(item, content.get(item));

        }
        customer.orders.add(
                new Order(customer, orderContent)
        );
        clear();

    }

    public boolean isEmpty() {

        return content.isEmpty();
    }

    public void clear() {
        content.clear();
    }


}
