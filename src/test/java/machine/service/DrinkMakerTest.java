package machine.service;

import machine.domain.Drink;
import machine.domain.DrinkStatus;
import machine.domain.Stock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DrinkMakerTest {
    private Stock stock;
    private DrinkMaker drinkMaker;

    @BeforeEach
    public void setup(){
        this.stock = new Stock(10, 10, 10, 10);
        this.drinkMaker = new DrinkMaker(stock);
    }

    @Test
    void shouldPrepareDrinkWhenEnoughResourcesAreAvailable() {
        Drink drink = new Drink("Test Drink", 1, 1, 1, 4);
        DrinkStatus drinkStatus = this.drinkMaker.prepareDrink(drink);
        assertEquals(DrinkStatus.OKAY, drinkStatus);
        assertEquals(9, stock.getWaterQuantity());
        assertEquals(9, stock.getMilkQuantity());
        assertEquals(9, stock.getCoffeeQuantity());
        assertEquals(9, stock.getDisposableCups());
    }

    @Test
    void shouldReturnNotEnoughWaterWhenWaterIsInsufficient() {
        Drink drink = new Drink("Test Drink", 1000, 1, 1, 4);
        DrinkStatus drinkStatus = this.drinkMaker.prepareDrink(drink);
        assertEquals(DrinkStatus.NOT_ENOUGH_WATER, drinkStatus);
        assertEquals(10, stock.getWaterQuantity());
        assertEquals(10, stock.getMilkQuantity());
        assertEquals(10, stock.getCoffeeQuantity());
        assertEquals(10, stock.getDisposableCups());
    }

    @Test
    void shouldReturnNotEnoughMilkWhenMilkIsInsufficient() {
        Drink drink = new Drink("Test Drink", 1, 1000, 1, 4);
        DrinkStatus drinkStatus = this.drinkMaker.prepareDrink(drink);
        assertEquals(DrinkStatus.NOT_ENOUGH_MILK, drinkStatus);
        assertEquals(10, stock.getWaterQuantity());
        assertEquals(10, stock.getMilkQuantity());
        assertEquals(10, stock.getCoffeeQuantity());
        assertEquals(10, stock.getDisposableCups());
    }

    @Test
    void shouldReturnNotEnoughCoffeeWhenCoffeeIsInsufficient() {
        Drink drink = new Drink("Test Drink", 1, 1, 1000, 4);
        DrinkStatus drinkStatus = this.drinkMaker.prepareDrink(drink);
        assertEquals(DrinkStatus.NOT_ENOUGH_COFFEE, drinkStatus);
        assertEquals(10, stock.getWaterQuantity());
        assertEquals(10, stock.getMilkQuantity());
        assertEquals(10, stock.getCoffeeQuantity());
        assertEquals(10, stock.getDisposableCups());
    }

    @Test
    void shouldReturnNoCupsWhenDisposableCupsIsInsufficient() {
        this.stock = new Stock(1000, 1000, 1000, 0);
        this.drinkMaker = new DrinkMaker(this.stock);
        Drink drink = new Drink("Test Drink", 1, 1, 1, 4);
        DrinkStatus drinkStatus = this.drinkMaker.prepareDrink(drink);
        assertEquals(DrinkStatus.NO_CUPS, drinkStatus);
        assertEquals(1000, stock.getWaterQuantity());
        assertEquals(1000, stock.getMilkQuantity());
        assertEquals(1000, stock.getCoffeeQuantity());
        assertEquals(0, stock.getDisposableCups());
    }

}
