package inventory;

public class DVD extends Product {
    int length; // in minutes
    int ageRating;
    String filmStudio;

    // constructor
    public DVD(int id, String name, int quantityInStock, double price, int length, int ageRating, String filmStudio) {
        super(id, name, quantityInStock, price);
        this.length = length;
        this.ageRating = ageRating;
        this.filmStudio = filmStudio;
    }

    // getters and setters
    public int getLength() {
        return length;
    }
    public void setLength(int length) {
        this.length = length;
    }

    public int getAgeRating() {
        return ageRating;
    }
    public void setAgeRating(int ageRating) {
        this.ageRating = ageRating;
    }

    public String getFilmStudio() {
        return filmStudio;
    }
    public void setFilmStudio(String filmStudio) {
        this.filmStudio = filmStudio;
    }
    @Override
    // add a 5% restocking fee to the inventory value of the product
    public double getInventoryValue() {
        return (double) 105 / 100 * super.getPrice() * super.getQuantityInStock();
    }
    @Override
    public String toString() {
        return "\nDVD:" +
                "\nItem Number      : " + super.getId() +
                "\nName             : " + super.getName() +
                "\nMovie Length     : " + length + " minutes" +
                "\nAge Rating       : " + ageRating +
                "\nFilm Studio      : " + filmStudio +
                "\nQuantity in Stock: " + super.getQuantityInStock() +
                "\nPrice            : " + super.getPrice() + " lei" +
                "\nStock Value      : " + getInventoryValue() + " lei" +
                "\nProduct Status   : " + (super.getActive() ? "Active":"Discontinued");
    }
}
