package admin.model;

import javafx.scene.control.Button;

public class BillOrder_Model {
    private String BILLID;
    private String DATETIME;
    private String TABLEID;
    private String DETAILBILLID;
    private String SUMOFPRICES;
    public static Button SEEDETAIL;

    public BillOrder_Model(String bILLID, String dATETIME, String tABLEID, String dETAILBILLID, String sUMOFPRICES) {
        BILLID = bILLID;
        DATETIME = dATETIME;
        TABLEID = tABLEID;
        DETAILBILLID = dETAILBILLID;
        SUMOFPRICES = sUMOFPRICES;
        SEEDETAIL = new Button("Detail");
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

    public void setSUMOFPRICES(String sUMOFPRICES) {
        SUMOFPRICES = sUMOFPRICES;
    }

    public Button getSEEDETAIL() {
        return SEEDETAIL;
    }

    public void setSEEDETAIL(Button sEEDETAIL) {
        SEEDETAIL = sEEDETAIL;
    }

}
