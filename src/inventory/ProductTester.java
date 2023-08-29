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
        int stockChoice = -1;
        String prompt = """
               What type of product do you want to add?
                1. CD
                2. DVD
                PLease enter the product type:
                """;

        for (int i = 0; i < products.length; i++) {
            System.out.print(prompt);
            do {
                try {
                    stockChoice = in.nextInt();
                    if (stockChoice < 1 || stockChoice > 2) {
                        throw new Exception();
                    }
                } catch (InputMismatchException e1) {
                    System.out.println("Cannot enter a string. Please enter 1 or 2.");
                    System.out.print(prompt);
                    in.nextLine();
                } catch (Exception e2) {
                    System.out.println("Only number 1 or 2 are allowed. Please try again.");
                    System.out.print(prompt);
                    in.nextLine();
                }
            } while(stockChoice < 1 || stockChoice > 2);
            switch (stockChoice) {
                case 1:
                    addCDToInventory(products, in, i);
                    break;
                case 2:
                    addDVDToInventory(products, in, i);
                    break;
                default:
            }
        }
    }

    public static void addCDToInventory(Product[] products, Scanner in, int index) {
        System.out.println("Enter the product id: ");
        int tempId = in.nextInt();
        String temp = in.nextLine();
        System.out.println("Enter the CD name: ");
        String tempName = in.nextLine();
        System.out.println("Enter the product quantity: ");
        int tempQty = in.nextInt();
        System.out.println("Enter the product price: ");
        double tempPrice = in.nextDouble();
        temp = in.nextLine();
        System.out.println("Enter the artist: ");
        String tempArtist = in.nextLine();
        System.out.println("Enter the number of songs: ");
        int tempNumSongs = in.nextInt();
        temp = in.nextLine();
        System.out.println("Enter the record label: ");
        String tempLabel = in.nextLine();
        products[index] = new CD(tempId, tempName, tempQty, tempPrice, tempArtist, tempNumSongs, tempLabel);
    }

    public static void addDVDToInventory(Product[] products, Scanner in, int index) {
        System.out.println("Enter the product id: ");
        int tempId = in.nextInt();
        String temp = in.nextLine();
        System.out.println("Enter the DVD name: ");
        String tempName = in.nextLine();
        System.out.println("Enter the product quantity: ");
        int tempQty = in.nextInt();
        System.out.println("Enter the product price: ");
        double tempPrice = in.nextDouble();
        System.out.println("Enter the length in minutes: ");
        int tempLength = in.nextInt();
        System.out.println("Enter the age rating: ");
        int tempAgeRating = in.nextInt();
        temp = in.nextLine();
        System.out.println("Enter the film studio name: ");
        String tempFilmStudio = in.nextLine();
        products[index] = new DVD(tempId, tempName, tempQty, tempPrice, tempLength, tempAgeRating, tempFilmStudio);
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
                in.nextLine();

            } catch (Exception e2) {
                System.out.println("Negative value entered. Please try again.");
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
                in.nextLine();

            } catch (Exception e2) {
                System.out.println("Invalid value entered. Please try again.");
                System.out.println("Please enter a menu option:");
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
