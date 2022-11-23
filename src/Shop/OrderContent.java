package Shop;

import Shop.Items.Item;

import java.util.HashMap;
import java.util.Map;



//Класс OrderContent является родительским для Cart и Order, ведь по сути они всего лишь списки товаров с дополнительными
//или видоизмененными функциями
public abstract class OrderContent {

    Customer customer;

    Map<Item, Integer> content = new HashMap<>();

    public void addItem(Item item, int amount) {
        if (content.containsKey(item)) {


            content.put(item, content.get(item) + amount);

        } else {
            content.put(item, amount);
        }

    }

    public void delItem(Item item) {
        if (content.containsKey(item)) {
            content.remove(item);
        }

    }

    public double getTotal() {
        double total = 0;
        for (Item item : content.keySet()) {
            double price1 = item.getPrice();
            int am = content.get(item);


            total += price1 * am;
        }
        return total;
    }


}
