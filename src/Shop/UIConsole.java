package Shop;

import Shop.Items.Item;

import java.util.Scanner;


//Все общение с пользователем вынесено в класс UIConsole (Single-responsibility principle)
public class UIConsole implements UI {


    //Выносим числа в поля в виде констант (magic)
    public final int SIZEOFMAINMENU = 4;
    public final int AMOUNTACTITEM = 2;
    public final int AMOUNTACTCART = 2;
    Customer customer;

    //Метод getUserChoise стандартизирует получение ответа от пользователя и позволяет не обрабатывать каждый раз
    //некорректный пользовательский ввод (DRY)

    public int getUserChoise(int amount, String message) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(message);
        int in;
        while (true) {
            in = scanner.nextInt();
            if (in >= 0 && in <= amount) {
                return in;
            }
            System.out.println("Введите число от 0 до " + amount);

        }
    }

    public boolean auth() {

        Scanner scanner = new Scanner(System.in);
        Shop shop = Shop.getShop();
        boolean authOk = false;
        while (true) {

            System.out.println("Введите логин(email):");
            String email = scanner.nextLine();
            System.out.println("Введите пароль:");
            String pass = scanner.nextLine();


            customer = shop.login(email, pass);
            if (customer == null) {
                System.out.println("Неверная пара логин - пароль, попробуйте еще раз");
                continue;
            }


            System.out.println("Вы успешно вошли в систему, " + customer.name);

            return true;


        }

    }

    public int mainMenu() {

        System.out.println("Выберите интересующий раздел:");
        System.out.println("1. Показать каталог товаров");
        System.out.println("2. Показать историю заказов");
        System.out.println("3. Показать корзину");
        System.out.println("4. Показать избранное");

        int in = getUserChoise(SIZEOFMAINMENU, "Выберите раздел или введите 0 для выхода");


        return in;

    }

    @Override
    public void showAllItems() {
        Shop shop = Shop.getShop();
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < shop.items.size(); i++) {
            System.out.println(i + 1 + ". " + shop.items.get(i));
        }

        int itemNo = getUserChoise(shop.items.size(),
                "Введите номер товара или 0 для выхода в главное меню.");


        if (itemNo == 0) {
            return;
        }

        System.out.println("1. Добавить в корзину");
        System.out.println("2. Добавить в избранное");
        int next = getUserChoise(2, "Выберите действие или введите 0 для выхода");
        if (next == 1) {
            int amount = getUserChoise(shop.MAXADDINCART, "Введите до " + shop.MAXADDINCART + " товаров:");
            customer.cart.addItem(shop.items.get(itemNo - 1), amount);
            return;
        }
        if (next == 2) {
            shop.items.get(itemNo).addFavorites(customer);
            customer.addFavItem(shop.items.get(itemNo));
            return;
        }


    }

    @Override
    public void showCart() {
        if (customer.cart.isEmpty()) {
            System.out.println("Ваша корзина пуста");
            return;
        }
        System.out.println("Ваша корзина:");
        int i = 0;
        for (Item item : customer.cart.content.keySet()
        ) {
            i++;
            System.out.println(i + ". " + item + customer.cart.content.get(item) + " шт.");

        }
        System.out.println("В корзине товаров на сумму: " + customer.cart.getTotal());


        System.out.println("1. Сделать заказ");
        System.out.println("2. Очистить корзину");
        int in = getUserChoise(AMOUNTACTCART, "Выберите действие или введите 0 для выхода в меню");
        if (in == 0) {
            return;
        }
        if (in == 2) {
            customer.cart.clear();
            showCart();
            return;
        }
        if (in == 1) {
            customer.cart.makeOrder();
            System.out.println("Заказ создан");

        }


    }

    @Override
    public void showOrderHistory() {
        if (customer.orders.size() == 0) {
            System.out.println("Нет заказов");
            return;
        }
        System.out.println("Ваши заказы:");

        for (int i = 0; i < customer.orders.size(); i++) {
            System.out.println(i + 1 + ". " + "Заказ от " + customer.orders.get(i).date + " на сумму " + customer.orders.get(i).getTotal());

        }


    }

    @Override
    public void showFavs() {

        if (customer.favItems.isEmpty()) {
            System.out.println("Вы пока ничего не добавили в избранное");
            return;
        }
        System.out.println("Ваш список:");
        int i = 0;
        for (Item item : customer.favItems) {
            i++;
            System.out.println(i + ". " + item);

        }


        int itemNo = getUserChoise(customer.favItems.size(), "Выберите товар или введите 0 для выхода");
        if (itemNo == 0) {
            return;
        }
        System.out.println("1. Удалить товар из избранного");
        System.out.println("2. Добавить товар в корзину");

        int next = getUserChoise(AMOUNTACTITEM, "Выберите действие или введите 0 для выхода");
        if (next == 0) {
            return;
        }
        Shop shop = Shop.getShop();

        if (next == 1) {
            customer.delFavItem(shop.items.get(itemNo));
            System.out.println("Товар удален из избранного");
            return;
        }


        if (next == 2) {
            int amount = getUserChoise(shop.MAXADDINCART, "Введите до " + shop.MAXADDINCART + " товаров:");
            customer.cart.addItem(shop.items.get(itemNo - 1), amount);
            return;
        }


    }


}
