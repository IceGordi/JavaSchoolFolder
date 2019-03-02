public class driver{
	public static void main(String[] arg){
		Customer Abigail = new Customer(900.00, 1.02,"Abigail Williams", "Tripolitania", true);
		Customer[] CustomerCluster1 = new Customer[100];
		//Here i create an array of objects of Class Customer, which after initialization
		//each will have the characterictics that the customer class specifies, like Abigail.

		//4 the difference is that b is a reference that points towards x, which in itself is a ponter
		//towards the String object "APCS", while d is creating a new object of class string in itself
		//4b/c with the == sign it would print false becuase the only thing it is comparing is the 
		//obejct they are referecning while in the case of equals it is true because it is
		//actually a method of class String which analyzes and comapres the content of 
		//the different Strings.
		//5 the scope in which something is defined refers to the "zone" of the code in which a variable
		//exist and holds it's value, meaning that once the area in which the variable was creared
		//is exited, it would cease to exist as the memory it used to occupy is recylced.
		//7 a static variable is one that is defined in a way so that it is accesible form any scope,
		//meaning that even if it's scope is exited, one would still be able to access it because
		//the memory hasn't been given to recycle yet
		for(i = 0; i<10;i++){
			System.out.println("here I has a value");
		}
		System.out.println("Here it doesn't because it's outside the scope in which it was created"+
							"which would be the for loops' {}");
 	}
}