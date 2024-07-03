package bankAccountApp;

public abstract class Account implements IBaseRate {
    // list comon properties for savings and checking accounts
    private static int index = 10000;
    private String name;
    private String ssn;
    protected String accountNumber;
    private double balance = 0;
    protected double rate;


    // constructor to set base properties and initialize the account
    public Account(String name, String ssn, double deposit) {
        this.name = name;
        this.ssn =ssn;
        this.balance += deposit;

        // set account number
        this.accountNumber = setAccountNumber();
        this.setRate();
    }

    public abstract void setRate();


    private String setAccountNumber() {
        String lastTwoSSN = ssn.substring(ssn.length()-2, ssn.length());
        int uniqueID = index;
        index++;
//        String random3Digit = "";
//        for (int i = 0; i < 3; i++) {
//            int randomNumber = (int) (Math.random() * 10);
//            random3Digit += randomNumber;
//        }
        int random3DigitNumber = (int) (Math.random() * Math.pow(10, 3));
        this.accountNumber = lastTwoSSN + uniqueID + random3DigitNumber;
        return this.accountNumber;
    }

    // was playing with converting between int and string for the account number.  Maybe too much work.
//    private int setAccountNumber() {
//        String lastTwoSSNstring = String.valueOf(this.ssn).substring(7);
//        int lastTwoSSN;
//        try {
//            lastTwoSSN = Integer.parseInt(lastTwoSSNstring);
//        }
//        catch (NumberFormatException e) {
//            lastTwoSSN = 0;
//            System.out.println(e.getMessage());
//        }
//        return lastTwoSSN;
//    }

    public void compound() {
        double accruedInterest = this.balance * (this.rate/100);
        this.balance += accruedInterest;
        System.out.println("ACCRUED INTEREST: $" + accruedInterest);
        this.printBalance();
    }

    // list common methods
    public void deposit(double amount) {
        this.balance += amount;
        System.out.println("Depositing $" + amount);
        this.printBalance();
    }

    public void withdrawal(double amount) {
        this.balance -= amount;
        System.out.println("Withdrawing $" + amount);
        if (this.balance < 0) {
            System.out.println("You are overdrawn!");
        }
        this.printBalance();
    }

    public void transfer(String toWhere, double amount) {
        this.balance -= amount;
        System.out.println("Transferring $" + amount + " to " + toWhere + ".");
        this.printBalance();
    }

    public void printBalance() {
        System.out.println("YOUR BALANCE: $" + this.balance);
    }
    public void showInfo() {
        System.out.println(
                "NAME: " + this.name +
                        "\nACCOUNT NUMBER: " + this.accountNumber +
                        "\nBALANCE: " + this.balance +
                        "\nRATE: " + this.rate + "%"
        );
    }

}
