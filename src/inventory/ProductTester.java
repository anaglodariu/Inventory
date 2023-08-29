package inventory;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ProductTester {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int maxSize, menuChoice;
        maxSize = getNumProducts(in);
        if (maxSize == 0) {
            System.out.println("No products required.");
        } else {
            Product[] products = new Product[maxSize];
            addToInventory(products, in);
            do {
                menuChoice = getMenuOption(in);
                System.out.println("You chose menu option " + menuChoice);
                executeMenuChoice(products, menuChoice, in);
            } while (menuChoice != 0);

            //displayInventory(products);
        }
        in.close();
    }

    public static void displayInventory(Product[] products) {
        System.out.println("The products stored are: ");
        for (Product p : products) {
            System.out.println(p);
        }
    }

    public static void addToInventory(Product[] products, Scanner in) {
        for (int i = 0; i < products.length; i++) {
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
            //products[i].setActive(false);
        }
    }

    public static int getNumProducts(Scanner in) {
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

        return maxSize;
    }

    public static int getMenuOption(Scanner in) {
        System.out.println("MENU OPTIONS");
        String menu = """
                1. View Inventory
                2. Add Stock
                3. Deduct Stock
                4. Discontinue Product
                0. Exit
                Please enter a menu option:
                """;
        System.out.print(menu);
        int menuChoice = -1;
        do {
            try {
                menuChoice = in.nextInt();
                if (menuChoice < 0 || menuChoice > 4) {
                    throw new Exception();
                }
            } catch (InputMismatchException e1) {
                System.out.println("Cannot enter a string. Please enter a number.");
                System.out.println("Please enter a menu option:");
                // clear the buffer
                in.nextLine();

            } catch (Exception e2) {
                System.out.println("Invalid value entered. Please try again.");
                System.out.println("Please enter a menu option:");
                // clear the buffer
                in.nextLine();
            }
        } while(menuChoice < 0 || menuChoice > 4);

        return menuChoice;
    }

    public static int getProductNumber(Product[] products, Scanner in) {
        int productChoice = -1;
        System.out.println("Please choose product index from the list below:");
        for (int i = 0; i < products.length; i++) {
            System.out.println(i + ". " + products[i].getName());
        }
        do {
            try {
                productChoice = in.nextInt();
                if (productChoice < 0 || productChoice > products.length) {
                    throw new Exception();
                }
            } catch (InputMismatchException e1) {
                System.out.println("Cannot enter a string. Please enter a number.");
                // clear the buffer
                in.nextLine();

            } catch (Exception e2) {
                System.out.println("Invalid value entered. Please try again.");
                // clear the buffer
                in.nextLine();
            }
        } while(productChoice < 0 || productChoice > products.length);

        return productChoice;
    }

    public static void addInventory(Product[] products, Scanner in) {
        int productChoice, updateValue = -1;
        productChoice = getProductNumber(products, in);
        System.out.println("How many products do you want to add?");
        do {
            try {
                updateValue = in.nextInt();
                if (updateValue < 0) {
                    throw new Exception();
                }
            } catch (InputMismatchException e1) {
                System.out.println("Cannot enter a string. Please enter a number.");
                in.nextLine();

            } catch (Exception e2) {
                System.out.println("Invalid value entered. Please try again.");
                in.nextLine();
            }
        } while(updateValue < 0);
        products[productChoice].addToInventory(updateValue);
        System.out.println("Inventory updated successfully.");
    }

    public static void deductInventory(Product[] products, Scanner in) {
        int productChoice, updateValue = -1;
        productChoice = getProductNumber(products, in);
        System.out.println("How many products do you want to deduct?");
        do {
            try {
                updateValue = in.nextInt();
                if (updateValue < 0 || updateValue > products[productChoice].getQuantityInStock()) {
                    throw new Exception();
                }
            } catch (InputMismatchException e1) {
                System.out.println("Cannot enter a string. Please enter a number.");
                in.nextLine();

            } catch (Exception e2) {
                System.out.println("Invalid value entered. Please try again.");
                in.nextLine();
            }
        } while(updateValue < 0 || updateValue > products[productChoice].getQuantityInStock());
        products[productChoice].deductFromInventory(updateValue);
        System.out.println("Inventory updated successfully.");
    }

    public static void discontinueInventory(Product[] products, Scanner in) {
        int productChoice;
        productChoice = getProductNumber(products, in);
        products[productChoice].setActive(false);
        System.out.println("Product discontinued successfully.");
    }

    public static void executeMenuChoice(Product[] products, int menuChoice, Scanner in) {
        switch (menuChoice) {
            case 0:
                System.out.println("Exiting program.");
                break;
            case 1:
                System.out.println("View Product List");
                displayInventory(products);
                break;
            case 2:
                System.out.println("Add Stock");
                addInventory(products, in);
                break;
            case 3:
                System.out.println("Deduct Stock");
                deductInventory(products, in);
                break;
            case 4:
                System.out.println("Discontinue Stock");
                discontinueInventory(products, in);
                break;
            default:
                System.out.println("Invalid menu choice.");
        }
    }
}
