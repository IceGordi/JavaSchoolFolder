/*
Marc Raul Schunk
Sun 7 Sept 
Project2-Act4
This programm basically simulates the coundown of a microwave. Impotant though is that it does not use a real time
reference meaning it simulates a coundown in which each time unit does not correspond to the real life equivalent,
1 sec in the programm is not 1 second in real life.
*/
import java.util.Scanner;
public class microwave{
	/**printedcountdown takes inputs and creates a simualted coundown with it
	  *@param minutes = minutes from user input
	  *@param seconds = seconds from user input
	*/
	public static void printedcountdown(int minutes, int seconds){
		int min = minutes;
		int sec = seconds;
		//Double for loop which counts down all seconds, then adds 59 secs and substracts 1 to the minutes
		for(;min>=0;min--){
			for(;sec>=0;sec--){
				if(sec<10) System.out.println(min+":0"+sec);
				else System.out.println(min+":"+sec);
			}
			sec=59;
		}
	}
	public static void main(String[] args){
		//take user input
		Scanner keyboard_input = new Scanner(System.in);
		System.out.println("Enter the digits as input to the microwave(minutes:seconds): ");
		String input = keyboard_input.nextLine();
		int colon = input.indexOf(":");
		//subtring each value
		String stringMinutes = input.substring(0,colon);
		String stringSeconds = input.substring(colon+1);
		//convert to int for calculations
		int minutes = Integer.parseInt(stringMinutes);
		int seconds = Integer.parseInt(stringSeconds);
		printedcountdown(minutes, seconds);
	}
	
}