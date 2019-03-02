/*
Marc Raul Schunk
Sun 23 Sept 
Project1
Basically this is a programm whose purpose is to take a temperature and wind speed, in fahrenheit/celsius or mph/kmh and
then calculates windchill, actuak temperature felt, based on that.
*/
import java.util.Scanner;
public class apcsProject1{
	public static void main(String[] args){
		// Create object of class Scanner
		Scanner keyboard_input = new Scanner(System.in);
		int choiceUnits;
		double windChill;
		while(true){
			System.out.println("Welcome to the windchill calculator!");
			System.out.println("Please choose 0 if you would like to use Celsius for temperature and km/h for wind speed, or 1"
				+ " if you prefer Fahrenheit and mph:");
			choiceUnits = keyboard_input.nextInt();
			if(choiceUnits == 0 || choiceUnits == 1)break;
			else System.out.println("An error occured, please limit your answer to 0 or 1");
		}
		System.out.println("Enter the temperature: ");
		// Assign valye to temperature variable
		double temp = keyboard_input.nextDouble();
		System.out.println("Enter the wind speed: ");
		//Same with windspeed, but the min windspeed for this formula to work needs to be 1, with 0 errors occur.
		double windSpeed = keyboard_input.nextDouble();
		if(windSpeed < 1) windSpeed = 1;
		// Calculation of windchill with Fahrenheit and mph, formula extracted from following youtube video: 
		// https://www.youtube.com/watch?v=M0p4i444wrs
		// Calculation of windchill with Celsius and km/h, formula extracted from following url: 
		// https://www.freemathhelp.com/wind-chill.html
		if(choiceUnits == 1){
		 windChill = 35.74+0.6215*temp+Math.pow(windSpeed,0.16)*(0.4275*temp-35.75);
		}
		else{
		 windChill = 13.12+0.6125*temp-11.37*Math.pow(windSpeed,0.16)+0.3965*temp*Math.pow(windSpeed,0.16);
		}
		System.out.println("At "+temp+" degrees, with a wind speed of "+windSpeed+" miles per hour,"+
		" the windchill is:" + windChill);
	}
}