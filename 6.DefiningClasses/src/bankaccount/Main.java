package bankaccount;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in))) {
            final String CREATE_COMMAND = "Create";
            final String DEPOSIT_COMMAND = "Deposit";
            final String GET_INTEREST_COMMAND = "GetInterest";
            final String SET_INTEREST_COMMAND = "SetInterest";

            Map<Integer, BankAccount> bankAccounts = new HashMap<>();

            var input = bfr.readLine().split("\\s+");
            while (!input[0].equalsIgnoreCase("end")) {

                var command = input[0];
                switch (command) {
                    case CREATE_COMMAND: {
                        var bankAccount = new BankAccount();
                        bankAccounts.put(bankAccount.getId(), bankAccount);
                        System.out.printf("Account ID%d created%n",
                                bankAccount.getId());
                        break;
                    }
                    case DEPOSIT_COMMAND: {
                        var accountID = Integer.parseInt(input[1]);
                        var depositAmount = Integer.parseInt(input[2]);
                        if (bankAccounts.containsKey(accountID)) {
                            bankAccounts.get(accountID).deposit(depositAmount);
                            System.out.printf("Deposited %d to ID%d%n",
                                    depositAmount,
                                    accountID);
                        } else {
                            System.out.println("Account does not exist");
                        }
                        break;
                    }
                    case SET_INTEREST_COMMAND: {
                        var interestRate = Double.parseDouble(input[1]);
                        BankAccount.setInterestRate(interestRate);
                        break;
                    }
                    case GET_INTEREST_COMMAND: {
                        var accountID = Integer.parseInt(input[1]);
                        var years = Integer.parseInt(input[2]);

                        if (bankAccounts.containsKey(accountID)) {
                            var profit = bankAccounts.get(accountID).getProfitAfterYears(years);
                            System.out.printf("%.2f%n",
                                    profit);

                        } else {
                            System.out.println("Account does not exist");
                        }

                        break;
                    }
                }

                input = bfr.readLine().split("\\s+");
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
