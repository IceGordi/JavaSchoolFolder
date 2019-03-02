public class Square{
public static void main(String[] args){
	// A return refers to the information given back by the function after it has executed, genrrally performed thoruhg the keyword
	// reutrn and there are various type like boolean, String, double... and void which doesn't return anything
// They are the information fed to a function on which's basis it operates
double x = 69;
double y = 69;
double sexySquare = Square(x,y);
AllThemSquares(2);
String sexyString = "That one day that i saw your face and thought it had a bug";
rintAllThemCharacters(sexyString);
String notSoSexyString = "That onde day i looked into a mirror and it broke because of how ugly i was";
char theCharImShearchingFor = 'l';
System.out.println(isThatCharInThatStringSomewhere(notSoSexyString,theCharImShearchingFor));
}

public static double Square(double number, double exponent){
	double result = Math.pow(number, exponent);
	return result;
}
public static void AllThemSquares(int exponent){
for(int i=0;i<=10;i++){
	System.out.println(Math.pow(i, exponent));
}
}

public static void rintAllThemCharacters(String inputStuff){
	int length = inputStuff.length();
	for(int i=0;i<length;i++){
		char theOneImCurrentlyInterestedIn = inputStuff.charAt(i);
		System.out.println(theOneImCurrentlyInterestedIn);
	}
}

public static boolean isThatCharInThatStringSomewhere(String notSoSexyString, char theThingImSearchingFor){
	notSoSexyString.toLowerCase();
	int result = notSoSexyString.indexOf(theThingImSearchingFor);
	if (result!=-1) return true;
	else return false;
}
}