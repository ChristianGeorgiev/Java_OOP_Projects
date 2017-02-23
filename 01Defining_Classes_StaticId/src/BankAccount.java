public class BankAccount {
    private final static double DEFAULT_INTEREST = 0.02;
    private static double rate = DEFAULT_INTEREST;

    private static int bankAccountCount;

    private int id;
    private double balance;

    public int getId(){
        return this.id;
    }

    public BankAccount (){
        this.id = ++bankAccountCount;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit (double amount){
            this.balance += amount;

    }

    public double getInterest(int years) {
        return this.balance * rate * years;
    }

    public static void setInterest(double interest) {
        rate = interest;
    }

    @Override
    public String toString(){
        return "ID" + this.id;
    }
}
