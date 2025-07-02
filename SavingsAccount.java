package inheritance;

public class SavingsAccount extends Account{

    private double balance;
    private double interest;

    public SavingsAccount(String holderName, String id) {
        super(holderName, id);
        this.balance = 0;
        this.interest = 2.5;
    }

    @Override
    public boolean debit(double amount) {
        if (amount > balance) {
            return false;
        }
        else {
          balance = balance - amount;
          return true;
        }
    }

    @Override
    public void credit(double amount) {
        balance = super.calculateInterest(balance, amount, interest);
    }

    public void transferTo(SavingsAccount destination, double amount) {

        if (debit(amount)) {
            destination.credit(amount);
            System.out.println("Transfer Successful");
        }
        else {
            System.out.println("Not Enough Balance");
        }
    }

    public void transferToCurrent(CurrentAccount currentAccount, double amount) {

        if (debit(amount)) {
            currentAccount.credit(amount);
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
