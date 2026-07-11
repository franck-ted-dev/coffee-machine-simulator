package machine.service;

import machine.domain.CashUnit;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TakeServiceTest {
    @Test
    public void shouldReturnCollectedMoneyAndResetCashUnit(){
        CashUnit cashUnit = new CashUnit(1000);
        TakeService takeService = new TakeService(cashUnit);
        int takenMoney = takeService.take();
        assertEquals(1000, takenMoney);
        assertEquals(0, cashUnit.getBalance());
    }
}
