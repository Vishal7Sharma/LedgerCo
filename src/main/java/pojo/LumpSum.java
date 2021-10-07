package pojo;

public class LumpSum {
    int amount;
    int emiNo;

    public LumpSum(int amount, int emiNo) {
        this.amount = amount;
        this.emiNo = emiNo;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getEmiNo() {
        return emiNo;
    }

    public void setEmiNo(int emiNo) {
        this.emiNo = emiNo;
    }
}
