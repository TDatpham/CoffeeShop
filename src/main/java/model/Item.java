package model;

public class Item {
	private ThucDon thucdon;
	private int quantity;
	private float price;
	public Item() {}
	
	public Item(ThucDon thucdon, int quantity, float price) {
		super();
		this.thucdon = thucdon;
		this.quantity = quantity;
		this.price = price;
	}
	public ThucDon getThucdon() {
		return thucdon;
	}
	public void setThucdon(ThucDon thucdon) {
		this.thucdon = thucdon;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Item [thucdon=" + thucdon + ", quantity=" + quantity + ", price=" + price + "]";
	}
	
	
	
	
	
}
