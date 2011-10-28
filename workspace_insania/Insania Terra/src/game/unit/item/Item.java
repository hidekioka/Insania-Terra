package game.unit.item;

public class Item {
	
	
	private boolean isEquipable;
	private boolean isUsable;
	private boolean isKey;
	
	Item(boolean equipable, boolean usable, boolean key){
		this.isEquipable = equipable;
		this.isUsable = usable;
		this.isKey = key;
	}
	
	
}
