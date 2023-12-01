package model;

import java.util.ArrayList;
import java.util.List;

public class Cart {
	private  List<Item> items;
	
	public Cart() {
		items = new ArrayList<>();
		
		
	}

	public Cart(List<Item> items) {
		super();
		this.items = items;
	}
	
	public Item getItemById(int id) {
		
		for (Item item : items) {
			if(item.getThucdon().getThucdon_id()==id) {
				return item;
			}
		}
		return null;
	}
	
	
	public int getQuantityById(int id) {
		return getItemById(id).getQuantity();
	}
	
	// them vao gio 
	public void addItem(Item t) {
		// t/h co san o gio hang roi
		
		if (getItemById(t.getThucdon().getThucdon_id()) != null) {
			getItemById(t.getThucdon().getThucdon_id()).setQuantity(getItemById(t.getThucdon().getThucdon_id()).getQuantity() + t.getQuantity() );
			// cong cai sl vao ;
		}else {
			// t/h chua co thi them no vao cart
			
			this.items.add(t);
		}
	}
	
	
	public void removeItem(int id) {
		if (getItemById(id) != null) {
			items.remove(getItemById(id));
		}

	}
	
	
	public float getTotalMoney() {
		float t=0;
		
		for (Item item : items) {
			t += (item.getPrice()*item.getQuantity());
		}
		return t;
	}

	@Override
	public String toString() {
		return "Cart [items=" + items + "]";
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}
	
	
	
}
