package bankAccountApp;

public class Checking extends Account{
    // list properties specific to checking account
    // 12 digit debit card and 4 digit pin
    // first character in account is 2 for checking
    private int debitCardNumber;
    private int debitCardPIN;



    // Constructor to initialize checking account properties
    public Checking(String name, String ssn, double deposit) {
        super(name, ssn, deposit);
        this.accountNumber = "2" + this.accountNumber;
//        System.out.println("NEW CHECKING ACCOUNT");
//        System.out.println("ACCOUNT NUMBER: " + this.accountNumber);
        this.setDebitCard();

    }

    @Override
    public void setRate() {
        double checkingRate = .15 * getBaseRate();
        this.rate = checkingRate;
    }

    private void setDebitCard() {
        this.debitCardNumber = (int) (Math.random() * Math.pow(10, 12));
        this.debitCardPIN = (int) (Math.random() * Math.pow(10, 4));
//        System.out.println("Card: " + this.debitCardNumber + "\nPIN: " + this.debitCardPIN);
    }

    //List any methods specific to the checking account
    public void showInfo() {
        super.showInfo();
        System.out.println(
                "Your Checking Account Features:" +
                        "\nDebit Card Number: " + this.debitCardNumber +
                        "\nDebit Card Pin: " + this.debitCardPIN
                        );
    }
}
