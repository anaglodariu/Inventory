package inventory;

import java.util.Scanner;

public class ProductTester {
    // main class
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int tempId;
        String tempName;
        int tempQty;
        double tempPrice;
        Product movie1;
        for (int i = 0; i < 1; i++) {
            System.out.println("Enter the product id: ");
            tempId = in.nextInt();
            String temp = in.nextLine();
            System.out.println("Enter the product name: ");
            tempName = in.nextLine();
            //String temp = in.nextLine();
            System.out.println("Enter the product quantity: ");
            tempQty = in.nextInt();
            System.out.println("Enter the product price: ");
            tempPrice = in.nextDouble();

            //temp = in.nextLine();
            movie1 = new Product(tempId, tempName, tempQty, tempPrice);
            movie1.setActive(false);
            System.out.println(movie1);
        }
        in.close();

//        System.out.println("Enter the product id: ");
//        tempId = in.nextInt();
//        System.out.println("Enter the product name: ");
//        tempName = in.next();
//        String temp = in.nextLine();
//        System.out.println("Enter the product quantity: ");
//        tempQty = in.nextInt();
//        System.out.println("Enter the product price: ");
//        tempPrice = in.nextDouble();
//        //temp = in.nextLine();
//        Product movie1 = new Product(tempId, tempName, tempQty, tempPrice);
//        System.out.println(movie1);
        //        Product movie1 = new Product(1, "Ice Age 1", 1, 20);
//        Product movie2 = new Product(2, "Ice Age 2", 1, 20);
//        Product movie3 = new Product();
//        System.out.println(movie1);
//        System.out.println(movie2);
//        System.out.println(movie3);
    }
}
