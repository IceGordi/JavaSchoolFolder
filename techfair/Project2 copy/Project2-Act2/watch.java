/*
Marc Raul Schunk
Sun 29 Sept 
Project2-Act2
This programm basically take a time in the hours:minutes format and then inverts it, meaning 
basically it takes the time as an analog watch and turns it around by 180 degrees.
*/
import java.util.Scanner;
public class watch{
	public static void main(String[] args){
		//Print statement, ask for input
		System.out.println(" What time does your upside-down watch read (hours:minutes)?:");
		Scanner keyboard_input = new Scanner(System.in);
		//Store in variable
		String inputString = keyboard_input.nextLine();
		int colon = inputString.indexOf(":");
		//Extract hours and minutes as substrings
		int hours,minutes;
		if (colon==2){
		 hours = Integer.parseInt(inputString.substring(0,2));
		 minutes = Integer.parseInt(inputString.substring(3));
		}
		else{
		 hours = Integer.parseInt(inputString.substring(0,1));
		 minutes = Integer.parseInt(inputString.substring(2));	
		}
		//add 6:30 to the time while making sure it doesnt pass the 12:60 threshold
		hours=hours + 6;
		if(hours>12){
			//could also use modulus operator...
			int diffH = hours - 12;
			hours = diffH;
		}
		minutes=minutes+30;
		if(minutes>60){
			//same, could also use modulus operator...
			int diffM = minutes - 60;
			minutes = diffM;
		}
		//Print result
		System.out.println(" The right-side-up time is:  " + hours + ":" + minutes);
	}
}