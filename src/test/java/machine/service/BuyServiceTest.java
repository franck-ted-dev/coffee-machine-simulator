package machine.service;

import machine.domain.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BuyServiceTest {
    private BuyService buyService;
    private CashUnit  cashUnit;
    private Stock stock;
    private DrinkCatalog drinkCatalog;

    @BeforeEach
    public void setUp() {
        this.drinkCatalog = new DrinkCatalog();
        this.stock = new Stock(1000, 1000, 1000, 1000);
        DrinkMaker drinkMaker = new DrinkMaker(stock);
        this.cashUnit  = new CashUnit(0);
        this.buyService = new BuyService(drinkCatalog, drinkMaker, cashUnit);
    }

    @Test
    void shouldReturnInvalidDrinkWhenChoiceDoesNotExist() {
        int badChoice = 10;
        DrinkStatus drinkStatus = buyService.buyDrink(badChoice);
        assertEquals(DrinkStatus.INVALID_DRINK, drinkStatus);
        assertEquals(0, cashUnit.getBalance());
    }

    @Test
    void shouldReturnInvalidDrinkWhenChoiceIsNegative(){
        int badChoice = -1;
        DrinkStatus drinkStatus = buyService.buyDrink(badChoice);
        assertEquals(DrinkStatus.INVALID_DRINK, drinkStatus);
        assertEquals(0, cashUnit.getBalance());
    }

    @Test
    void shouldReturnInvalidDrinkWhenChoiceIsZero(){
        int badChoice = 0;
        DrinkStatus drinkStatus = buyService.buyDrink(badChoice);
        assertEquals(DrinkStatus.INVALID_DRINK, drinkStatus);
        assertEquals(0, cashUnit.getBalance());
    }

    @Test
    void shouldCollectMoneyWhenDrinkIsPrepared(){
        int goodChoice = 1;
        DrinkStatus drinkStatus = buyService.buyDrink(goodChoice);
        assertEquals(DrinkStatus.OKAY, drinkStatus);
        assertEquals(4, cashUnit.getBalance());
    }

    @Test
    void shouldNotCollectMoneyWhenDrinkIsNotPrepared(){
        this.stock = new Stock(0, 0, 0, 0);
        DrinkMaker drinkMaker = new DrinkMaker(stock);
        this.buyService = new BuyService(drinkCatalog, drinkMaker, cashUnit);
        int goodChoice = 1;
        DrinkStatus drinkStatus = buyService.buyDrink(goodChoice);
        assertEquals(DrinkStatus.NOT_ENOUGH_WATER, drinkStatus);
        assertEquals(0, cashUnit.getBalance());
    }
}
