package inventory;

public class CD extends Product {
    String artist;
    int numberOfSongs;
    String label;

    // constructor
    public CD(int id, String name, int quantityInStock, double price, String artist, int numberOfSongs, String label) {
        super(id, name, quantityInStock, price);
        this.artist = artist;
        this.numberOfSongs = numberOfSongs;
        this.label = label;
    }

    // getters and setters
    public String getArtist() {
        return artist;
    }
    public void setArtist(String artist) {
        this.artist = artist;
    }

    public int getNumberOfSongs() {
        return numberOfSongs;
    }
    public void setNumberOfSongs(int numberOfSongs) {
        this.numberOfSongs = numberOfSongs;
    }

    public String getLabel() {
        return label;
    }
    public void setLabel(String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return "\nCD:" +
                "\nItem Number      : " + super.getId() +
                "\nName             : " + super.getName() +
                "\nArtist           : " + artist +
                "\nSongs on Album   : " + numberOfSongs +
                "\nRecord Label     : " + label +
                "\nQuantity in Stock: " + super.getQuantityInStock() + " lei" +
                "\nPrice            : " + super.getPrice() + " lei" +
                "\nStock Value      : " + super.getInventoryValue() +
                "\nProduct Status   : " + (super.getActive() ? "Active":"Discontinued");
    }

}
