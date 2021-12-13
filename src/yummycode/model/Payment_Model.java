package yummycode.model;

public class Payment_Model {
    double price;
    String tableID;
    int member;

    public Payment_Model(double price, String tableID, int member) {
        this.price = price;
        this.tableID = tableID;
        this.member = member;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getTableID() {
        return tableID;
    }

    public void setTableID(String tableID) {
        this.tableID = tableID;
    }

    public int getMember() {
        return member;
    }

    public void setMember(int member) {
        this.member = member;
    }

}
