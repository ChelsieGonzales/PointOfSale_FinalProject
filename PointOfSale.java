import java.util.Scanner;
public class PointOfSale {
    public static String[] products = {"Kitcat chicken", "Monge proteins", "Fancy Feast___", "Goodest Cat___", "Pet Brush_____", "Cat Scratch___", "Pet clipper___", "Cat Bowl______", "Mouse Toy_____", "Pet collars__", "TeethCatnip__", "Pet Clothe____"};
    public static double[] prices = {94.99, 179.99, 139.99, 23.99, 59.75, 70.55, 23.25, 43.25, 16.05, 14.99, 23.25, 89.25};
    public static int[] inventory = {95, 95, 95, 95, 54, 54, 54, 54, 27, 27, 27, 27};
    public static int[] quantities = new int[products.length];
   
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String user, pass;
       
        // User authentication
        System.out.print("\nEnter Username: ");
        user = scanner.nextLine();
        System.out.print("\nEnter Password: ");
        pass = scanner.nextLine();
       
        if (user.equalsIgnoreCase("admin") && pass.equalsIgnoreCase("cashier")) {
            System.out.println("\n ");
            System.out.println("******************************************************************");
            System.out.println("********************* Welcome to Meow at Yah *********************");
            System.out.println("******************************************************************");
            System.out.println("  ");
        } else {
            System.out.println("Authentication failed. Exiting...");
            System.exit(0);
        }
   
