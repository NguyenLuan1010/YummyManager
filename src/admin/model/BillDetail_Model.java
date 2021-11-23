package admin.model;

public class BillDetail_Model {
    int codeNumberBill;
    String date;
    String cashier;
    double totalPay;
    
    public BillDetail_Model(int codeNumberBill, String date, String cashier, double totalPay) {
        this.codeNumberBill = codeNumberBill;
        this.date = date;
        this.cashier = cashier;
        this.totalPay = totalPay;
    }

    public int getCodeNumberBill() {
        return codeNumberBill;
    }

    public void setCodeNumberBill(int codeNumberBill) {
        this.codeNumberBill = codeNumberBill;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCashier() {
        return cashier;
    }

    public void setCashier(String cashier) {
        this.cashier = cashier;
    }

    public double getTotalPay() {
        return totalPay;
    }

    public void setTotalPay(double totalPay) {
        this.totalPay = totalPay;
    }

    
    
}