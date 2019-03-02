public class Item{
	private String itemID;
	private double price;
	private String description;
	public void changeID(String newStartChar){
		itemID = newStartChar + itemID.substring(1);
	}
	public void raiseAllPrices(double amt){
		for(Item obj: allItems)
			obj.price += amt;
	}
	public void removeAll(String descr){
		Iterator<Item> itr = allItems.iterator();
		while(itr.hasNext()){
			if(itr.next().description == descr)
				itr.remove();
		}
	}
}