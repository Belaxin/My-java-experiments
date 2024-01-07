package bank;


public class Account extends Bank {
    private final int age;
    private final String firstName;
    private final String middleName;
    private final String surName;
    private final int socialSecurity;
    private final String password;
    private int balance = 0;
    private final int accountId;


    public Account(int socialSecurity, String firstName, String middleName, String surName, int age, String password, int accountId) {
        this.age = age;
        this.firstName = firstName;
        this.middleName = middleName;
        this.surName = surName;
        this.socialSecurity = socialSecurity;
        this.password = password;
        this.accountId = accountId;
    }

    public int getSocialSecurity() {
        return socialSecurity;
    }

    public int getAge() {
        return age;
    }

    public int getBalance() {
        return balance;
    }

    protected String getPassword() {
        return Hashing.hash(password);
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSurName() {
        return surName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public int getAccountId() {
        return accountId;
    }

    public void sendMoney(int accountId) {
        System.out.println("Enter recipient's account ID, it can be found on profile page");
        int recipientId = userInputInt(scanner);
        System.out.println("Enter the desired ammount");
        int sendAmount = userInputInt(scanner);
        // this rejects negative numbers to prevent stealing
        if (sendAmount < 0) {
            System.out.println("You must enter a positive number");
            sendMoney(accountId);
            return;
        }
        getAccount(accountId).balance -= sendAmount;
        getAccount(recipientId).balance += sendAmount;
        System.out.println("Successfully sent " + sendAmount + "$ to account of " + getAccount(recipientId).firstName + " " + getAccount(recipientId).surName);
        menu(accountId);
    }

    public void withdraw(int accountId) {
        System.out.println("How much money would you like to withdraw?");
        getAccount(accountId).balance -= userInputInt(scanner);
        menu(accountId);
    }

    public void deposit(int accountId) {
        System.out.println("How much money do you wish to deposit?");
        getAccount(accountId).balance += userInputInt(scanner);
        menu(accountId);
    }

    public void profile(int accountId) {
        System.out.println("First name: " + getAccount(accountId).firstName);
        System.out.println("Middle name: " + getAccount(accountId).middleName);
        System.out.println("Surname: " + getAccount(accountId).surName);
        System.out.println("Social Security Number: " + getAccount(accountId).socialSecurity);
        System.out.println("Age: " + getAccount(accountId).age);
        System.out.println("Account id " + getAccount(accountId).accountId);
        userInputString(scanner);
        menu(accountId);
    }


}



