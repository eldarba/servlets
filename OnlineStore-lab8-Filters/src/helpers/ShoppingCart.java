package helpers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import db.Item;

public class ShoppingCart {

	private List<Item> items = new ArrayList<>();

	public void addItem(Item item) {
		this.items.add(item);
	}

	public void removeItem(Item item) {
		Iterator<Item> it = this.items.iterator();
		while (it.hasNext()) {
			Item currItem = it.next();
			if (item.getCategory().equals(currItem.getCategory()) && item.getName().equals(currItem.getName())) {
				it.remove();
				break;
			}
		}
	}

	public Item[] getItems() {
		return this.items.toArray(new Item[this.items.size()]);
	}

	public void clear() {
		this.items.clear();
	}

}
