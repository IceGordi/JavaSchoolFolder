public class isLetterInString{
		public static boolean isLetterBool(String text,char letter){
		int result = text.indexOf(letter);
		if(result != -1) return true;
		else return false;
	}

}