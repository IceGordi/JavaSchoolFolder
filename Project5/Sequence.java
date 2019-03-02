/*
	Add header comments here
*/
public class Sequence implements sequenceInterface{

	//the maximum number of elements in any sequence
	private int capacity = 100;
	//the number of items in the sequence
	private int size;
	//an array with sufficient slots to hold the items in the sequence
	private int[] data;

	/** constructor 
	    Postcondition initializes the sequence data
	*/
	public Sequence(){
		
		/*capacity = 100;
		size = 100;
		data = new int[capacity];
		double tempValue;
		for(int i = 0;i <= capacity-1; i++){
			tempValue =Math.random() *100;
			data[i] = (int)(tempValue);
		}
		*/
		data = new int[capacity];
		for(int i = 0; i < capacity; i++){
			data[i] = 0;
		}
		size = 0;

	}

	/**
		@return the capacity of the sequence
	*/
	public  int getCapacity(){
		return capacity;
	}

	/**
		@return the size of the sequence
	*/
	public  int size(){
		return size;
	}
	
	//enter function comments here
	public  boolean empty(){
		if(size == 0) return true;
		else return false;
	}
	
	//enter function comments here
	public  boolean full(){
		if(size == capacity) return true;
		else return false; 
	}
		
	/**
		PostCondition: prints the array to the console
					   in rows of 10 elements each 
					   seperated by a space
	*/
	public  void print(){
		int counter = 0;
		for (int number : data){
			System.out.print("\t" + number);
			counter++;
			if (counter%10 == 0) System.out.println();
		}
	}
	
	/**
		@param position is an index in data array
		Precondition: 0 <= position <= capacity
	*/
	public  int get(int position){ 
		return data[position];
	}
	
	/**
		@return the minimum number in the data array
		@return Integer.MIN_VALUE if size is 0
	*/
	public  int getMin(){
		if (size == 0)return Integer.MIN_VALUE;
		int smallest = Integer.MAX_VALUE;
		for(int number : data){
		if(number<smallest) smallest = number;	
		}
		return smallest;
	}


	/**
		@return the maximum number in the data array
		@return Integer.MAX_VALUE if size is 0
	*/
	public  int getMax(){
		//if array is of size of size
		if(size ==0) return Integer.MAX_VALUE;
		int largest = Integer.MIN_VALUE;
		for(int number : data){
			if(largest<number) largest = number;
		}
		return largest;
	}

	/******************************************************/
	/******************************************************/

	//Complete Comfortable and More Comfortable Category functions below
	
	

	/**
		@param item is the item to be added to end of sequence
		Adds a new item to the end of the Sequence
		also checks wether sequence is alreayd full
	*/
	public  void add(int item){
		if(full()){
			System.out.println("Error, sequence is full");
		}else{
			data[size] = item;
			size++;}
		}
	/**
		@param item is the item to be added to sequence
		@param position is the position (measured in 0 - n-1) at which the item is added
		Adds a new item to the sequence at desider position
	*/

	public  void add(int item, int position){
			if(full()){
				System.out.println("Error, sequence is full");
			}else{
				size++;
				for(int i = size-1; i > position; i--){
					 data[i] = data[i-1];
					}
				data[position] = item;
			}
		}
/**
		Simply removes last item of sequence
	*/

	public  void remove(){
		if(size>0){
		data[size-1] = 0;
		size--;}
		else System.out.println("Sorry but no items could be removed, sequence empty");
	}
/**
		@param newitem is the item to be added put into the sequence
		@param position is the desired position at which it should be added (0 - n-1)
		Basically replaces an item at a desired location with a new one
	*/
 	public  void replace(int newitem, int position){
 		if(position >= size) System.out.println("Error, position outside of array");
 		else data[position] = newitem;
 	}
/**
		Clears full sequence
	*/
 	public  void clear(){
 		for(int i = 0; i<size; i++){
 			data[i] = 0;
 		}
 		size = 0;
 	}

 	/**
		Auxiliary to getLongestRun. Counts number of ocurrneces of a certain item adter a 
		certain start position
		@param item the item
		@param startpos position at which it should start
	*/

