package inventory;

public class Product {
    //Instance field declarations
    private int id;
    private String name;
    private int quantityInStock;
    private double price;

    //default constructor
    public Product() {

    }
    public Product(int id, String name, int quantityInStock, double price) {
        this.id = id;
        this.name = name;
        this.quantityInStock = quantityInStock;
        this.price = price;
    }

    //getters and setters
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

     public int getQuantityInStock() {
        return quantityInStock;
    }
    public void setQuantityInStock(int quantityInStock) {
        this.quantityInStock = quantityInStock;
    }

     public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }

    //toString method
    @Override
    public String toString() {
        String output = "";
        output =  "Item Number      : " + id + "\n"
                + "Name             : " + name + "\n"
                + "Quantity in Stock: " + quantityInStock + "\n"
                + "Price            : " + price + "lei\n";
        return output;
    }
}
