import java.util.NoSuchElementException;

public class TestInventory {
	public static void main(String []args) {
		Inventory inv = new Inventory();
		Item[] items = new Item[]{
			new Item("Health Potion", 0.1, 100.0),
			new Item("Dagger", 1.0, 70.0),
			new Item("Bread", 0.3, 30.0),
			new Item("Sword", 5.0, 200.0)
		};

		inv.putItem(items[0], 5);
		inv.putItem(items[1], 2);
		inv.putItem(items[2], 3);

		System.out.println(inv.getItems());
		if (inv.getItemTotalCount() != 10) {
			System.out.println("total count error");
		}
		if (inv.getItemCount(items[0]) != 5) {
			System.out.println("Item count error");
		}
		if (inv.getItemCount(items[3]) != -1) {
			System.out.println("Item count error");
		}

		if (inv.takeItem(items[0], 1) != 1) {
			System.out.println("take item errors");
		}

		if (inv.takeItem(items[0], 10) != 4) {
			System.out.println("take item errorss");
		}

		try {
			inv.takeItem(items[3], 1);
			System.out.println("take item errossr");
		} catch (NoSuchElementException e) {
		}

		try {
			inv.takeItem(items[1], -1);
			System.out.println("take item errorie");
		} catch (IllegalArgumentException e) {
		}

		System.out.println(inv.getOrderByPrice());
		System.out.println(inv.getOrderByWeight());
		System.out.println(inv.getOrderByQty());
	}
}