	public  int nrOcurrences(int item,int startpos){
		int counter = 0;
		for(int i = startpos; i < size; i++){
 			if(data[i] == item) counter++;
 			if(data[i] == item && data[i+1] != data[i]) break;
 		}	
 		return counter;
	}

/**
		@param item is the item to be searched for
		Searches for the largest amount of times that a same number repeats
		@return the starting positon of that longest run, if there is none,
		returns size
	*/
 	public  int getLongestRun(int item){
 		int reps1 , longestrep, startpos;
 		reps1 = 0;
 		longestrep = 0;
 		startpos = 0;
 		for(int i = 0; i<size; i++){
 			if(data[i] == item){
 				reps1 = nrOcurrences(item, i);
 			}
 			if(reps1 > longestrep){
 				longestrep = reps1;
 				startpos = i;
 			}
 		}
 		if(startpos == 0 && data[0] == data[1]) return size;
 		else return startpos;
 	}
 	/**
	Reverses full array in place, simple
	Ex {1,2,3,4,5} becomes {5,4,3,2,1}
	*/

 	public  void reverseInPlace(){
 		int tempValue;
 		if(size%2 == 0){
 			for(int i = 0; i<size-1/2; i++){
 				tempValue = data[i];
 				data[i] = data[size-1-i];
 				data[size-1-i] = tempValue;
 			}
 		}
 		else{
 			for(int i = 0; i< size/2; i++){
 				tempValue = data[i];
 				data[i] = data[size-1-i];
 				data[size-1-i] = tempValue;
 			}
 		}
 	}
/**
		Simple, removes duplicates by first converting all duplicates to 0. Then moving/shifting,
		those zeroes to the end of the sequence and then reducing the size of the sequence
		until they are excluded of it
	*/
 	public  int removeDuplicates(){
 		for(int i=0; i<size; i++){
 			for(int j = i+1; j<size; j++){
 				if(data[i] == data[j]){
 					data[j] = 0;
 				}
 			}
 		}
 		int tempValue = 0;
 		for(int i=0; i<size; i++){
 			if(data[i] == 0){
 				while(data[i] == 0){
 					for(int j = i; j<size; j++){
 						data[j] = data[j+1];
 					}
 					size--;	
 				}
 			}
 		}
 		return size;
 	}
/**
		@return returns 1,2 or 0 depending on which case it is
		Checks wether the sequence is a palindrome. If it is, returns 1. In case it is not. Programm 
		checks if thorugh the rearrangement of elements Palindromism could be achieved, if it could,
		return 2, else return 0.
	*/

 	public  int isPalindrome(){
 		boolean tempNo = false;
 		for(int i = 0; i<size; i++){
 			if(data[i] != data[size-1-i]) tempNo = true;
 		}
 		int counter = 0;
 		int tempCounterCounter = 0;
 		if(!tempNo) return 1;
 		for(int i=0; i<size;i++){
 			counter = 0;
 			for(int j=0;j<size;j++){
 				if(data[i] == data[j]) counter++;
 			}
 			if(counter%2 != 0) tempCounterCounter++;
 		} 
 		if(tempCounterCounter == 1 || tempCounterCounter == 0) return 2;
 		else return 0;
 	}

 	/**
		@return returns an integer in which all the elements of the array are represented
		in order in whihc they would be read normally
		Ex: {1,2,3,4,5} -> 12345 as in twelve thousnad threehundred and forty five
		If the number exceeds the maximum value that a int can hold, it returns MAX_VALUE
	*/

	public int arrayToInt(){
 		int counter = 1;
 		int integer = 0;
 		for(int i = size-1; i >=0; i--){
 				try{
 					integer += data[i]*counter;
 					counter=counter*10;
 				}catch(Exception e) {return Integer.MAX_VALUE;}
 		}
 		return (int) integer;
 	}
/**
		@return the largest sum of consecutive integers found in the sequence
		It does this by looping through it and on, directly eliminating the negative integers
		large enough to cancelling out the sum, by equaling them to zero, and then taking
		sum after sum and comparing it to a largestSum which would inevitably store
		only the largest sum.
	*/

 	public int getMaxSum(){
 		int currentSum = 0, largestSum = 0;
 		for(int i = 0; i<size; i++){
 			currentSum = currentSum + data[i];
 			if(currentSum > largestSum) largestSum = currentSum;
 			if(currentSum < 0) currentSum = 0;
 		}
 		return largestSum;
 	}
}	





