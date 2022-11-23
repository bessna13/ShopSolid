package Shop;

public interface UI {
    //Интерфейс взаимодействия с пользователем у нас сейчас консольный, но все может измениться,
    //поэтому в Main мы используем интерфейс UI, а не класс UIConsole (Dependency inversion principle)
    public boolean auth();

    public int mainMenu();

    public void showAllItems();

    public void showCart();

    public void showOrderHistory();

    public void showFavs();


}
