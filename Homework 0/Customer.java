public class Customer{
	private double balance;
	private double interest;
	private String name;
	private String country;
	private boolean corrupted;

	public Customer(double balance, double interest, String name, String country, boolean corrupted){
		this.balance = balance;
		this.interest = interest;
		this.name = name;
		this.country = country;
		this.corrupted = corrupted;
	}

	public double getBalance{
		return this.balance; 
	}

	public void overloadingExample(int x){
		System.out.println("here only patameter is an int");
	}
	public void overloadingExample(Stirng lol){
		System.out.println("here parameter is String, method overloaded wiht different data type" + lol);
	}
}