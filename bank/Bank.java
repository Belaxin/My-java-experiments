import java.util.ArrayList;
import java.util.Scanner;

public class Bank {
    ArrayList<Person> clients = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

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
            createAccount();
            login();
        } else if (input.equalsIgnoreCase("login")) {
            login();

        }
    }

    // method that creates an object using credentials added
    public void createAccount() {
        System.out.println("Enter age: ");
        int age = userInputInt(scanner);
        System.out.println("First name: ");
        String firstName = userInputString(scanner);
        System.out.println("Middle name: ");
        String middleName = userInputString(scanner);
        System.out.println("Last name: ");
        String lastName = userInputString(scanner);
        System.out.println("Social Security: ");
        int socialSecurity = userInputInt(scanner);
        System.out.println("Enter your password");
        String password = userInputString(scanner);
        clients.add(new Person(age, firstName, middleName, lastName, socialSecurity, password));
    }

    // method for logging in using credentials
    public void login() {
        System.out.println("Login: Enter social security");
        int socialSecurityLogin = userInputInt(scanner);
        for (int i = 0; i < clients.size(); i++) {
            if (socialSecurityLogin != clients.get(i).socialSecurity) {
                continue;
            }
            System.out.println("Enter password");
            String passwordLogin = userInputString(scanner);
            if (passwordLogin.equals(clients.get(i).password)) {
                menu(i);
            }
            System.out.println("Details doesn't match");
            login();
        }
        registerAndLogin();
    }

    // method for the logged in menu
    public void menu(int i) {
        System.out.println("Welcome, what would you like to do?");
        System.out.println("1. check balance");
        System.out.println("2. Deposit cash");
        System.out.println("3. Draw cash");
        System.out.println("4. Log out");
        System.out.println("5. Profile");
        int input = userInputInt(scanner);
        if (input == 1) {
            balance(i);
        } else if (input == 2) {
            deposit(i);
        } else if (input == 3) {
            draw(i);
        } else if (input == 4) {
            start();
        } else if (input == 5) {
            profile(i);
        } else {
            System.out.println("You must enter a number");
            menu(i);
        }
    }

    // method for checking account balance
    public void balance(int i) {
        System.out.println("Your current balance is " + clients.get(i).balance + "$");
        menu(i);
    }

    // method for depositing money to the account 
    public void deposit(int i) {
        System.out.println("How much money would you like to deposit?");
        clients.get(i).balance += scanner.nextInt();
        System.out.println("Your balance is now " + clients.get(i).balance + "$");
        menu(i);
    }

    // method for drawing money from the account
    public void draw(int i) {
        System.out.println("How much money would you like to draw out?");
        clients.get(i).balance -= scanner.nextInt();
        System.out.println("Your balance is now " + clients.get(i).balance + "$");
        menu(i);
    }

    // method for checking your profile settings
    public void profile(int i) {
        System.out.println("First name: " + clients.get(i).firstName);
        System.out.println("Middle name: " + clients.get(i).middleName);
        System.out.println("Surname: " + clients.get(i).surName);
        System.out.println("Social Security Number: " + clients.get(i).socialSecurity);
        System.out.println("Age: " + clients.get(i).age);
        System.out.println();
        menu(i);
    }

}