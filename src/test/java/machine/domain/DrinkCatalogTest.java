package machine.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DrinkCatalogTest {
    private DrinkCatalog drinkCatalog;

    @BeforeEach
    public void setup() {
        this.drinkCatalog = new DrinkCatalog();
    }

    @Test
    void shouldReturnTrueForValidDrinkIndexes() {
        assertTrue(drinkCatalog.isAvailable(0));
        assertTrue(drinkCatalog.isAvailable(2));
    }

    @Test
    void shouldReturnFalseWhenIndexIsNegative() {
        assertFalse(drinkCatalog.isAvailable(-1));
    }

    @Test
    void shouldReturnFalseWhenIndexIsGreaterThanLastAvailableIndex() {
        assertFalse(drinkCatalog.isAvailable(3));
    }
}
