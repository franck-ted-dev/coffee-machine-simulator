package machine.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
public class CashUnitTest {
    @Test
    public void shouldSetBalanceToZeroWhenInitialBalanceIsNegative() {
        CashUnit cashUnit = new CashUnit(-1);
        assertEquals(0, cashUnit.getBalance());
    }

    @Test
    public void shouldSetBalanceToZeroWhenInitialBalanceIsZero() {
        CashUnit cashUnit = new CashUnit(0);
        assertEquals(0, cashUnit.getBalance());
    }

    @Test
    public void balanceShouldMatchInitialBalanceWhenPositive() {
        CashUnit cashUnit = new CashUnit(1000);
        assertEquals(1000, cashUnit.getBalance());
    }
}

