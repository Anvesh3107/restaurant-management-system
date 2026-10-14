import java.util.ArrayList;

public class Restaurant {
    private ArrayList<String> menuItems;
    private ArrayList<Double> prices;
    private ArrayList<ArrayList<Integer>> ratings;

    // Constructor
    public Restaurant() {
        menuItems = new ArrayList<>();
        prices = new ArrayList<>();
        ratings = new ArrayList<>();
    }

    // Add item
    public void addItem(String item, double price) {
        menuItems.add(item);
        prices.add(price);
        ratings.add(new ArrayList<Integer>());

        System.out.println(item + " added successfully");
    }

    // Remove item
    public void removeItem(String item) {
        int index = findItemIndex(item);

        if (index != -1) {
            menuItems.remove(index);
            prices.remove(index);
            ratings.remove(index);

            System.out.println(item + " removed successfully");
        } else {
            System.out.println("Item not found");
        }
    }

    // Add rating
    public void addRating(String item, int rating) {
        int index = findItemIndex(item);

        if (index != -1) {
            ratings.get(index).add(rating);
        } else {
            System.out.println("Item not found");
        }
    }

    // Calculate average rating
    public double calculateAverageRating(String item) {
        int index = findItemIndex(item);

        if (index == -1) {
            return 0;
        }

        ArrayList<Integer> itemRatings = ratings.get(index);

        if (itemRatings.size() == 0) {
            return 0;
        }

        int sum = 0;

        for (int rating : itemRatings) {
            sum += rating;
        }

        return (double) sum / itemRatings.size();
    }

    // Get item price
    public double getPrice(String item) {
        int index = findItemIndex(item);

        if (index != -1) {
            return prices.get(index);
        }

        return 0;
    }

    // Display menu
    public void displayMenu() {
        System.out.println("\nMenu");

        for (int i = 0; i < menuItems.size(); i++) {
            System.out.println(
                menuItems.get(i) + " - $" + prices.get(i)
                + " Rating: "
                + calculateAverageRating(menuItems.get(i))
            );
        }
    }

    // Find item index
    private int findItemIndex(String item) {
        for (int i = 0; i < menuItems.size(); i++) {
            if (menuItems.get(i).equalsIgnoreCase(item)) {
                return i;
            }
        }

        return -1;
    }
}