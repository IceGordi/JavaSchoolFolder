/******************************************************************
* @author Marc Raul Schunk
* Octiober 14,2018
* Project 3 Act 2
* Description: The program takes a file name as an input and
* prints the letters in uppercase that are not found in the file. 
* Uppercase and lowercase letters such as "A" and "a" are treated
* the same.
******************************************************************/

import java.util.Scanner;
import java.io.*;

public class letters{

	//declare a Scanner object for File i/o
	private static Scanner fileInput;

	/** Tries to open a new file and throws an exception if it fails
	  * @param file: name of the text file
	  */
	public static void openFile(String file){
		try{
			//try to open a file using the existing Scanner object
			fileInput = new Scanner(new File(file));
		}
		catch(Exception e) {
			//throw an exception if failed to open file
			System.out.println("could not find file");
		}
	}

	/** Reads the file opened by fileInput Scanner object  
	  * @param inputText: String that will hold text from input File
	  * @return a String that contains all text from file without spaces.
	  */
	public static String readFile(String inputText){
		//read next word till end of file.
		while(fileInput.hasNext()){
			//assign next word to String nextWord
			String nextWord = fileInput.next();
			inputText += nextWord;
		}
		return inputText;
	}

	/** Reads the file opened by fileInput Scanner object  
	  * @param inputText: String holds text from input File but with spaces removed.
	  * @return a String that contains letters in uppercase that are not in the file.
	  */
	public static String getLetters(String inputText){
		String result = "";
		inputText = inputText.toUpperCase();
		int index;
			for(char ch = 'A'; ch <='Z'; ch++){
				index = inputText.indexOf(ch);
				if(index == -1) result+=ch;
			}
		
		return result;
	}

	public static void main(String[] args){
		//takes file input from the command line
		String fileName = args[0];
		//creates a Scanner object to open file
		openFile(fileName);
		//reads file using fileInput object
		String inputText = new String();
		inputText = readFile(inputText);
		//takes the letters from 
		String result = getLetters(inputText);
		//Dont remove this line.
		System.out.println("Letters not in file: " +result);
	}
}