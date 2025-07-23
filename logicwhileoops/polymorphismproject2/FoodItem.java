package logicwhileoops.polymorphismproject2;

public abstract class FoodItem {
    int itemId;
    String itemName;
    double pricePerUnit;
    int qunatity;
    double gst=0.12;
    public double calculateTotalPrice() {
        double totalPrice = pricePerUnit * qunatity;
        double gstAmount = totalPrice * gst;
        return totalPrice + gstAmount;
    }

    @Override
    public String toString() {
        return "FoodItem{" +
                "itemId=" + itemId +
                ", itemName='" + itemName + '\'' +
                ", pricePerUnit=" + pricePerUnit +
                ", qunatity=" + qunatity +
                ", gst=" + gst +
                '}';
    }

    public abstract double calculateBill();

    
}

