import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String choice;
        int steak = 40, soup = 30, salad = 20, total = 0, quantity = 0;
        ArrayList<String> dish = new ArrayList<String>();
        ArrayList<Integer> prices = new ArrayList<Integer>();
        ArrayList<Integer> amount = new ArrayList<Integer>();

        System.out.println("*==========================*");
        System.out.println("*    MENU                  *");
        System.out.println("*[1] Steak    USD -    [40]*");
        System.out.println("*[2] Soup     USD -    [30]*");
        System.out.println("*[3] Salad    USD -    [20]*");
        System.out.println("*[4] Cancel                *");
        System.out.println("*==========================*");


        boolean isAdding = true;
        while (isAdding) {
            System.out.println("Enter your choice: ");
            choice = scanner.next();

            if (choice.matches("[1-4]")) {
                if (choice.equals("4")) {
                    isAdding = false;
                    System.out.println("Transaction terminated.");
                    break;
                }

                System.out.println("Enter amount: ");
                if (scanner.hasNextInt()) {
                    quantity = scanner.nextInt();
                    if (quantity > 0) {
                        switch (choice) {
                            case "1":
                                total = steak * quantity;
                                dish.add("Steak");
                                prices.add(steak);
                                amount.add(quantity);
                                System.out.println(quantity + " order(s) of Steak has been added.");
                                break;
                            case "2":
                                total = soup * quantity;
                                dish.add("Soup");
                                prices.add(soup);
                                amount.add(quantity);
                                System.out.println(quantity + " order(s) of Soup has been added.");
                                break;
                            case "3":
                                total = salad * quantity;
                                dish.add("Salad");
                                prices.add(salad);
                                amount.add(quantity);
                                System.out.println(quantity + " order(s) of Salad has been added.");
                                break;
                        }
                    } else {
                        System.out.println("Invalid amount. Please enter a positive integer.");
                    }
                } else {
                    System.out.println("Invalid input. Please enter a positive integer.");
                    scanner.next();
                }
            } else {
                System.out.println("Invalid choice. Please enter a number from 1 to 4.");
            }

            System.out.println("Do you want anything else? (Y/N)");
            String answer = scanner.next();
            if (answer.equalsIgnoreCase("N")) {
                isAdding = false;
            }

            System.out.println("=================");
            System.out.println("   ORDER SUMMARY   ");
            System.out.println("=================");

            int orderNumber = 1;
            int grandTotal = 0;
            for (int i = 0; i < dish.size(); i++) {
                System.out.println(orderNumber + ". " + dish.get(i) + " x " + amount.get(i) + " = " + prices.get(i) * amount.get(i));
                grandTotal += prices.get(i) * amount.get(i);
                orderNumber++;
            }
            System.out.println("-----------------");
            System.out.println("GRAND TOTAL: " + grandTotal + " USD");

        }
    }
}
