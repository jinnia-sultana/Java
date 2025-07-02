package inheritance;
import java.util.Scanner;
import java.util.ArrayList;

public class main {
   public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ArrayList<CurrentAccount> currentAccounts = new ArrayList<>();
        ArrayList<SavingsAccount> savingsAccounts = new ArrayList<>();
        ArrayList<DepositPremiumAccount> depositPremiumAccounts = new ArrayList<>();

        System.out.println("----BANK OPTIONS----");
        System.out.println("[1] Create New Account");
        System.out.println("[2] Quit");

        int choice = scanner.nextInt();
        scanner.nextLine();

        String holderName, id;
        int currIndex = 0;

        if (choice == 1) {

            System.out.println("Enter Holder Name: ");
            holderName = scanner.nextLine();

            System.out.println("Enter ID: ");
            id = scanner.nextLine();
        }
        else {
            return;
        }

        currentAccounts.add(new CurrentAccount(holderName, id));
        savingsAccounts.add(new SavingsAccount(holderName, id));
        depositPremiumAccounts.add(new DepositPremiumAccount(holderName, id));

        while (true) {

            System.out.println("----BANK OPTIONS----");
            System.out.println("[1] Create New Account");
            System.out.println("[2] Enter Current Account Options");
            System.out.println("[3] Enter Savings Account Options");
            System.out.println("[4] Enter Deposit Premium Account Options");
            System.out.println("[5] Change Account");
            System.out.println("[6] Quit");

            int choice1 = scanner.nextInt();
            scanner.nextLine();

            if (choice1 == 1) {

                System.out.println("Enter Holder Name: ");
                holderName = scanner.nextLine();

                System.out.println("Enter ID: ");
                id = scanner.nextLine();

                currentAccounts.add(new CurrentAccount(holderName, id));
                savingsAccounts.add(new SavingsAccount(holderName, id));
                depositPremiumAccounts.add(new DepositPremiumAccount(holderName, id));
            }
            else if (choice1 == 2) {

                while (true) {
                    System.out.println("----CURRENT ACCOUNT----");
                    System.out.println("[1] Credit");
                    System.out.println("[2] Debit");
                    System.out.println("[3] Transfer to Another Account");
                    System.out.println("[4] Transfer to Savings Account");
                    System.out.println("[5] Check Details");
                    System.out.println("[6] Back");

                    int currentChoice = scanner.nextInt();
                    scanner.nextLine();

                    if (currentChoice == 1) {

                        System.out.println("Enter Amount to Deposit: ");
                        double amount = scanner.nextDouble();

                        currentAccounts.get(currIndex).credit(amount);
                    }
                    else if (currentChoice == 2) {

                        System.out.println("Enter Amount to Withdraw: ");
                        double amount = scanner.nextDouble();

                        if (currentAccounts.get(currIndex).debit(amount)) {
                            System.out.println("Withdraw Successful");
                        }
                        else {
                            System.out.println("Not Enough Balance");
                        }
                    }
                    else if (currentChoice == 3) {

                        System.out.println("Enter the ID of the Account you would like to transfer to: ");
                        String searchId = scanner.nextLine();
                        int index = 0;
                        double amount = 0;

                        for (CurrentAccount e: currentAccounts) {
                            if (searchId.equals(e.getId())) {
                                System.out.println("Found");
                                System.out.println("Enter the amount to transfer: ");
                                amount = scanner.nextDouble();
                                scanner.nextLine();
                                break;
                            }
                            index++;
                        }

                        currentAccounts.get(currIndex).transferTo(currentAccounts.get(index), amount);

                    }
                    else if (currentChoice == 4) {

                        System.out.println("Enter the amount to transfer to savings account: ");
                        double amount = scanner.nextDouble();
                        currentAccounts.get(currIndex).transferToSavings(savingsAccounts.get(currIndex), amount);
                    }
                    else if (currentChoice == 5) {

                        System.out.println("---------------------");
                        System.out.println("Holder Name: " + currentAccounts.get(currIndex).getHolderName());
                        System.out.println("ID: " + currentAccounts.get(currIndex).getId());
                        System.out.println("Balance: " + currentAccounts.get(currIndex).getBalance());
                        System.out.println("---------------------");
                    }
                    else {
                        break;
                    }
                }

            }
            else if (choice1 == 3) {

                while (true) {

                    System.out.println("----SAVINGS ACCOUNT----");
                    System.out.println("[1] Credit");
                    System.out.println("[2] Debit");
                    System.out.println("[3] Transfer to Another Account");
                    System.out.println("[4] Transfer to Current Account");
                    System.out.println("[5] Check Details");
                    System.out.println("[6] Back");

                    int savingsChoice = scanner.nextInt();

                    if (savingsChoice == 1) {

                        System.out.println("Enter Amount to Deposit: ");
                        double amount = scanner.nextDouble();

                        savingsAccounts.get(currIndex).credit(amount);
                    }
                    else if (savingsChoice == 2) {

                        System.out.println("Enter Amount to Withdraw: ");
                        double amount = scanner.nextDouble();

                        if (savingsAccounts.get(currIndex).debit(amount)) {
                            System.out.println("Withdraw Successful");
                        }
                        else {
                            System.out.println("Not Enough Balance");
                        }
                    }
                    else if (savingsChoice == 3) {
                        scanner.nextLine();

                        System.out.println("Enter the ID of the Account you would like to transfer to: ");
                        String searchId = scanner.nextLine();
                        int savingsIndex = 0;
                        double amount = 0;

                        for (SavingsAccount e: savingsAccounts) {
                            if (searchId.equals(e.getId())) {
                                System.out.println("Found");
                                System.out.println("Enter the amount to transfer: ");
                                amount = scanner.nextDouble();
                                scanner.nextLine();
                                break;
                            }
                            savingsIndex++;
                        }

                        savingsAccounts.get(currIndex).transferTo(savingsAccounts.get(savingsIndex), amount);

                    }
                    else if (savingsChoice == 4) {

                        System.out.println("Enter the amount to transfer to savings account: ");
                        double amount = scanner.nextDouble();
                        savingsAccounts.get(currIndex).transferToCurrent(currentAccounts.get(currIndex), amount);
                    }
                    else if (savingsChoice == 5) {

                        System.out.println("--------------------");
                        System.out.println("Holder Name: " + savingsAccounts.get(currIndex).getHolderName());
                        System.out.println("ID: " + savingsAccounts.get(currIndex).getId());
                        System.out.println("Balance: " + savingsAccounts.get(currIndex).getBalance());
                        System.out.println("--------------------");
                    }
                    else {
                        break;
                    }
                }
            }
            else if (choice1 == 4) {

                while (true) {
                    System.out.println("----PREMIUM DEPOSIT ACCOUNT----");
                    System.out.println("[1] Credit");
                    System.out.println("[2] Debit");
                    System.out.println("[3] Check Details");
                    System.out.println("[4] Back");

                    int premiumChoice = scanner.nextInt();

                    if (premiumChoice == 1) {
                        System.out.println("Enter the amount to deposit: ");
                        double amount = scanner.nextDouble();

                        depositPremiumAccounts.get(currIndex).credit(amount);
                    }
                    else if (premiumChoice == 2) {
                        if (depositPremiumAccounts.get(currIndex).checker()) {
                            System.out.println("Enter the amount to withdraw: ");
                            double amount = scanner.nextDouble();

                            if (depositPremiumAccounts.get(currIndex).debit(amount)) {
                                System.out.println("Withdraw Successful");
                            }
                            else {
                                System.out.println("Not Enough Balance");
                            }
                        }
                        else {
                            System.out.println("Cannot Withdraw before depositing (5)installments");
                        }
                    }
                    else if (premiumChoice == 3) {
                        System.out.println("Holder Name: " + depositPremiumAccounts.get(currIndex).getHolderName());
                        System.out.println("ID: " + depositPremiumAccounts.get(currIndex).getId());
                        System.out.println("Balance: " + depositPremiumAccounts.get(currIndex).getBalance());
                        System.out.println("Current Installments deposited: " + depositPremiumAccounts.get(currIndex).getCheck());
                    }
                    else  {
                        break;
                    }
                }
            }
            else if (choice1 == 5) {

                currIndex = 0;
                System.out.println("Enter the ID: ");
                String searchId = scanner.nextLine();

                for (CurrentAccount e: currentAccounts) {
                    if (searchId.equals(e.getId())) {
                        System.out.println("Change Successful");
                        break;
                    }
                    currIndex++;
                }
            }
            else {
                break;
            }
        }

    }
}
