package admin.databasehelper;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import admin.model.BillOrder_Model;
import admin.model.BillPayment_Model;

public class BillOrderDBHelper {

    public static List<BillOrder_Model> getAllBillOrder() {
        List<BillOrder_Model> listBillOrder = new ArrayList<>();
        try (Connection cnn = ConnectDBHelper.getConnect();
                CallableStatement stm = cnn.prepareCall("{CALL getAllBillOrder()}");) {
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {

                String bILLID = rs.getString("BILLID");
                String dATETIME = rs.getString("DATETIME");
                String tABLEID = rs.getString("TABLEID");
                String dETAILBILLID = rs.getString("DETAILBILLID");
                String sUMOFPRICES = rs.getString("SUMOFPRICE");

                listBillOrder.add(new BillOrder_Model(bILLID, dATETIME, tABLEID, dETAILBILLID, sUMOFPRICES));

            }

        } catch (Exception e) {

        }

        return listBillOrder;
    }

    public static List<BillPayment_Model> getDataForBill(String IDBill) {
        List<BillPayment_Model> data = new ArrayList<>();
        try (Connection cnn = ConnectDBHelper.getConnect();
                CallableStatement stm = cnn.prepareCall("{CALL getDataForBill(?)}");) {

            stm.setString(1, IDBill);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                String fOODNAME = rs.getString("FOODNAME");
                int fOODQUANTITY = rs.getInt("FOODQUANTITY");
                int fOODPRICE = rs.getInt("FOODPRICE");
                int sUMOFPRICE = rs.getInt("SUMOFPRICE");

                BillPayment_Model billPay = new BillPayment_Model(fOODNAME, fOODQUANTITY, fOODPRICE, sUMOFPRICE);
                data.add(billPay);
            }

        } catch (Exception e) {

        }

        return data;
    }

    public static List<BillOrder_Model> filterDate(String dateStart, String dateEnd) {
        List<BillOrder_Model> data = new ArrayList<>();
        try (Connection cnn = ConnectDBHelper.getConnect();
                CallableStatement stm = cnn.prepareCall("{CALL filterDate(?,?)}");) {

            stm.setString(1, dateStart);
            stm.setString(2, dateEnd);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                String bILLID = rs.getString("BILLID");
                String dATETIME = rs.getString("DATETIME");
                String tABLEID = rs.getString("TABLEID");
                String dETAILBILLID = rs.getString("DETAILBILLID");
                String sUMOFPRICES = rs.getString("SUMOFPRICE");

                data.add(new BillOrder_Model(bILLID, dATETIME, tABLEID, dETAILBILLID, sUMOFPRICES));
            }

        } catch (Exception e) {

        }
        return data;
    }
}
