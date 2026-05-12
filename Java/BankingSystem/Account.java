public abstract class Account {

    String accountNumber;
    String name;
    double balance;

    Account(String accountNumber, String name, double balance){
        this.accountNumber = accountNumber;
        this.name = name;
        this.balance = balance;

    }

    abstract void  withdraw(double amount);

    void deposit(double amount){
        balance += amount;
    }

    void printStatement(){
        System.out.println("Username: " + name + " account number: " + accountNumber + " account balance: " + balance);
    }

    public double getBalance() {
        return balance;
    }
}
