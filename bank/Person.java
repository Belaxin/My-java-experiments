package bank;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.function.IntFunction;


public class Person {
    public int age;
    public String firstName;
    public String middleName;
    public String surName;
    protected int socialSecurity;
    protected String password;
    protected int balance = 0;


    public Person(int age, String firstName, String middleName, String surName, int socialSecurity, String password) {
        this.age = age;
        this.firstName = firstName;
        this.middleName = middleName;
        this.surName = surName;
        this.socialSecurity = socialSecurity;
        this.password = password;


    }


}



