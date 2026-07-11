package machine.domain;

import java.util.ArrayList;
import java.util.List;

public class DrinkCatalog {
    private final List<Drink> drinks;

    public DrinkCatalog() {
        this.drinks = new ArrayList<>();
        Drink espresso = new Drink("Espresso", 250, 0, 16, 4);
        Drink latte = new Drink("Latte", 250, 75, 20, 7);
        Drink cappuccino = new Drink("Cappuccino", 200, 100, 12, 6);
        drinks.add(espresso);
        drinks.add(latte);
        drinks.add(cappuccino);
    }

    public boolean isAvailable(int choiceDrink) {
        return choiceDrink < drinks.size() && choiceDrink >= 0;
    }

    public Drink getDrink(int choiceDrink) {
        return drinks.get(choiceDrink);
    }
}
