public class driver{
	public static void main(String[] args){
		//create a Sequence object by calling the constructor
		Recur test = new Recur();
		//use statements like these to test your functions.
		test.printReverse("KHOA");
		System.out.println();
		System.out.println(test.fib(5));
		System.out.println(test.sigma(5));
		test.printString("KHOA");
		System.out.println();
		System.out.println(test.gcd(210,45));
		int[] array = new int[]{1,2,3,4,5,6,7,8,9,10};
		for(int i =0; i<array.length; i++){
			System.out.println(array[i]);
		}
		array = test.reverseArray(array);
		for(int i =0; i<array.length; i++){
			System.out.println(array[i]);
		}
	}
}