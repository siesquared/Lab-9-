import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class StoreMenu {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

//hash map for menu
		Map<String, Double> items = new HashMap<>();
		items.put("apple", 0.99);
		items.put("banana", 0.59);
		items.put("cauliflower", 1.59);
		items.put("dragonfuit", 2.19);
		items.put("elderberry", 1.79);
		items.put("figs", 2.09);
		items.put("grapefruit", 1.99);
		items.put("honeydew", 3.49);

//ArrayList for store items
		ArrayList<String> itemType = new ArrayList<>();

//Array List for prices of store items 
		ArrayList<Double> itemPrice = new ArrayList<>();

// Array List for quantity of store items
		ArrayList<Integer> itemAmount = new ArrayList<>();

		String userInput;
		

		System.out.println("Welcome to Sie Sie's Market!\n");

		do {

			System.out.printf("%-12s %-10s\n", "Items", "Prices");
			System.out.printf("%-12s %-10s\n", "=======", "=======");

			for (Map.Entry<String, Double> product : items.entrySet()) {
				System.out.printf("%-12s  %-10s\n",  product.getKey(), "$ " + product.getValue());
				
			}

			System.out.println("What item would you like to order?");
			String orderInput = scan.nextLine();

			int order = 0;
			boolean val = false;
			// make sure user input is valid
			while (!items.containsKey(orderInput)) {
				System.out.println("Sorry, fresh out ");

			
				for (Map.Entry<String, Double> product : items.entrySet()) {
					System.out.printf("%-12s  %-10s\n",  product.getKey(), "$ " + product.getValue());
					
				}
				System.out.println("What item would you like to order?");
				orderInput = scan.nextLine();

			}
			boolean valid = false;
			while (!valid) {
				try {
					System.out.println("How many " + orderInput + " would you like? ");
				order = scan.nextInt();
				
				
				} catch (InputMismatchException ex) {
					System.out.println("Sorry try again ");
					scan.nextLine();
					continue;
				}
					valid = true;
			}
		

			System.out.println("Adding |" + order + "|" + orderInput + " to cart at $" + items.get(orderInput));
			scan.nextLine();

			// casting to Array from Hash Map
			itemType.add(orderInput);
			itemPrice.add(items.get(orderInput));
			itemAmount.add(order);

			System.out.println("You have ordered " + itemAmount + itemType + "would you like anything else? (y/n)");

			userInput = scan.next();
			scan.nextLine();

		} while (userInput.equalsIgnoreCase("y"));

		System.out.println("Here's what your order");
		System.out.printf(" %-10s\n", "========================");

		for (int i = 0; i < itemType.size(); i++) {

			System.out.printf("%-12s  %-10s\n", itemType.get(i),
					"$" + itemPrice.get(i) + " (" + itemAmount.get(i) + ")");
		}

		avgCost(itemPrice, itemAmount);
		maxCost(itemPrice, itemType);
		lowCost(itemPrice, itemType);
		totalCost(itemPrice, itemAmount);

		System.out.println("Thank you come again\n");

	}

	public static double avgCost(ArrayList<Double> price, ArrayList<Integer> howMany) {

		double avg = 0.0;
		double sum = 0.0;
		int total = 0;

		for (int i = 0; i < price.size(); i++) {

			sum += (price.get(i) * howMany.get(i));
			total += howMany.get(i);
		}
		avg = sum / total;
		System.out.println("Your average price per item is: " + " $" + avg);

		return avg;
	}

	public static double totalCost(ArrayList<Double> price, ArrayList<Integer> howMany) {
		double total = 0;
		for (int i = 0; i < price.size(); i++) {
			total += price.get(i) * howMany.get(i);
		}
		System.out.println("Order total is: " + "$" + total);

		return total;
	}

	public static double maxCost(ArrayList<Double> price, ArrayList<String> stuff) {

		double max = price.get(0);
		String item = " ";

		for (int i = 0; i < price.size(); i++) {
			if (price.get(i) > max) {
				max = price.get(i);
				item = stuff.get(i);

			}

		}

		System.out.println("Highest priced item: " + item + "$" + max);
		return max;

	}

	public static double lowCost(ArrayList<Double> price, ArrayList<String> stuff) {
		double low = price.get(0);
		String word = "";

		for (int i = 0; i < price.size(); i++) {
			if (price.get(i) < low) {
				low = price.get(i);
				word = stuff.get(i);
			}
		}
		System.out.println("Lowest priced item:" + word + " $" + low);
		return low;
	}
}