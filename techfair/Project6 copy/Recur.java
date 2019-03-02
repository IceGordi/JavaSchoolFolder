public class Recur{
/**
		Sum all numbers to n
		@return the sum of all numbers up to n as integer
	*/
	public static int sigma(int n){
		if(n<=1){
			return n;
		}
		return n + sigma(n-1);
	}
/**
		prints out string
		@param words input String
	*/
	public static void printString(String words){
		if(words.length()==0) return;
		if(words.length()==1){
			System.out.print(words);
			return;
		}
		System.out.print(words.charAt(0));
		printString(words.substring(1));
	}
/**
		prints out revrse string, string starting form last index to first index
		@param words input String
	*/
	public static void printReverse(String words){
		if(words.length()==0) return;
		if(words.length()==1){
			System.out.print(words);
			return;
		}
		printReverse(words.substring(1));
		System.out.print(words.charAt(0));
	}
/**
		Calculates the nth number of the fibonacci sequence
		@return an integer value of above mentioned
		@param n is the nth position of the fibonacci sequence to search for
	*/
	public static int fib(int n){
		if(n==1) return 1;
		if(n==2) return 2;
		return fib(n-1) + fib(n-2);
	}
/**
		Calculates greates common divisor of two numbers.
		@return the greatest common divisor
		@param number1 first number, must be positive
		@param number2 second number, must be positive
	*/
	public static int gcd(int number1, int number2){
		if(number1<number2){
			return gcd(number2,number1);
		}
		if(number2 ==0) return number1;
		return gcd((number1-(number1%number2))/(int)(number1/number2), number1%number2);
	}
/**
		Reverse an array
		@return reversed array
		@param currentArray array to be reversed
	*/
	public static int[] reverseArray(int[] currentArray){
		int temp = 0;
		return reverseArray(currentArray, 0, currentArray.length-1, temp);
	}
	/**
		Reverse an array
		@return reversed array
		@param currentArray array to be reversed
		@param startindex index/counter from front
		@param endindex index/counter from end
	*/
	public static int[] reverseArray(int[] currentArray, int startindex, int endindex, int temp){
		if(startindex == currentArray.length/2){
		temp = currentArray[startindex];
		currentArray[startindex] = currentArray[endindex];
		currentArray[endindex] = temp;
		return currentArray;	
		}
		reverseArray(currentArray, startindex+1, endindex-1, temp);
		temp = currentArray[startindex];
		currentArray[startindex] = currentArray[endindex];
		currentArray[endindex] = temp;
		return currentArray;
	}
	}















