package machine.service;

import machine.domain.CashUnit;
import machine.domain.Stock;
import machine.response.ResourceInventoryResponse;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ResourceInventoryServiceTest {
    @Test
    public void shouldReturnCurrentStockValuesAndCashUnitBalance() {
        Stock stock = new Stock(10, 20, 30, 40);
        CashUnit cashUnit = new CashUnit(500);
        ResourceInventoryService resourceInventoryService = new ResourceInventoryService(stock, cashUnit);
        ResourceInventoryResponse response = resourceInventoryService.getInventory();
        assertEquals(10, response.water());
        assertEquals(20, response.milk());
        assertEquals(30, response.coffee());
        assertEquals(40, response.cups());
        assertEquals(500, response.money());
    }
}
