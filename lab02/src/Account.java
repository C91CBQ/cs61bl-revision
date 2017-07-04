/**
 * Created by qibao on 2017/6/24.
 */
public class Account {

    private double balance = 0.0;

    private Account parentAccount;

    public Account(double balance, Account parentAccount) {
        this.balance = balance;
        this.parentAccount = parentAccount;
    }

    public Account(double balance) {
        this.balance = balance;
        this.parentAccount = null;
    }

    public double getBalance() {
        return this.balance;
    }

    public boolean withdraw(double num) {
        if (num <= 0) {
            System.out.println("Please input right number!");
            return false;
        }
        if (num <= balance) {
            balance -= num;
            return true;
        } else {
            if (parentAccount != null) {
                if (parentAccount.withdraw(num - balance)) {
                    balance = 0;
                    return true;
                }
            }
        }
        System.out.println("Can not withdraw!");
        return false;
    }

    public boolean deposit(double num) {
        if (num > 0) {
            balance += num;
            return true;
        }
        return false;
    }

    public boolean merge(Account account) {
        this.balance += account.balance;
        account.withdraw(account.balance);
        return true;
    }

    public static void main(String args[]) {
        Account parent = new Account(300);
        Account child = new Account(100, parent);
        System.out.println(child.withdraw(500));
        System.out.println(parent.getBalance());
        System.out.println(child.getBalance());
    }

}
