package admin.databasehelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import admin.model.BillOrder_Model;

public class BillOrderDBHelper {
    public static List<BillOrder_Model> getAllBillOrder() {
        List<BillOrder_Model> listBillOrder = new ArrayList<>();
        try (
            Connection cnn = ConnectDBHelper.getConnect(); 
            PreparedStatement stm = cnn.prepareStatement("SELECT * FROM `tblbill` WHERE BillStatus = 'On'");) {

                ResultSet rs = stm.executeQuery();
                while(rs.next())
            {
                
                String billID = rs.getString("BILLID");
                String dateTime = rs.getString("DATETIME");
                String TABLEID = rs.getString("TABLEID");
                String DETAILBILLID = rs.getString("DETAILBILLID");
                String SUMOFPRICE = rs.getString("SUMOFPRICE");
                String BILLSTATUS = rs.getString("BILLSTATUS");
                
                BillOrder_Model listBill = new BillOrder_Model(billID, dateTime, TABLEID, DETAILBILLID, SUMOFPRICE, BILLSTATUS);
                listBillOrder.add(listBill);
                    
            }

        } catch (Exception e) {
            
        }

        return listBillOrder;
    }
}
