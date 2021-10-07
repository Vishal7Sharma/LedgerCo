package pojo;

import java.util.ArrayList;
import java.util.List;

public class LoanDetails {
    int principal;
    int interestRate;
    int noOfYrs;
    List<LumpSum> lumpSums;
    int emiAmount;
    int repayAmount;

    public LoanDetails(int principal, int interestRate, int noOfYrs) {
        this.principal = principal;
        this.interestRate = interestRate;
        this.noOfYrs = noOfYrs;
        this.lumpSums = new ArrayList<>();
        this.repayAmount = (int) Math.ceil(((float)principal*interestRate*noOfYrs/100 + principal));
        this.emiAmount = Math.round(((float)repayAmount)/(noOfYrs*12));
    }

    public int getPrincipal() {
        return principal;
    }

    public int getRepayAmount() {
        return repayAmount;
    }

    public int getEmiAmount(){
        return emiAmount;
    }

    public void setPrincipal(int principal) {
        this.principal = principal;
    }

    public int getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(int interestRate) {
        this.interestRate = interestRate;
    }

    public int getNoOfYrs() {
        return noOfYrs;
    }

    public void setNoOfYrs(int noOfYrs) {
        this.noOfYrs = noOfYrs;
    }

    public List<LumpSum> getLumpSums() {
        return lumpSums;
    }

    @Override
    public String toString() {
        return "pojo.LoanDetails{" +
                "principal=" + principal +
                ", interestRate=" + interestRate +
                ", noOfYrs=" + noOfYrs +
                ", lumpSums=" + lumpSums +
                ", emiAmount=" + emiAmount +
                ", repayAmount=" + repayAmount +
                '}';
    }
}
