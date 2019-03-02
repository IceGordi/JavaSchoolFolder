public class Temp{
	public String findOwner(String name){
		for(int i = 0; i<slots.length; i++){
			if(slots[i].getName() == name) return slots[i].getOwnerName();
		}
		return null;
	} 
	public void moveTogether(){
		int tempValue;
		for(int i = 0; i<slots.length; i++){
			if(slots[i] == null){
				tempValue = slots[i];
				slots[i] = slots[i+1];
				slots[i+1] = tempValue;
			}
		}
	}
}