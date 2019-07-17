import java.util.List;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Comparator;

public class Inventory {
	// Item, Qty
	private List<InventoryItem> items;
	private int tempss;

	public Inventory() {
		this.items = new ArrayList<InventoryItem>();
	}

	public List<InventoryItem> getItems() { return this.items; }
	
	// mengembalikan banyak total item
	public int getItemTotalCount() { 
		this.tempss = 0;
		for (InventoryItem i: items) {
			this.tempss += i.getQty();
		}
		return this.tempss;
	}
	
	public boolean contains(Item item) {
		for (InventoryItem i: items) {
			if (i.getItem().getName().equals(item.getName())) {
				return true;
			}
		}
		return false;
	}
	
	public int find(Item item) {
		for (InventoryItem i: items) {
			if (i.getItem().getName().equals(item.getName())) {
				return items.indexOf(i);
			}
		}
		return -1;
	}
	
	// mengembalikan item tertentu, kembalikan -1 jika tidak ditemukan
	public int getItemCount(Item item) { 
		if (contains(item)) return items.get(find(item)).getQty();
		return -1;
	}
	
	// mengurangi jumlah qty item tertentu, kembalikan jumlah qty yang berhasil diambil
	// jika qty > banyak item di inventory, kembalikan banyak item di inventory
	// jika tidak temukan throw NoSuchElementException
	// jika qty <= 0 throw IllegalArgumentException
	public int takeItem(Item item, int qty) { 
		if (!contains(item)) {
			throw new NoSuchElementException();
		}
		if (qty <= 0) throw new IllegalArgumentException();
		
		int temp = getItemCount(item);
		if (qty < temp) {
			items.get(find(item)).setQty(temp-qty);
			return qty;
		} else if (qty > temp) {
			items.get(find(item)).setQty(0);
			return temp;
		} 
		return -1;
	}
	
	// menambahkan item tertentu ke inventory sebanyak inventory
	// jika qty <= 0 throw IllegalArgumentException
	public void putItem(Item item, int qty) {
		if (qty <= 0) throw new IllegalArgumentException();
		items.add(new InventoryItem(item,qty));
	}
	
	// kembalikan list items yang diurutkan berdasarkan harga item (descending)
	public List<InventoryItem> getOrderByPrice() { 
		this.items.sort(new Comparator<InventoryItem>() {
				public int compare(InventoryItem I1, InventoryItem I2) {
					return (int)(I1.getItem().getPrice()- I2.getItem().getPrice()) * -1;
				}
		});
		return this.items;
	}
	// kembalikan list items yang diurutukan berdasarkan berat item (descending)
	public List<InventoryItem> getOrderByWeight() { 
		this.items.sort(new Comparator<InventoryItem>() {
				public int compare(InventoryItem I1, InventoryItem I2) {
					return (int)(I1.getItem().getWeight()*100- I2.getItem().getWeight()*100) * -1;
				}
		});
		return this.items;
	}
	// kembalikan list items yang diurutkan berdasarkan qty item (descending)
	public List<InventoryItem> getOrderByQty() { 
		this.items.sort(new Comparator<InventoryItem>() {
				public int compare(InventoryItem I1, InventoryItem I2) {
					return (int)(I1.getQty()- I2.getQty()) * -1;
				}
		});
		return this.items;
	}
}
