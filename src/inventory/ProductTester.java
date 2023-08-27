package inventory;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ProductTester {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int maxSize = -1;
        do  {
            try {
                System.out.println("Enter the maximum number of products you wish to store." +
                        "\nEnter 0 (zero) if you do not wish to store any products. ");
                maxSize = in.nextInt();
                if (maxSize < 0) {
                    throw new Exception();
                }
            } catch (InputMismatchException e1) {
                System.out.println("Cannot enter a string. Please enter a number.");
                // clear the buffer
                in.nextLine();

            } catch (Exception e2) {
                System.out.println("Negative value entered. Please try again.");
                // clear the buffer
                in.nextLine();
            }
        } while (maxSize < 0);
        if (maxSize == 0) {
            System.out.println("No products required.");
        } else {
            Product[] products = new Product[maxSize];
            for (int i = 0; i < maxSize; i++) {
                System.out.println("Enter the product id: ");
                int tempId = in.nextInt();
                String temp = in.nextLine();
                System.out.println("Enter the product name: ");
                String tempName = in.nextLine();
                System.out.println("Enter the product quantity: ");
                int tempQty = in.nextInt();
                System.out.println("Enter the product price: ");
                double tempPrice = in.nextDouble();
                products[i] = new Product(tempId, tempName, tempQty, tempPrice);
                products[i].setActive(false);

            }
            System.out.println("The products stored are: ");
            for (Product p : products) {
                System.out.println(p);
            }
        }
        in.close();
    }
}
