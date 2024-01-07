package bank;

import java.util.HashMap;
import java.util.Scanner;

public class Bank {
    int accountId = 0;
    public static HashMap<Integer, Account> clients = new HashMap<>();
    final private static HashMap<Integer, Integer> socialSecurity_Id = new HashMap<>();
    Scanner scanner = new Scanner(System.in);

    // account getter
    public Account getAccount(int accountId) {
        return clients.get(accountId);
    }

    // method for starting
    public void start() {
        registerAndLogin();
    }

    // method for inputting strings
    public String userInputString(Scanner scanner) {
        return scanner.nextLine();
    }

    // method for integers
    public int userInputInt(Scanner scanner) {
        int number;
        if (scanner.hasNextInt()) {
            number = scanner.nextInt();
            // consumes next null line
            scanner.nextLine();
            return number;
        } else {
            // consume the wrong input and issue an error message
            String wrongInput = scanner.next();
            System.err.println("Expected an int but got " + wrongInput);
            userInputInt(scanner);
            return 0;
        }

    }

    //method for choosing registering / logging in
    public void registerAndLogin() {
        System.out.println("Register or login?");
        String input = (userInputString(scanner));
        if (input.equalsIgnoreCase("register")) {
            accountId = createAccount();
            System.out.println("amount of accs." + accountId);
            login();
        } else if (input.equalsIgnoreCase("login")) {
            login();

        } else {
            start();
        }
    }

    // method that creates an object using credentials added
    public int createAccount() {
        System.out.println("Enter age: ");
        int age = userInputInt(scanner);
        System.out.println("First name: ");
        String firstName = userInputString(scanner);
        System.out.println("Middle name: ");
        String middleName = userInputString(scanner);
        System.out.println("Last name: ");
        String lastName = userInputString(scanner);
        System.out.println("Social Security: ");
        Integer socialSecurity = userInputInt(scanner);
        // checks if socialSecurity is used
        if (socialSecurity_Id.containsKey(socialSecurity)) {
            System.out.println("Account already exists");
            createAccount();
            return accountId;
        }
        System.out.println("Enter your password: ");
        String password = userInputString(scanner);
        accountId++;
        clients.put(accountId, new Account(socialSecurity, firstName, middleName, lastName, age, password, accountId));
        socialSecurity_Id.put(socialSecurity, accountId);
        return accountId;
    }

    // method for logging in using credentials
    public void login() {
        System.out.println("Login: Enter social security");
        int socialSecurityLogin = userInputInt(scanner);
        //noinspection DuplicateCondition
        if (!socialSecurity_Id.containsKey(socialSecurityLogin)) {
            System.out.println("That account doesn't exist");
            login();
        } else //noinspection DuplicateCondition
            if (socialSecurity_Id.containsKey(socialSecurityLogin)) {
                System.out.println("Enter password");
                String passwordLogin = userInputString(scanner);
                if (clients.get(socialSecurity_Id.get(socialSecurityLogin)).getPassword().equals(Hashing.hash(passwordLogin))) {
                    menu(socialSecurity_Id.get(socialSecurityLogin));
                } else {
                    System.out.println("Details don't match enter again");
                    login();
                }
            }
    }

    // method for the logged in menu
    public void menu(int accountId) {
        System.out.println("Welcome, what would you like to do? \n 1. check balance \n 2. Deposit cash \n" +
                " 3. Draw cash \n 4. Send cash \n 5. Log out \n 6. Profile");
        int input = userInputInt(scanner);
        if (input == 1) {
            System.out.println(clients.get(accountId).getBalance());
            menu(accountId);
        } else if (input == 2) {
            clients.get(accountId).deposit(accountId);
        } else if (input == 3) {
            clients.get(accountId).withdraw(accountId);
        } else if (input == 4) {
            clients.get(accountId).sendMoney(accountId);
        } else if (input == 5) {
            start();
        } else if (input == 6) {
            clients.get(accountId).profile(accountId);
        } else {
            System.out.println("You must enter a number");
            menu(accountId);
        }
    }


}



