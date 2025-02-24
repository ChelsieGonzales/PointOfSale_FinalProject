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
