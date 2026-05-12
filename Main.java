import java.util.Scanner;

public class Main {
    public static void main(String[] args){

        SavingsAccount savingsAccount = null;
        CurrentAccount currentAccount = null;
        Bank bank = new Bank();

        Scanner scanner = new Scanner(System.in);

        while (true){

            System.out.println("1. Create a saving account");
            System.out.println("2. Create a current account");
            System.out.println("3. Withdraw");
            System.out.println("4. Deposit");
            System.out.println("5. Transfer");
            System.out.println("6. View account");
            System.out.println("7. View all account");
            System.out.println("8. Apply Interest");
            System.out.println("9. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice){

                case 1 -> {

                    String name = "";
                    System.out.print("Enter your name: ");
                    name = scanner.nextLine();

                    String accountNumber = "";
                    System.out.print("Enter your account number: ");
                    accountNumber = scanner.nextLine();

                    double amount = 0;
                    System.out.print("Enter amount: ");
                    amount = scanner.nextDouble();
                    scanner.nextLine();

                    savingsAccount = new SavingsAccount(accountNumber, name, amount);
                    bank.addAccount(savingsAccount);
                }

                case 2 -> {
                    String name = "";
                    System.out.print("Enter your name: ");
                    name = scanner.nextLine();

                    String accountNumber = "";
                    System.out.print("Enter your account number: ");
                    accountNumber = scanner.nextLine();

                    double amount = 0;
                    System.out.print("Enter amount: ");
                    amount = scanner.nextDouble();
                    scanner.nextLine();

                    currentAccount = new CurrentAccount(accountNumber, name, amount);
                    bank.addAccount(currentAccount);
                }

                case 3 -> {

                    String accountNumber;
                    System.out.print("Enter your account number: ");
                    accountNumber = scanner.nextLine();
                    Account account = bank.findAccount(accountNumber);

                    if (account == null){
                        System.out.println("Account is not found");
                    }
                    else {
                        double amount;
                        System.out.print("Enter amount: ");
                        amount = scanner.nextDouble();
                        account.withdraw(amount);
                        scanner.nextLine();
                    }

                }

                case 4 -> {

                    String accountNumber;
                    System.out.print("Enter your account number: ");
                    accountNumber = scanner.nextLine();
                    Account account = bank.findAccount(accountNumber);

                    if (account == null){
                        System.out.println("Account is not found");
                    }
                    else {
                        double amount;
                        System.out.print("Enter amount: ");
                        amount = scanner.nextDouble();
                        account.deposit(amount);
                        scanner.nextLine();
                    }
                }

                case 5 -> {

                    String from;
                    System.out.print("Enter the account number you transferring from: ");
                    from = scanner.nextLine();

                    String to;
                    System.out.print("Enter the account number you want to transfer to: ");
                    to = scanner.nextLine();

                    double amount;
                    System.out.print("Enter amount: ");
                    amount = scanner.nextDouble();
                    scanner.nextLine();

                    bank.transfer(from, to, amount);
                }

                case 6 -> {
                    String accountNumber;
                    System.out.print("Enter your account number: ");
                    accountNumber = scanner.nextLine();
                    Account account = bank.findAccount(accountNumber);

                    if (account == null){
                        System.out.println("Account is not found");
                    }
                    else {
                        account.printStatement();
                    }
                }

                case 7 -> {
                    bank.printAllAccount();
                }

                case 8 -> {
                    String accountNumber;
                    System.out.print("Enter your account number: ");
                    accountNumber = scanner.nextLine();
                    Account account = bank.findAccount(accountNumber);

                    if (account == null){
                        System.out.println("Account is not found");
                    }
                    else if (account instanceof SavingsAccount){
                        ((SavingsAccount) account).applyInterest();
                        System.out.println("Interest applied! New balance: " + account.getBalance());
                    }
                    else {
                        System.out.println("This account does not support interest!");
                    }
                }

                case 9 -> {
                    System.out.println("Thank you for using our bank please come again");
                    return;
                }
            }
        }
    }
}