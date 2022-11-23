package Shop;

import Shop.Items.Item;

import java.util.List;
import java.util.SortedMap;
import java.util.concurrent.Callable;

public class NotificationImpl implements Notification {
    static Notification notification;


    @Override
    public void discountNotification(Item item, List<Customer> subs) {

        for (Customer customer : subs) {
            System.out.println(customer.name + ", цена на " + item.getName() + " снижена");
        }

    }


    public static Notification getNotificator() {
        if (notification == null) {
            notification = new NotificationImpl();
        }
        return notification;

    }


}
