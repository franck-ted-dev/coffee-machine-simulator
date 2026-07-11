package machine.service;

import machine.domain.Stock;
import machine.request.RefillRequest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FillServiceTest {

    @Test
    public void shouldIncreaseStockByRefillRequestValues() {
        Stock stock = new Stock(0, 0, 0, 0);
        FillService fillService = new FillService(stock);
        RefillRequest request = new RefillRequest(10, 20, 30, 40);
        fillService.fill(request);
        assertEquals(10, stock.getWaterQuantity());
        assertEquals(20, stock.getMilkQuantity());
        assertEquals(30, stock.getCoffeeQuantity());
        assertEquals(40, stock.getDisposableCups());
    }
}
