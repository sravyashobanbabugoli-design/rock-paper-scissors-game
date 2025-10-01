

class BankAccount {
    private String name;
    private int accNo;
    private double balance;

    // Constructor
    BankAccount(String n, int a, double b) {
        name = n;
        accNo = a;
        balance = b;
    }

    // Getters & setters
    public String getName() {
        return name;
    }
    public void setName(String n) {
        name = n;
    }

    public int getAccNo() {
        return accNo;
    }
    public void setAccNo(int a) {
        accNo = a;
    }

    public double getBalance() {
        return balance;
    }
     public void setBalance(double b) {
        balance = b;
    }
    


    
    void deposit(double amt) {    //for deposit.
        balance += amt;
        System.out.println(amt + " deposited. Balance: " + balance);
    }

    
    void withdraw(double amt) {   //for withdraw
        if (amt <= balance) {
            balance -= amt;
            System.out.println(amt + " withdrawn. Balance: " + balance);
        } else {
            System.out.println("Insufficient Balance!");
        }
    }

    
    void display() {
        System.out.println("Name: " + name);
        System.out.println("Account No: " + accNo);
        System.out.println("Balance: " + balance);
    }
}


class SavingsAccount extends BankAccount {    //savings account inherits bankac
    double interestRate;

    SavingsAccount(String n, int a, double b, double rate) {
        super(n, a, b);
        interestRate = rate;
    }

    void addInterest() {    //adding interest
        double interest = (getBalance() * interestRate) / 100;
        deposit(interest);
        System.out.println("Interest " + interest + " added.");
    }
}

class CurrentAccount extends BankAccount {     // CurrentAccount inherits BankAccount
    double overdraft;

    CurrentAccount(String n, int a, double b, double od) {
        super(n, a, b);
        overdraft = od;
    }

    
    @Override
    void withdraw(double amt) {     // Overriding withdraw
        if (amt <= getBalance() + overdraft) {
            setBalance(getBalance() - amt);
            System.out.println(amt + " withdrawn. Balance: " + getBalance());
        } else {
            System.out.println("Exceeds overdraft limit!");
        }
    }
}


public class BankSystem {
    public static void main(String[] args) {
        BankAccount acc1 = new BankAccount("Sanju", 101, 5000);
        acc1.display();
        acc1.deposit(2000);
        acc1.withdraw(1500);

        System.out.println("--- Savings Account ---\n");
        SavingsAccount sAcc = new SavingsAccount("Akshitha", 201, 10000, 5);
        sAcc.display();
        sAcc.addInterest();
        sAcc.withdraw(2000);

        System.out.println("\n--- Current Account ---");
        CurrentAccount cAcc = new CurrentAccount("Deepika", 301, 5000, 2000);
        cAcc.display();
        cAcc.withdraw(6000); 
        cAcc.withdraw(2000);
    }
}


