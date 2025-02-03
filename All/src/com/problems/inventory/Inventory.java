package src.com.problems.inventory;

import java.util.Comparator;

class Inventory {
    private ItemNode head = null;
       // Comparator for Item Name (ascending)
       public static class ItemNameComparator implements Comparator<ItemNode> {
        @Override
        public int compare(ItemNode item1, ItemNode item2) {
            return item1.itemName.compareTo(item2.itemName);
        }
    }

    // Comparator for Price (ascending)
    public static class PriceComparator implements Comparator<ItemNode> {
        @Override
        public int compare(ItemNode item1, ItemNode item2) {
            return Double.compare(item1.price, item2.price);
        }
    }

    // Add an item at the beginning
    public void addBeginning(String itemName, int itemId, int quantity, double price) {
        ItemNode newItem = new ItemNode(itemName, itemId, quantity, price);
        newItem.next = head;
        head = newItem;
    }

    // Add an item at the end
    public void addEnding(String itemName, int itemId, int quantity, double price) {
        ItemNode newItem = new ItemNode(itemName, itemId, quantity, price);
        if (head == null) {
            head = newItem;
        } else {
            ItemNode curr = head;
            while (curr.next != null) {
                curr = curr.next;
            }
            curr.next = newItem;
        }
    }

    // Add an item at a specific position
    public void addAtPosition(String itemName, int itemId, int quantity, double price, int position) {
        ItemNode newItem = new ItemNode(itemName, itemId, quantity, price);
        if (position == 0) {
            addBeginning(itemName, itemId, quantity, price);
            return;
        }
        
        ItemNode curr = head;
        int count = 0;
        while (curr != null && count < position - 1) {
            curr = curr.next;
            count++;
        }
        
        if (curr != null) {
            newItem.next = curr.next;
            curr.next = newItem;
        } else {
            System.out.println("Position is out of bounds.");
        }
    }

    // Remove an item by Item ID
    public void removeByItemId(int itemId) {
        if (head == null) return;

        if (head.itemId == itemId) {
            head = head.next; // Removing the first node
            return;
        }

        ItemNode curr = head;
        while (curr.next != null && curr.next.itemId != itemId) {
            curr = curr.next;
        }

        if (curr.next != null) {
            curr.next = curr.next.next; // Remove the node
        } else {
            System.out.println("Item with ID " + itemId + " not found.");
        }
    }

    // Update the quantity of an item by Item ID
    public void updateQuantity(int itemId, int newQuantity) {
        ItemNode curr = head;
        while (curr != null) {
            if (curr.itemId == itemId) {
                curr.quantity = newQuantity;
                return;
            }
            curr = curr.next;
        }
        System.out.println("Item with ID " + itemId + " not found.");
    }

    // Search for an item by Item ID
    public ItemNode searchByItemId(int itemId) {
        ItemNode curr = head;
        while (curr != null) {
            if (curr.itemId == itemId) {
                return curr; // Return the found item node
            }
            curr = curr.next;
        }
        System.out.println("Item with ID " + itemId + " not found.");
        return null;
    }

    // Search for an item by Item Name
    public ItemNode searchByItemName(String itemName) {
        ItemNode curr = head;
        while (curr != null) {
            if (curr.itemName.equals(itemName)) {
                return curr; // Return the found item node
            }
            curr = curr.next;
        }
        System.out.println("Item with name " + itemName + " not found.");
        return null;
    }

    // Calculate the total value of the inventory
    public double calculateTotalValue() {
        double totalValue = 0;
        ItemNode curr = head;
        while (curr != null) {
            totalValue += curr.price * curr.quantity;
            curr = curr.next;
        }
        return totalValue;
    }

    // Display all items in the inventory
    public void displayInventory() {
        if (head == null) {
            System.out.println("Inventory is empty.");
            return;
        }
        ItemNode curr = head;
        while (curr != null) {
            System.out.println("Item Name: " + curr.itemName + ", Item ID: " + curr.itemId + 
                               ", Quantity: " + curr.quantity + ", Price: " + curr.price);
            curr = curr.next;
        }
    }

    // Sort inventory by Item Name or Price using Comparator
    public void sortInventory(Comparator<ItemNode> comparator) {
        if (head == null || head.next == null) {
            return; // No sorting needed for empty or single item list
        }

        // Convert linked list to array for sorting
        ItemNode[] itemArray = toArray();
        java.util.Arrays.sort(itemArray, comparator);

        // Rebuild the sorted linked list
        head = null;
        for (ItemNode item : itemArray) {
            addEnding(item.itemName, item.itemId, item.quantity, item.price);
        }
    }

    // Convert the linked list to an array (for sorting)
    private ItemNode[] toArray() {
        int size = 0;
        ItemNode curr = head;
        while (curr != null) {
            size++;
            curr = curr.next;
        }

        ItemNode[] itemArray = new ItemNode[size];
        curr = head;
        for (int i = 0; i < size; i++) {
            itemArray[i] = curr;
            curr = curr.next;
        }

        return itemArray;
    }
}
