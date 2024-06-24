import java.util.*;

class Item {
    private String itemName;
    private double itemCost;
    private int quantity;
    private String itemType;
    private double taxRate;

    public Item(String itemName, double itemCost, int quantity, String itemType) {
        this.itemName = itemName;
        this.itemCost = itemCost;
        this.quantity = quantity;
        this.itemType = itemType;
        setTaxRate();
    }

    private void setTaxRate() {
        switch (itemType.toLowerCase()) {
            case "raw":
                taxRate = 0.155;
                break;
            case "manufactured":
                taxRate = 0.205;
                break;
            default:
                throw new IllegalArgumentException("Invalid item itemType: " + itemType);
        }
    }

    public String getitemName() {
        return itemName;
    }

    public double getitemCost() {
        return itemCost;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getitemType() {
        return itemType;
    }

    public double getSalesTax() {
        return itemCost * taxRate;
    }

    public double getFinalitemCost() {
        return itemCost + getSalesTax();
    }
}

public class ItemCostCalculator{
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        List<Item> items = new ArrayList<>();

        while (true) {
            try {
                System.out.println("Enter the details of items:");
                
                System.out.print("Item Name: ");
                String itemName = scanner.nextLine();
                
                System.out.print("Item Cost: ");
                double itemCost = Double.parseDouble(scanner.nextLine());
                
                System.out.print("Quantity: ");
                int quantity = Integer.parseInt(scanner.nextLine());
                
                System.out.print("Item Type (Raw/Manufactured): ");
                String itemType = scanner.nextLine();

                items.add(new Item(itemName, itemCost, quantity, itemType));

                System.out.print("Do you want to enter details of any other item (y/n): ");
                String choice = scanner.nextLine().trim().toLowerCase();
                
                if (!choice.equals("y")) break;
                
            } catch (Exception e) {
                System.out.println("Invalid input. Please try again.");
            }
        }

        System.out.println("\nItem Details:");
        for (Item item : items) {
            System.out.println("Item Name: " + item.getitemName());
            System.out.println("Item Cost: " + item.getitemCost());
            System.out.println("Sales Tax per item: " + item.getSalesTax());
            System.out.println("Final Item Cost per item: " + item.getFinalitemCost());
            System.out.println("--------------------");
        }
    }
}