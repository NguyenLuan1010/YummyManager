package admin.model;

public class FoodItem_model {
    String ImgFood;
    String NameFood;
    double PriceFood;

    public FoodItem_model(String imgFood, String nameFood, double priceFood) {
        ImgFood = imgFood;
        NameFood = nameFood;
        PriceFood = priceFood;
    }

    public String getImgFood() {
        return ImgFood;
    }

    public void setImgFood(String imgFood) {
        ImgFood = imgFood;
    }

    public String getNameFood() {
        return NameFood;
    }

    public void setNameFood(String nameFood) {
        NameFood = nameFood;
    }

    public double getPriceFood() {
        return PriceFood;
    }

    public void setPriceFood(double priceFood) {
        PriceFood = priceFood;
    }
    
}
