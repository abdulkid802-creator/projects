public class SavingsAccount extends Account{

    double interestRate = 0.03;

    SavingsAccount(String name, String accountNumber, double balance){
        super(name, accountNumber, balance);
    }

    @Override
    void withdraw(double amount){
        if (balance - amount >= 0){
            balance -= amount;
        }
        else {
            System.out.println("Your balance need to be above 0 for you to be able to withdraw!");
        }
    }

    void applyInterest(){
        balance += balance * interestRate;
    }


}
