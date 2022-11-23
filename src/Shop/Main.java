package Shop;

import Shop.Items.Brand;
import Shop.Items.Color;
import Shop.Items.Laptop;
import Shop.Items.TV;

public class Main {
    public static void main(String[] args) {
        Shop shop = Shop.getShop();
        shop.newCustomer("Марк", "123", "123");
        shop.newCustomer("Иван", "111", "111");
        shop.newCustomer("Алина", "222", "222");
        shop.newCustomer("Алексей", "333", "333");


        Brand lg = new Brand("LG", 5);
        Brand samsung = new Brand("Samsung", 4);
        Brand asus = new Brand("Asus", 4);

        shop.newItem(new TV("LG4000", Color.RED, lg, 49999, 55))
                .newItem(new TV("SM65", Color.BLACK, samsung, 99900, 65))
                .newItem(new Laptop("A3000", Color.RED, asus, 39999, 14, "Windows 11", "Intel i7"));


        
        shop.customers.get("111").addFavItem(shop.items.get(0));
        shop.items.get(0).setPrice(39999);


        UI ui = new UIConsole();

        boolean isLogin = ui.auth();

        if (isLogin) {

            while (true) {
                int next = ui.mainMenu();
                switch (next) {
                    case (1): {
                        ui.showAllItems();
                        break;
                    }
                    case (2): {
                        ui.showOrderHistory();
                        break;
                    }
                    case (3): {
                        ui.showCart();
                        break;
                    }
                    case (4): {
                        ui.showFavs();
                        break;
                    }
                    case (0): {

                        return;
                    }


                }


            }


        }


    }
}