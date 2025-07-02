package inheritance;

public class DepositPremiumAccount extends Account {

    private double balance;
    private double interest;
    private int check = 0;

    public DepositPremiumAccount(String holderName, String id) {
        super(holderName, id);
        this.balance = 0;
        this.interest = 7;
    }

    public void credit(double amount) {

        balance = super.calculateInterest(balance, amount, interest);
        this.check++;
    }

    public boolean checker() {
        if (check < 5) {
            return false;
        }
        else {
            return true;
        }
    }

    public boolean debit(double amount) {

        if (amount > balance) {
            return false;
        }
        else {
            balance = balance - amount;
            return true;
        }
    }

    public double getBalance() {
        return balance;
    }

    public int getCheck() {
        return check;
    }
}
