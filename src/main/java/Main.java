import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        File file = new File(args[0]);
        Ledger ledger = new Ledger();
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()){
            String line = scanner.nextLine();
            String[] arguments = line.split(" ");
            String command = arguments[0];
            String bankName = arguments[1];
            String borrowerName = arguments[2];
            int lumSumpAmount;
            int principal;
            int emiNo;
            int noOfYrs;
            int interestRate;
            if(command.equalsIgnoreCase(CommandType.LOAN.toString())){
                principal = Integer.parseInt(arguments[3]);
                noOfYrs = Integer.parseInt(arguments[4]);
                interestRate = Integer.parseInt(arguments[5]);
                ledger.loan(bankName, borrowerName, principal, noOfYrs, interestRate);

            } else if(command.equalsIgnoreCase(CommandType.BALANCE.toString())){
                emiNo = Integer.parseInt(arguments[3]);
                ledger.balance(bankName, borrowerName, emiNo);

            } else if(command.equalsIgnoreCase(CommandType.PAYMENT.toString())){
                lumSumpAmount = Integer.parseInt(arguments[3]);
                emiNo = Integer.parseInt(arguments[4]);
                ledger.payment(bankName, borrowerName, lumSumpAmount, emiNo);
            } else{
                throw new RuntimeException("Unsupported command");
            }
        }
    }
}
