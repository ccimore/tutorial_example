package bankAccountApp;

import java.util.LinkedList;
import java.util.List;

public class BankAccountApp {

    public static void main(String[] args) {
        List<Account> accounts = new LinkedList<Account>();


//        Checking chkAcc1 = new Checking("Tom Wilson", "123456789", 1500);
//        Savings savAcc1 = new Savings("Rich Lowe", "987654321", 25000);
//
//        savAcc1.showInfo();
//        System.out.println("****************");
//        chkAcc1.showInfo();
//
////        savAcc1.deposit(5000);
////        savAcc1.withdrawal(200);
////        savAcc1.transfer("Brokerage", 3000);
//
//        savAcc1.compound();


        // Read a CSV file then create new accounts
        String file = "C:\\Users\\cimor\\Downloads\\NewBankAccounts.csv";
        List<String[]> newAccountHolders = utilities.CSV.read(file);
        for (String[] accountHolder: newAccountHolders) {

            String name = accountHolder[0];
            String ssn = accountHolder[1];
            String accountType = accountHolder[2];
            double initDeposit = Double.parseDouble(accountHolder[3]);
//            System.out.println(name + " " + ssn + " " + accountType + " $" + initDeposit);
            if (accountType.equals("Savings")) {
//                System.out.println("OPEN A SAVINGS ACCOUNT");
                accounts.add(new Savings(name, ssn, initDeposit));
            }
            else if (accountType.equals("Checking")) {
//                System.out.println("OPEN A CHECKING ACCOUNT");
                accounts.add(new Checking(name, ssn, initDeposit));
            }
            else {
                System.out.println("ERROR READING ACCOUNT TYPE");
            }
        }

        for (Account acc : accounts) {
            System.out.println("\n********************");
            acc.showInfo();
        }

    }
}
