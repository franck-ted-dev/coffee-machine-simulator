package machine.service;

import machine.request.RefillRequest;
import machine.domain.Stock;

public class FillService {
    private final Stock stock;

    public FillService(Stock stock) {
        this.stock = stock;
    }

    public void fill(RefillRequest refillRequest) {
        stock.add(refillRequest.water(),
                refillRequest.milch(),
                refillRequest.coffee(),
                refillRequest.cups());
    }
}
