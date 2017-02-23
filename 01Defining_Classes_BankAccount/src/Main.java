import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        HashMap<Integer, BankAccount> accounts = new HashMap<>();


        String command = console.readLine();
        while (!"End".equals(command)){
            String[] commandTokens = command.split("\\s+");
            String commandType = commandTokens[0];

            switch (commandType){
                case "Create":
                    executeCreate(accounts, commandTokens);
                    break;
                case "Deposit":
                    executeDeposit(accounts, commandTokens);
                    break;
                case "Withdraw":
                    executeWithdraw(accounts, commandTokens);
                    break;
                case "Print":
                    executePrint(accounts, commandTokens);
                    break;
            }


            command = console.readLine();
        }
    }

    private static void executePrint(HashMap<Integer, BankAccount> accounts, String[] commandTokens) {
        int id = Integer.valueOf(commandTokens[1]);

        if (accounts.containsKey(id)){
            System.out.printf("Account %s, balance %.2f%n", accounts.get(id), accounts.get(id).getBalance());
        }else {
            System.out.println("Account does not exist");
        }
    }

    private static void executeWithdraw(HashMap<Integer, BankAccount> accounts, String[] commandTokens) {
        int id = Integer.valueOf(commandTokens[1]);
        double amount = Double.valueOf(commandTokens[2]);

        if (accounts.containsKey(id)){
            accounts.get(id).withdraw(amount);
        }else {
            System.out.println("Account does not exist");
        }
    }

    private static void executeDeposit(HashMap<Integer, BankAccount> accounts, String[] commandTokens) {
        int id = Integer.valueOf(commandTokens[1]);
        double amount = Double.valueOf(commandTokens[2]);

        if (accounts.containsKey(id)){
            accounts.get(id).deposit(amount);
        }else {
            System.out.println("Account does not exist");
        }
    }

    private static void executeCreate(HashMap<Integer, BankAccount> accounts, String[] commandTokens) {
        int id = Integer.valueOf(commandTokens[1]);

        if (!accounts.containsKey(id)){
            BankAccount account = new BankAccount();
            account.setId(id);
            accounts.put(id, account);
        }else {
            System.out.println("Account already exists");
        }
    }
}
