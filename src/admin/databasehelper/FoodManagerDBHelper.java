package admin.databasehelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import admin.model.FoodItem_model;

public class FoodManagerDBHelper {





    public static List<FoodItem_model> getAllItemFood() {
        List<FoodItem_model> listItem = new ArrayList<>();

        try (Connection connect = ConnectDBHelper.getConnect();
                // CallableStatement stm = connect.prepareCall("{call getAllAccount()}");) {
                PreparedStatement stm = connect.prepareStatement("SELECT * FROM `tblfoodmenu` WHERE `FOODSTATUS` = 'Active'");) {
            stm.execute();
            ResultSet rs = stm.getResultSet();
            while (rs.next()) {
                String imgFood = rs.getString("FOODIMAGE");
                String nameFood = rs.getString("FOODNAME");
                Double priceFood = rs.getDouble("FOODPRICE");

                FoodItem_model item = new FoodItem_model(imgFood, nameFood, priceFood);

                listItem.add(item);
            }
        } catch (Exception e) {
            System.out.println("Loi:" + e.getMessage());
        }
        return listItem;
    }
}
