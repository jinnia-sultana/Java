package inheritance;

abstract public class Account {

    private String holderName;
    private String id;

    public Account(String holderName, String id) {

        this.holderName = holderName;
        this.id = id;
    }

    public double calculateInterest(double balance, double amount, double interest) {
        balance = balance + amount;
        if (balance >= 1000) {
            balance = balance + (balance * interest/100);
            System.out.println("Interest Applied");
        }
        else {
            System.out.println("Interest Not Applied");
        }
        return balance;
    }

    public String getHolderName() {
        return holderName;
    }

    public String getId() {
        return id;
    }

    abstract public void credit(double amount);
    abstract public boolean debit(double amount);

}
