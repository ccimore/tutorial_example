package studentDatabaseApp;

import java.util.Scanner;

public class Student {

    private String firstName;
    private String lastName;
    private int gradeYear;
    private String studentID;
    private String courses = "";
    private int tuitionBalance = 0;
    private static int courseCost = 600;
    private static int id = 1000;

    // constructor: prompt user to enter name and year
    public Student() {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter student first name: ");
        this.firstName = in.nextLine();

        System.out.print("Enter student last name: ");
        this.lastName = in.nextLine();

        System.out.print("Enter student class level: \n1 - Freshman\n2 - Sophomore\n3 - Junior\n4 - Senior ");
        this.gradeYear = in.nextInt();

        setStudentID();

        System.out.println("Name: " + this.firstName + " " + this.lastName + "\nClass Level: " + this.gradeYear
                + "\nStudent ID: " + this.studentID);


    }

    // Generate ID
    private void setStudentID() {
        // Grade Level + ID
        id++;
        this.studentID = gradeYear + "" + id;
    }

    // Enroll in courses
    public void enroll() {
        //Get inside a loop, user hits 0 when done enrolling
        String courseEnrollString = "Enter course to enroll (Enter q to quit)";
        System.out.println(courseEnrollString);
        Scanner in = new Scanner(System.in);
        String course = in.nextLine();
        while (!course.equals("q")) {
            System.out.println(courseEnrollString);
            this.courses += course + "\n";
            this.tuitionBalance += courseCost;
            course = in.nextLine();
        }
        System.out.println("ENROLLED IN:\n" + this.courses);
    }

    // View balance
    public void viewBalance() {
        System.out.println("Your balance is: $" + this.tuitionBalance);
    }

    // Pay tuition
    public void payTuition() {
        viewBalance();
        System.out.print("Please enter how much you'd like to pay: $");
        Scanner in = new Scanner(System.in);
        int payment = in.nextInt();
        int balanceLeft = this.tuitionBalance - payment;
        if (balanceLeft < 0) {
            int refund = balanceLeft * -1;
            this.tuitionBalance = 0;
            viewBalance();
            System.out.println("You've been refunded $" + refund);
            }
        else {
            this.tuitionBalance = balanceLeft;
            viewBalance();

        }
    }


    // Show status
    public String toString() {
        return "\nName: " + this.firstName + " " + this.lastName +
                "\nStudent Id: " + this.studentID +
                "\nGrade Level: " + this.gradeYear +
                "\nCourses Enrolled: \n" + this.courses +
                "Balance: $" + this.tuitionBalance;
    }
}
