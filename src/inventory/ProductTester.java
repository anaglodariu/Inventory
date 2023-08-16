package inventory;

public class ProductTester {
    // main class
    public static void main(String[] args) {
        Product movie1 = new Product(1, "Ice Age 1", 1, 20);
        Product movie2 = new Product(2, "Ice Age 2", 1, 20);
        Product movie3 = new Product();
        System.out.println(movie1);
        System.out.println(movie2);
        System.out.println(movie3);
    }
}