        //choices
        while (true) {
            System.out.println("1. List of the products");
            System.out.println("2. Order");
            System.out.println("3. Order Information");
            System.out.println("4. Billing And Receipt");
            System.out.println("5. Search A Product");
            System.out.println("6. Add Product");
            System.out.println("7. Delete Product");
            System.out.println("8. Update A Product");
            System.out.println("9. Exit");
            System.out.print("\nEnter your choice: ");
   
            int choice = scanner.nextInt();
   
            switch (choice) {
                case 1:
                    displayMenu();
                    break;
                case 2:
                    takeOrder(scanner);
                    break;
                case 3:
                    showOrderInformation();
                    break;
                case 4:
                    processBilling(scanner);
                    break;
                case 5:
                    searchProduct(scanner);
                    break;
                case 6:
                    addProduct(scanner);
                    break;
                case 7:
                    deleteProduct(scanner);
                    break;
                case 8:
                    updateProduct(scanner);
                    break;
                case 9:
                    System.out.println("Exiting...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Kindly, try again.");
            }
   
            System.out.println("\n------------------------------------------------------------------\n");

            //another transaction
            System.out.print("Do you want another transaction? (y/n): ");
            String anotherTransaction = scanner.next().toLowerCase();
   
            if (!anotherTransaction.equals("y")) {
                System.out.println("\nThank you for visiting Meow at Yah. Have a great day!");
                System.exit(0);
            }
        }
    }
   
    //displaying the menu (choice 1)
    public static void displayMenu() {
        System.out.println("\n*******************************************************************");
        System.out.println("Product\t\t\t\tPrice\t\t\tInventory");
        System.out.println("*******************************************************************");
            for (int i = 0; i < products.length; i++) {
        System.out.println((i + 1) + ". " + products[i] + "\t\tPHP" + prices[i] + "\t\t" + inventory[i]);
    }
}

    //ordering (choice 2)
    public static void takeOrder(Scanner scanner) {
        do {
            displayMenu();
            System.out.println("******************************************************************");
            System.out.print("\nEnter the product's index: ");
            int index = scanner.nextInt();
           
            index --; // Adjust index to 0-based

            if (index >= 0 && index < products.length && inventory[index] > 0) {
                System.out.println("------------------------------------------------------------------");
                    System.out.print("Enter the quantity: ");
                    int quantity = scanner.nextInt();
       
                    if (quantity > 0 && quantity <= inventory[index]) {
                        double total = prices[index] * quantity;
                        System.out.println("------------------------------------------------------------------");
                        System.out.println("Total: PHP" + total);
                        inventory[index] -= quantity;
                        quantities[index] += quantity;
                        System.out.println("------------------------------------------------------------------");
                        System.out.println("\nOrder placed successfully!");
                    } else {
                        System.out.println("Invalid quantity. Please try again.");
                    }
                } else {
                    System.out.println("Invalid product index. Please try again.");
                }

                System.out.println("------------------------------------------------------------------");
                System.out.print("\nDo you want to order again? (y/n): ");
            } while (scanner.next().equalsIgnoreCase("y"));
        }
       
    //order information(choice 3)
    public static void showOrderInformation() {
        System.out.println("*******************************************************************");
        System.out.println("Order Information:");
        for (int i = 0; i < products.length; i++) {
            if (quantities[i] > 0) {
                System.out.println(products[i] + " - Quantity: " + quantities[i] + " - Total: PHP" + (quantities[i] * prices[i]));
            }
        }
    }    

    //payment and receipt (choice 4)
    public static void processBilling(Scanner scanner) {
        System.out.println("                           MEOW AT YAH                             ");
        System.out.println("                    Pinagkawitan Lipa City                         ");
        System.out.println("                     TEL: +456-468-987-02                          ");
        System.out.println("\n*******************************************************************");
        System.out.println("Product\t\t\tQuantity\t\t\tTotal");
        for (int i = 0; i < products.length; i++) {
            if (quantities[i] > 0) {
                System.out.println(products[i] + "        Quantity: " + quantities[i] + "\t\tTotal: PHP" + (quantities[i] * prices[i]));
            }
        }
        double totalAmount = calculateTotalAmount();
        System.out.println("------------------------------------------------------------------");
        System.out.println("\nTotal amount: PHP" + totalAmount);
        System.out.print("Enter the payment amount: ");
        double paymentAmount = scanner.nextDouble();

        if (paymentAmount >= totalAmount) {
            System.out.println("Change: PHP" + (paymentAmount - totalAmount));
            System.out.println("Payment Sucessful!");
            resetOrder();
        } else {
            System.out.println("Insufficient payment. Please try again.");
        }
    }

    // Placeholder method, replace it with your actual implementation
    public static double calculateTotalAmount() {
        double total = 0.0;
        for (int i = 0; i < products.length; i++) {
            total += quantities[i] * prices[i];
        }
        return total;
}
    //reseting the order for another costumer
    public static void resetOrder() {
        quantities = new int[products.length];
        System.out.println("                     --------------------                        ");
        System.out.println("                          THANK YOU:)                            ");
}

    //to search for a product
    public static void searchProduct(Scanner scanner) {
        System.out.println("------------------------------------------------------------------");
        System.out.print("Enter the name or index of the product to search: ");
        scanner.nextLine(); // consume the newline character
        String searchInput = scanner.nextLine().toLowerCase();

        boolean found = false;

    for (int i = 0; i < products.length; i++) {
        if (products[i].toLowerCase().contains(searchInput) || String.valueOf(i + 1).equals(searchInput)) {
            System.out.println("------------------------------------------------------------------");
            System.out.println("Product Found:");
            System.out.println(products[i] + "\t\tPHP" + prices[i] + "\t\t" + inventory[i]);
            found = true;
            break;
        }
    }

    if (!found) {
        System.out.println("Oh no! Product does not exist.");
    }
}

    //adding new product(choice 5)
    public static void addProduct(Scanner scanner) {
        System.out.println("------------------------------------------------------------------");
        // make sure that the name of the product has 13 characters
        System.out.print("Enter the name of the new product: ");
        scanner.nextLine();
        // Use nextLine() to capture the entire product name, including spaces
        String newProduct = scanner.nextLine();
        System.out.println("------------------------------------------------------------------");
        System.out.print("Enter the price of the new product: ");
        double newPrice = scanner.nextDouble();
        System.out.println("------------------------------------------------------------------");
        System.out.print("Enter the inventory of the new product: ");
        int newInventoryCount = scanner.nextInt();
       
        // Create new arrays with increased length
        String[] newProducts = new String[products.length + 1];
        double[] newPrices = new double[prices.length + 1];
        int[] newInventory = new int[inventory.length + 1];
        int[] newQuantities = new int[quantities.length + 1];
       
        // Copy existing array contents to the new arrays
        System.arraycopy(products, 0, newProducts, 0, products.length);
        System.arraycopy(prices, 0, newPrices, 0, prices.length);
        System.arraycopy(inventory, 0, newInventory, 0, inventory.length);
        System.arraycopy(quantities, 0, newQuantities, 0, quantities.length);
       
        // Add the new product information to the end of the arrays
        newProducts[products.length] = newProduct;
        newPrices[prices.length] = newPrice;
        newInventory[inventory.length] = newInventoryCount;

        // Update the original arrays with the new ones
        products = newProducts;
        prices = newPrices;
        inventory = newInventory;
        quantities = newQuantities;
       
        System.out.println("Product added successfully!");
}

    //deleting product(choice 7)
    public static void deleteProduct(Scanner scanner) {
        System.out.println("------------------------------------------------------------------");
        System.out.print("Enter the index of the product to delete: ");
        int productNumber = scanner.nextInt();
       
        // Check if the entered product number is valid
        if (productNumber >= 1 && productNumber <= products.length) {
            // Create new arrays with reduced length
            String[] newProducts = new String[products.length - 1];
            double[] newPrices = new double[prices.length - 1];
            int[] newQuantities = new int[quantities.length - 1];

            // Initialize an index for the new arrays
            int index = 0;

            // Loop through the existing arrays to copy elements to the new arrays,
            // excluding the product to be deleted
            for (int i = 0; i < products.length; i++) {
                if (i != (productNumber - 1)) {
                    newProducts[index] = products[i];
                    newPrices[index] = prices[i];
                    newQuantities[index] = quantities[i];
                    index++;
                }
            }

            // Update the original arrays with the new ones
            products = newProducts;
            prices = newPrices;
            quantities = newQuantities;

            System.out.println("Product deleted successfully!");
        } else {
            System.out.println("Invalid product number. Please try again.");
    }
}

