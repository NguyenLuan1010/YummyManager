package admin.model;

public class BillPayment_Model {
    String FOODNAME;
    int FOODQUANTITY;
    int FOODPRICE;
    int SUMOFPRICE;

    public BillPayment_Model(String fOODNAME, int fOODQUANTITY, int fOODPRICE, int sUMOFPRICE) {
        FOODNAME = fOODNAME;
        FOODQUANTITY = fOODQUANTITY;
        FOODPRICE = fOODPRICE;
        SUMOFPRICE = sUMOFPRICE;
    }

    public String getFOODNAME() {
        return FOODNAME;
    }

    public void setFOODNAME(String fOODNAME) {
        FOODNAME = fOODNAME;
    }

    public int getFOODQUANTITY() {
        return FOODQUANTITY;
    }

    public void setFOODQUANTITY(int fOODQUANTITY) {
        FOODQUANTITY = fOODQUANTITY;
    }

    public int getFOODPRICE() {
        return FOODPRICE;
    }

    public void setFOODPRICE(int fOODPRICE) {
        FOODPRICE = fOODPRICE;
    }

    public int getSUMOFPRICE() {
        return SUMOFPRICE;
    }

    public void setSUMOFPRICE(int sUMOFPRICE) {
        SUMOFPRICE = sUMOFPRICE;
    }

}
