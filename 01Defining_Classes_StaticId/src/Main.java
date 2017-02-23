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

            switch (commandType) {
                case "Create":
                    executeCreate(accounts, commandTokens);
                    break;
                case "Deposit":
                    executeDeposit(accounts, commandTokens);
                    break;
                case "SetInterest":
                    executeSetInterest(commandTokens);
                    break;
                case "GetInterest":
                    executeGetInterest(accounts, commandTokens);
                    break;
            }

            command = console.readLine();
        }
    }

    private static void executeGetInterest(HashMap<Integer, BankAccount> accounts, String[] commandTokens) {
        int id = Integer.valueOf(commandTokens[1]);
        int years = Integer.valueOf(commandTokens[2]);

        if (accounts.containsKey(id)){
            System.out.printf("%.2f%n", accounts.get(id).getInterest(years));
        }else {
            System.out.println("Account does not exist");
        }
    }

    private static void executeSetInterest(String[] commandTokens) {
        int interest = Integer.valueOf(commandTokens[1]);
        BankAccount.setInterest(interest);
    }

    private static void executeDeposit(HashMap<Integer, BankAccount> accounts, String[] commandTokens) {
        try {
            int id = Integer.valueOf(commandTokens[1]);
            double amount = Double.valueOf(commandTokens[2]);

            if (accounts.containsKey(id)) {
                accounts.get(id).deposit(amount);
                System.out.printf("Deposited %.0f to %s%n", amount, accounts.get(id));
            } else {
                System.out.println("Account does not exist");
            }
        } catch (Exception e){

        }
    }

    private static void executeCreate(HashMap<Integer, BankAccount> accounts, String[] commandTokens) {
        BankAccount account = new BankAccount();
        accounts.put(account.getId(), account);
        System.out.printf("Account %s created%n", account);
    }
}
