public class CurrentAccount extends Account{

    double overdraftLimit = 500;

    CurrentAccount(String name, String accountNumber, double balance){
        super(name, accountNumber, balance);
    }

    @Override
    void withdraw(double amount){
        if (balance - amount >= -overdraftLimit){
            balance -= amount;
        }
        else {
            System.out.println("You have gone pass your overdraft limit!");
        }
    }
}
