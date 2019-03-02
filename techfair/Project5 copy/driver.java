/*
Driver class to test the sequence.

*/

public class driver{
	public static void main(String[] args){
		//create a Sequence object by calling the constructor
		Sequence newSequence = new Sequence();
		//use statements like these to test your functions.
		System.out.println(newSequence.getCapacity());
		System.out.println(newSequence.size());
		System.out.println(newSequence.empty());
		System.out.println(newSequence.full());
		newSequence.print();
		System.out.println(newSequence.get(27));
		System.out.println(newSequence.getMax());
		System.out.println(newSequence.getMin());
		newSequence.add(-2);
		newSequence.add(-3);
		newSequence.add(4);
		newSequence.add(-1);
		newSequence.add(-2);
		newSequence.add(1);
		newSequence.add(5);
		newSequence.add(-3);
		newSequence.print();
		System.out.println(newSequence.arrayToInt());
		System.out.println(newSequence.size());
		System.out.println(newSequence.getMaxSum());
	}
		
}