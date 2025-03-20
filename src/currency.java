public class currency {
    private int balance;

    public currency(int startingAmount) {
        this.balance = startingAmount;
    }

    public void addMoney(int amount) {
        if (amount > 0) {
            this.balance += amount;
        }
    }

    public void removeMoney(int amount) {
        if (amount > 0 && amount <= this.balance) {
            this.balance -= amount;
        }
    }

    public int getBalance() {
        return this.balance;
    }

    public void setBalance(int amount) {
        if (amount >= 0) {
            this.balance = amount;
        }
    }
}