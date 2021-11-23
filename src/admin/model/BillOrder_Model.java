package admin.model;

public class BillOrder_Model {
    String BILLID;
    String DATETIME;
    String TABLEID;
    String DETAILBILLID;
    String SUMOFPRICES;
    String BILLSTATUS;

    public BillOrder_Model(String bILLID, String dATETIME, String tABLEID, String dETAILBILLID, String sUMOFPRICES,String bILLSTATUS) {
        BILLID = bILLID;
        DATETIME = dATETIME;
        TABLEID = tABLEID;
        DETAILBILLID = dETAILBILLID;
        SUMOFPRICES = sUMOFPRICES;
        BILLSTATUS = bILLSTATUS;
    }

    public String getBILLID() {
        return BILLID;
    }

    public void setBILLID(String bILLID) {
        BILLID = bILLID;
    }

    public String getDATETIME() {
        return DATETIME;
    }

    public void setDATETIME(String dATETIME) {
        DATETIME = dATETIME;
    }

    public String getTABLEID() {
        return TABLEID;
    }

    public void setTABLEID(String tABLEID) {
        TABLEID = tABLEID;
    }

    public String getDETAILBILLID() {
        return DETAILBILLID;
    }

    public void setDETAILBILLID(String dETAILBILLID) {
        DETAILBILLID = dETAILBILLID;
    }

    public String getSUMOFPRICES() {
        return SUMOFPRICES;
    }

    public void setSUMOFPRICEString(String sUMOFPRICES) {
        SUMOFPRICES = sUMOFPRICES;
    }

    public String getBILLSTATUS() {
        return BILLSTATUS;
    }

    public void setBILLSTATUS(String bILLSTATUS) {
        BILLSTATUS = bILLSTATUS;
    }

}
