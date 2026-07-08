package machine.service;

import machine.domain.CashUnit;

public class TakeService {
    private final CashUnit cashUnit;

    public TakeService(CashUnit cashUnit) {
        this.cashUnit = cashUnit;
    }

    public int take(){
        return cashUnit.takeMoney();
    }
}
