package inheritance;

public class CurrentAccount extends Account {

    private double balance;
    private double interest;

    public CurrentAccount(String holderName, String id) {

        super(holderName, id);
        this.balance = 0;
        this.interest = 0;
    }

    public void credit(double amount) {

        balance = balance + amount;
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

    public void transferTo(CurrentAccount destination, double amount) {

        if (debit(amount)) {
            destination.credit(amount);
            System.out.println("Transfer Successful");
        }
        else {
            System.out.println("Not Enough Balance");
        }
    }

    public void transferToSavings(SavingsAccount savingsAccount, double amount) {

        if (debit(amount)) {
            savingsAccount.credit(amount);
            System.out.println("Transfer Successful");
        }
        else {
            System.out.println("Not Enough Balance");
        }

    }

    public double getBalance() {
        return balance;
    }
}
