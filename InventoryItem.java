public class InventoryItem {
	private Item item;
	private int qty;

	// default qty = 0
	public InventoryItem(Item item) {
		this.item = item;
		this.qty = 0;
	}

	// default qty = qty
	public InventoryItem(Item item, int qty) {
		this.item = item;
		this.qty = qty;
	}

	// kembalikan item
	public Item getItem() { return this.item; }

	// kembalikan jumlah qty
	public int getQty() { return this.qty; }

	// ubah qty menjadi sebanyak qty
	// jika qty < 0 throw IllegalArgumentException
	public void setQty(int qty) { 
		if (qty < 0) throw new IllegalArgumentException();
		this.qty = qty;
	}
	
	public String toString() {
		return String.format("<InventoryItem:%s:%d>\n", item.toString(), qty);
	}
}
