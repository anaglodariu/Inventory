package inventory;

public class Product {
    //Instance field declarations
    private int id;
    private String name;
    private int quantityInStock;
    private double price;
    private boolean active;

    //default constructor
    public Product() {

    }
    public Product(int id, String name, int quantityInStock, double price) {
        this.id = id;
        this.name = name;
        this.quantityInStock = quantityInStock;
        this.price = price;
        this.active = true;
    }

    //getters and setters
    public boolean getActive() {
        return active;
    }
    public void setActive(boolean active) {
        this.active = active;
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

    public double getInventoryValue() {
        return price * quantityInStock;
    }

    // the user can add to the number of units in stock
    public void addToInventory(int quantity) {
        quantityInStock += quantity;
    }

    // the user can deduct from the number of units in stock
    public void deductFromInventory(int quantity) {
        quantityInStock -= quantity;
    }

    //toString method
    @Override
    public String toString() {
        String output = "";
        output =  "Item Number      : " + id + "\n"
                + "Name             : " + name + "\n"
                + "Quantity in Stock: " + quantityInStock + "\n"
                + "Price            : " + price + " lei\n"
                + "Stock Value      : " + getInventoryValue() + " lei\n"
                + "Product Status   : " + (active ? "Active":"Discontinued") + "\n";
        return output;
    }
}
