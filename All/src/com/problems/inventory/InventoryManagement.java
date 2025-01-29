package src.com.problems.inventory;

import java.util.Comparator;

public class InventoryManagement {

    private static Comparator<ItemNode> itemNameComparator = new Comparator<ItemNode>() {
        @Override
        public int compare(ItemNode item1, ItemNode item2) {
            return item1.itemName.compareTo(item2.itemName);
        }
    };

    private static Comparator<ItemNode> priceComparator = new Comparator<ItemNode>() {
        @Override
        public int compare(ItemNode item1, ItemNode item2) {
            return Double.compare(item1.price, item2.price);
        }
    };
    public static void main(String[] args) {
        Inventory inventory = new Inventory();

        // Add some items
        inventory.addEnding("Apple", 101, 50, 1.2);
        inventory.addEnding("Banana", 102, 30, 0.8);
        inventory.addEnding("Orange", 103, 20, 1.5);

        // Display inventory
        System.out.println("Inventory:");
        inventory.displayInventory();

        // Search for an item by Item ID
        ItemNode item = inventory.searchByItemId(102);
        if (item != null) {
            System.out.println("Found item by ID: " + item.itemName);
        }

        // Update the quantity of an item
        inventory.updateQuantity(103, 25);

        // Remove an item
        inventory.removeByItemId(101);

        // Calculate the total inventory value
        double totalValue = inventory.calculateTotalValue();
        System.out.println("Total value of inventory: " + totalValue);

        // Sort the inventory by Item Name
        System.out.println("Sorted by Item Name:");
        inventory.sortInventory(itemNameComparator);
        inventory.displayInventory();

        // Sort the inventory by Price
        System.out.println("Sorted by Price:");
        inventory.sortInventory(priceComparator);
        inventory.displayInventory();
    }
}
