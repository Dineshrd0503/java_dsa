package logicwhileproject.model;

public class Expense {
    private int id;
    private String name;
    private double price;
    private String date;
    private String desc;
    private String category;
    public Expense(){

    }

    public Expense(int id, String date, double price, String name,String desc, String category) {
        this.id = id;
        this.date = date;
        this.price = price;
        this.name = name;
        this.desc=desc;
        this.category = category;
    }

    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDesc() {
        return desc;
    }
    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "Expense{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", date='" + date + '\'' +
                ", desc='" + desc + '\'' +
                ", category='" + category + '\'' +
                '}';
    }
}
