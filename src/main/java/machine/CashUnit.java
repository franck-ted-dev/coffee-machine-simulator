package machine;

public class CashUnit {
    private int balance;

    public CashUnit() {
        this.balance = 550;
    }

    public int getBalance() {
        return this.balance;
    }

    public int takeMoney() {
        int money = this.balance;
        this.balance = 0;
        return money;
    }

    public void collectMoney(int money) {
        this.balance += money;
    }
}
