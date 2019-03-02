/*
Marc Raul Schunk
Sun 27 Sept 
Project2-Act1
Basidally this programm takes the dimensions of the pool, desired additional depth and fill rate of 
your water source and based on that calculates the amount of time it will take to fill the pool by the
desired amount.
*/
import java.util.Scanner;
public class pool{
	public static void main(String[] args){
		Scanner keyboard_input = new Scanner(System.in);
		//Here I introduce the program
		System.out.println("Welcome to the pool fill time calculator,"
							+ "Please enter the following data.");
		//Start taking input, length
		System.out.println("Pool length (feet): ");
		double length = keyboard_input.nextDouble();
		//width
		System.out.println("Pool width (feet): ");
		double width = keyboard_input.nextDouble();
		//Additional depth desired, directly convert to feet
		System.out.println("Additional depth desired (inches): ");
		double addDepth = keyboard_input.nextDouble()/12;
		//Fill rate also converted directly to feet^3/s
		System.out.println(" Water fill rate (gal/min): ");
		double fillRate = keyboard_input.nextDouble()/7.480543/60;
		//now the calculation process starts
		//volume in feet^3
		double volume = width*length*addDepth;
		double timeInSec = volume/fillRate;
		timeInSec = Math.round(timeInSec);
		System.out.println(timeInSec);
		//now that i have the time it takes, I convert into the sexagesimal system
		int hours = (int)(timeInSec/3600);
		int minutes = (int)((timeInSec%3600)/60);
		int seconds = (int)(timeInSec%60);
		System.out.println("Time: "+hours +":"+ minutes + ":" + seconds);
	}
}