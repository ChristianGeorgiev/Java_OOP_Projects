public class BankAccount {
    private int id;
    private double balance;

    public void deposit (double amount){
        if (amount < 0){
            System.out.println("Amount must be non negative");
        }else {
            this.balance += amount;
        }
    }

    public void withdraw (double amount){
        if (!(amount > this.balance)) {
            if (amount < 0) {
                System.out.println("Amount must be non negative");
            } else {
                this.balance -= amount;
            }
        }else {
            System.out.println("Insufficient balance");
        }
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBalance() {
        return this.balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString(){
        return "ID" + this.id;
    }
}
