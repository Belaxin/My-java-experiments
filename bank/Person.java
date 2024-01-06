package bank;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.function.IntFunction;


public class Person {
    private int age;
    private String firstName;
    private String middleName;
    private String surName;
    private int socialSecurity;
    private String password;
    protected int balance = 0;


    public Person(int age, String firstName, String middleName, String surName, int socialSecurity, String password) {
        this.age = age;
        this.firstName = firstName;
        this.middleName = middleName;
        this.surName = surName;
        this.socialSecurity = socialSecurity;
        this.password = password;


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
    protected String getPassword(){
        return password;
    }
    public String getFirstName(){
        return firstName;
    }
    public String getSurName(){
        return surName;
    }
    public String getMiddleName(){
        return middleName;
    }
}



