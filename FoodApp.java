import java.util.Scanner;

public class FoodApp {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		Restaurant restaurant1 = new Restaurant();
		Restaurant restaurant2 = new Restaurant();

		// First restaurant
		restaurant1.addItem("Burger", 10);
		restaurant1.addItem("Pizza", 15);

		restaurant1.addRating("Burger", 5);
		restaurant1.addRating("Burger", 4);
		restaurant1.addRating("Pizza", 4);

		// Second restaurant
		restaurant2.addItem("Burger", 12);
		restaurant2.addItem("Pizza", 14);

		restaurant2.addRating("Burger", 3);
		restaurant2.addRating("Burger", 5);
		restaurant2.addRating("Pizza", 5);

		// Display first restaurant
		System.out.println("\nRestaurant 1");
		restaurant1.displayMenu();

		// Display second restaurant
		System.out.println("\nRestaurant 2");
		restaurant2.displayMenu();

		// Ask user which item to compare
		System.out.println("\nEnter item to compare:");
		String item = sc.nextLine();

		// Get prices
		double r1Price = restaurant1.getPrice(item);
		double r2Price = restaurant2.getPrice(item);

		// Get average ratings
		double r1Rating =
		    restaurant1.calculateAverageRating(item);

		double r2Rating =
		    restaurant2.calculateAverageRating(item);

		// Display comparison
		System.out.println("\nComparison");

		System.out.println(
		    "Restaurant 1 -> Price: " + r1Price
		    + " Rating: " + r1Rating
		);

		System.out.println(
		    "Restaurant 2 -> Price: " + r2Price
		    + " Rating: " + r2Rating
		);

		sc.close();
	}
}