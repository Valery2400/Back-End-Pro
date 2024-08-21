import java.util.ArrayList;
import java.util.List;

public class BeerFridge {
    private List<String> beers;

    public BeerFridge() {
        this.beers = new ArrayList<>();
}
    // Метод для добавления пива в холодильник
    public void stockBeer(String beer) {
        beers.add(beer);
        System.out.println(beer + " добавлено в холодильник.");
    }

    // Метод для получения пива из холодильника
    public String getBeer() {
        if (beers.isEmpty()) {
            return "Пива нет, сходите в магазин!";
        } else {
            String beer = beers.remove(beers.size() - 1);
            System.out.println("Выдано пиво: " + beer);
            return beer;
        }
    }

    // Метод для проверки количества пива в холодильнике
    public int getBeerCount() {
        return beers.size();
    }
}

