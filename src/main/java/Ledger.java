import pojo.LoanDetails;
import pojo.LumpSum;

import java.util.HashMap;
import java.util.Map;

public class Ledger {
    //key -> bankName + customerName
    private final Map<String, LoanDetails> map;

    public Ledger(){
        this.map = new HashMap<>();
    }

    public void loan(String bank, String customer, int principal, int noOfYrs, int interestRate){
        map.put(bank+customer, new LoanDetails(principal, interestRate, noOfYrs));
    }

    public void payment(String bank, String customer, int lumpSum, int emiNo){
        LoanDetails loanDetails = map.get(bank+customer);
        loanDetails.getLumpSums().add(new LumpSum(lumpSum, emiNo));
    }

    public void balance(String bank, String customer, int emiNo){
        LoanDetails loanDetails = map.get(bank+customer);
        int totalAmount = loanDetails.getEmiAmount() * emiNo;
        for(LumpSum lumpSum : loanDetails.getLumpSums()){
            if(lumpSum.getEmiNo()<=emiNo){
                totalAmount+= lumpSum.getAmount();
            }
        }
        int amountLeft = loanDetails.getRepayAmount() - totalAmount;
        int emiLeft = (int) Math.ceil((float)amountLeft/loanDetails.getEmiAmount());
        //System.out.println(loanDetails);
        System.out.println(bank + " " + customer + " " + totalAmount + " " + emiLeft);

    }


}