//update the product
    public static void updateProduct(Scanner scanner) {
        System.out.println("------------------------------------------------------------------");
        System.out.print("Enter the index of the product to update: ");
        int productNumber = scanner.nextInt();
       
        // Check if the entered product number is valid
        if (productNumber >= 1 && productNumber <= products.length) {
            System.out.println("------------------------------------------------------------------");
            System.out.println("1. Update Product Name");
            System.out.println("2. Update Product Price");
            System.out.println("3. Update Product Inventory");
            System.out.print("Enter your update choice: ");
            int updateChoice = scanner.nextInt();

            // Switch statement to handle different update choices
            switch (updateChoice) {
                case 1:
                    System.out.print("Enter the new name for the product: ");
                    scanner.nextLine(); // consume the newline character
                    String newName = scanner.nextLine();
                    //array indices in Java are zero-based, meaning the first element of the array is at index 0, the second at index 1
                    products[productNumber - 1] = productNumber + "." + newName;
                    System.out.println("Product name updated successfully!");
                    break;
                case 2:
                    System.out.print("Enter the new price for the product: ");
                    double newPrice = scanner.nextDouble();
                    prices[productNumber - 1] = newPrice;
                    System.out.println("Product price updated successfully!");
                    break;
                case 3:
                    System.out.print("Enter the new inventory count for the product: ");
                    int newInventoryCount = scanner.nextInt();
                    inventory[productNumber - 1] = newInventoryCount;
                    System.out.println("Product inventory updated successfully!");
                    break;
                default:
                    System.out.println("Invalid update choice.");
            }
        } else {
            System.out.println("Invalid product number. Please try again.");
        }
    }
}

//omg you did it<3
