package bankAccountApp;

public class Savings extends Account{
    // List properties specific to the Savings account
    private int safetyDepositBoxID;
    private int safetyDepositBoxKey;


    // Constructor to intialize setting for the Savings properties
    public Savings(String name, String ssn, double deposit) {
        super(name, ssn, deposit);
        this.accountNumber = "1" + this.accountNumber;
//        System.out.println("NEW SAVINGS ACCOUNT");
//        System.out.println("ACCOUNT NUMBER: " + this.accountNumber);
        this.setSafetyDepositBox();

    }

    @Override
    public void setRate() {
        double savingsRate = getBaseRate() - .25;
        this.rate = savingsRate;
    }


    // List any methods specific to savings account
    private void setSafetyDepositBox() {
        this.safetyDepositBoxID = (int) (Math.random() * Math.pow(10, 3));
        this.safetyDepositBoxKey = (int) (Math.random() * Math.pow(10, 4));
    }
    public void showInfo() {
        System.out.println("ACCOUNT TYPE: SAVINGS");
        super.showInfo();
        System.out.println(
                "Your Savings Account Features:" +
                        "\nSafety Deposit Box ID: " + this.safetyDepositBoxID +
                        "\nSafety Deposit Box Code: " + this.safetyDepositBoxKey
        );
    }
}
