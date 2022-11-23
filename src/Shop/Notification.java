package Shop;

import Shop.Items.Item;

import java.util.List;


//Уведомления пользователей вынесены в отдельный интерфейс, чтобы не перегружать интерфейс UI,
//оставив там по сути только прямое взаимодействие с пользователем (Interface segregation principle)
public interface Notification {

    public void discountNotification(Item item, List<Customer> subs);


}
