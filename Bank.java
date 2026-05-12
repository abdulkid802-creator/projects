import java.util.ArrayList;

public class Bank {

    ArrayList<Account> accounts = new ArrayList<>();

    void addAccount(Account account){
        accounts.add(account);
    }

    Account findAccount(String accountNumber) {
        for (Account account : accounts) {
            if (account.accountNumber.equals(accountNumber)){
                return account;
            }
        }
        return null;
    }

     void transfer(String fromAccount, String toAccount, double amount){
        Account from = findAccount(fromAccount);
        Account to = findAccount(toAccount);

        if (from == null || to == null){
            System.out.println("Error unable to find this account!");
            return;
        }
        else {
            from.withdraw(amount);
            to.deposit(amount);
        }

        return;
    }

    void printAllAccount(){
        for (Account account : accounts) {
            account.printStatement();
        }
    }
}
