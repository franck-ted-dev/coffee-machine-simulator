package machine.service;

import machine.domain.CashUnit;
import machine.domain.Stock;
import machine.response.ResourceInventoryResponse;

public class ResourceInventoryService {
    private final Stock stock;
    private final CashUnit cashUnit;

    public ResourceInventoryService(Stock stock, CashUnit cashUnit) {
        this.stock = stock;
        this.cashUnit = cashUnit;
    }

    public ResourceInventoryResponse getInventory(){
        return new ResourceInventoryResponse(stock.getWaterQuantity(),
                stock.getMilkQuantity(),
                stock.getCoffeeQuantity(),
                stock.getDisposableCups(),
                cashUnit.getBalance());
    }
}
