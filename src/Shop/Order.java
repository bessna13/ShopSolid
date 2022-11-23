package Shop;

import Shop.Items.Item;

import java.util.Date;
import java.util.Map;

public class Order extends OrderContent {

    Date date;

    public Order(Customer customer, Map<Item, Integer> content) {
        this.content = content;
        date = new Date();

    }
}
