package org.emailApp;

import java.util.Scanner;

public class Email {
    private String firstName;
    private String lastName;
    private String password;
    private String department;
    private String email;
    private int mailBoxCapacity = 500;
    private int passwordLength = 10;
    private String alternateEmail;
    private String companySuffix = "aeycompany.com";

    // constructor to receive the first name and last name
    public Email(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
//        System.out.println("EMAIL CREATED: " + this.firstName + " " + this.lastName);

        // Call a method asking for the department - return the department
        this.department = setDepartment();

        // Call a method that returns a random password
        this.password = randomPassword(passwordLength);
        System.out.println("Your password is: " + this.password);

        // Combine elements to generate email
        email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + "." + companySuffix;
    }

    // Ask for the department
    private String setDepartment() {
        System.out.print("Hello " + this.getFirstName() + ".  Please choose department code:\n1 for Sales\n2 for " +
                "Development\n3 for Accounting\n0 for none\nEnter department code: ");
        Scanner in = new Scanner(System.in);
        int depChoice = in.nextInt();
        if (depChoice == 1) { return "sales"; }
        else if (depChoice == 2) { return "dev"; }
        else if (depChoice == 3) { return "acct"; }
        else { return ""; }
    }

    //Generate a random password
    private String randomPassword(int length) {
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ01234567890!@#$%";
        char[] password = new char[length];
        for (int i=0; i<length; i++) {
            int rand = (int) (Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(rand);
        }
        return new String(password);
    }

    //Set the mailbox capacity
    public void setMailBoxCapacity(int capacity) {
        this.mailBoxCapacity = capacity;
    }

    //Set the alternate email
    public void setAlternateEmail(String altEmail) {
        this.alternateEmail = altEmail;
    }

    //Change the password
    public void changePassword(String password) {
        this.password = password;
    }

    public int getMailBoxCapacity() { return this.mailBoxCapacity; }

    public String getAlternateEmail() { return this.alternateEmail; }

    public String getPassword() { return this.password; }

    public String getEmail() { return this.email; }

    public String getFirstName() { return this.firstName; }

    public String getLastName() { return  this.lastName; }

    public String getName() { return this.getFirstName() + " " + this.getLastName(); }

    public String showInfo() {
        return "NAME: " + getName() +
                "\nCOMPANY EMAIL: " + this.email +
                "\nMAILBOX CAPACITY: " + this.mailBoxCapacity + "MB";
    }
}
