/**
 * A program to carry on conversations with a human user.
 * This version:
 *<ul><li>
 * 		Uses advanced search for keywords 
 *</li><li>
 * 		Will transform statements as well as react to keywords
 *</li></ul>
 * @author Laurie White
 * @version April 2012
 *
 */
public class Magpie4
{
	/**
	 * Get a default greeting 	
	 * @return a greeting
	 */	
	public String getGreeting()
	{
		return "Hello, let's talk.";
	}

	/**
	 * Gives a response to a user statement
	 * 
	 * @param statement
	 *            the user statement
	 * @return a response based on the rules given
	 */
	public String getResponse(String statement)
	{
		String response = "";
		if (statement.length() == 0)
		{
			response = "Say something, or leave me in peace.";
		}
		else if (findKeyword(statement.toLowerCase(), "hi") >= 0
				|| findKeyword(statement.toLowerCase(), "hello") >= 0)
		{
			response = "So... you gonna say anything relevant or are we just " +
			 "gonna engage in some useless idle chatter which will not only " +
			 "waste my precious time but also yours, \nnot that it would be of " +
			 "any value but might as well tell you";
		}
		else if (findKeyword(statement, "no") >= 0)
		{
			response = "Why so negative?";
		}
		else if (findKeyword(statement, "mother") >= 0
				|| findKeyword(statement, "father") >= 0
				|| findKeyword(statement, "sister") >= 0
				|| findKeyword(statement, "brother") >= 0)
		{
			response = "Please stop bruh, I dont care about your family.";
		}
		else if(findKeyword(statement, "dog") >= 0
				|| findKeyword(statement, "cat") >= 0
				|| findKeyword(statement, "fish") >=0 
				|| findKeyword(statement, "turtle") >= 0)
		{
			response = "Tell me more about your goddamn pets fella!";
		}
		else if(findKeyword(statement, "najib") >= 0
				|| findKeyword(statement,"professor") >= 0)
		{
			response = "Now who is that handsome fella you\'re talking \'bout!";
		}
		else if(findKeyword(statement,"piazza") >= 0){
			response = "Now we're talking, who is this lady you\'re talking " +
			"about, this Piazza? She seems like she be any mans dream.";
		}
		// Responses which require transformations
		else if (findKeyword(statement, "i want to", 0) >= 0)
		{
			response = transformIWantToStatement(statement);
		}
		else if(findKeyword(statement,"do you", 0) >= 0
				|| findKeyword(statement, "do u") >= 0)
		{
			response = transformDoYouStatement();
		}
		else if(findKeyword(statement, "i want", 0) >= 0){
			response = transformIWantStatement(statement);
		}
		else if(findKeyword(statement, "i", 0) >= 0 && findKeyword(statement, "you", 0) >= 0){
			response = transformISomethingYouStatement(statement);
		}
		else
		{
			// Look for a two word (you <something> me)
			// pattern
			int psn = findKeyword(statement, "you", 0);
			int psnU = findKeyword(statement, "u", 0);

			if ((psn >= 0
					&& findKeyword(statement, "me", psn) >= 0) || (psnU >=0 && findKeyword(statement, "me", psn) >= 0))
			{
				response = transformYouMeStatement(statement);
			}
			else
			{
				response = getRandomResponse();
			}
		}
		return response;
	}

	/**
	* Take I ... you statement and returns question
	* @param statement user statement, suppodes to contain "I <something> you"
	* @return the String with the reponse
	*/
private String transformISomethingYouStatement(String statement){
	statement = statement.trim().toLowerCase();
	String lastChar = statement.substring(statement
				.length() - 1);
		if (lastChar.equals("."))
		{
			statement = statement.substring(0, statement
					.length() - 1);
		}
		int psnI =  findKeyword(statement, "i", 0);
		int psnYou = findKeyword(statement, "you", 0);
		String restOfStatement = statement.substring(psnI+1, psnYou);
		return "Why do you" + restOfStatement + "me?";
}
	/**
	* Take I Want... statement and asks wether that would really make you happy
	* @param statement the user statement, contains "I Want <something>"
	* @return the String with the reponse
	*/

	private String transformIWantStatement(String statement){
		statement = statement.trim().toLowerCase();
		String lastChar = statement.substring(statement
				.length() - 1);
		if (lastChar.equals("."))
		{
			statement = statement.substring(0, statement
					.length() - 1);
		}
		int psn = findKeyword(statement, "i want", 0);
		String restOfStatement = statement.substring(psn+6).trim();
		return "Would you really be happy if you had " + restOfStatement + "?";
	}
	/**
	* Take Do you... statement and gives a negative response to whatever is asked
	* because this bot is a nasty one
	* @param none --- because the input doens't matter
	* @return the String with the reponse
	*/
	private String transformDoYouStatement(){
		return getRandomNegativeAndFunnyResponse();
	}

	/**
	 * Take a statement with "I want to <something>." and transform it into 
	 * "What would it mean to <something>?"
	 * @param statement the user statement, assumed to contain "I want to <something>"
	 * @return the transformed statement
	 */
	private String transformIWantToStatement(String statement)
	{
		//  Remove the final period, if there is one
		statement = statement.trim();
		String lastChar = statement.substring(statement
				.length() - 1);
		if (lastChar.equals("."))
		{
			statement = statement.substring(0, statement
					.length() - 1);
		}
		int psn = findKeyword (statement, "i want to", 0);
		String restOfStatement = statement.substring(psn + 9).trim();
		return "What would it mean to " + restOfStatement + "?";
	}

	/**
	 * Take a statement with "you <something> me" and transform it into 
	 * "What makes you think that I <something> you?"
	 * @param statement the user statement, assumed to contain "you" followed by "me"
	 * @return the transformed statement
	 * Improvement ---- now takes negations with don't and won't (and dont and wont for the lazy writers)
	 */
	private String transformYouMeStatement(String statement)
	{
		int negation = findKeyword(statement, "don't");
		int negationShort = findKeyword(statement, "dont");
		int negation2 = findKeyword(statement, "won't");
		int negation2Short = findKeyword(statement, "wont");

		//  Remove the final period, if there is one
		statement = statement.trim();
		String lastChar = statement.substring(statement
				.length() - 1);
		if (lastChar.equals("."))
		{
			statement = statement.substring(0, statement
					.length() - 1);
		}
		int psnOfYou, psnOfMe, psnOfU;
		String restOfStatement;
		 psnOfYou = findKeyword (statement, "you", 0);
		 psnOfMe = findKeyword (statement, "me", psnOfYou + 3);
		 psnOfU = findKeyword (statement, "u", 0);
		 restOfStatement = "";
		if(psnOfYou>=0&&psnOfMe>0){
		restOfStatement = statement.substring(psnOfYou + 3, psnOfMe).trim();
		}
		if(psnOfU>=0&&psnOfMe>0){
			restOfStatement = statement.substring(psnOfU + 3, psnOfMe).trim();
		}
		if(negation >= 0 || negationShort >=0) return "What makes you think that I don't " + restOfStatement + " you?";
		else if(negation2>= 0 || negation2Short >= 0) return "What makes you think that I won't " + restOfStatement + " you?";
		else return "What makes you think that I " + restOfStatement + " you?";
	
	}
	
	/**
	 * Search for one word in phrase. The search is not case
	 * sensitive. This method will check that the given goal
	 * is not a substring of a longer string (so, for
	 * example, "I know" does not contain "no").
	 *
	 * @param statement
	 *            the string to search
	 * @param goal
	 *            the string to search for
	 * @param startPos
	 *            the character of the string to begin the
	 *            search at
	 * @return the index of the first occurrence of goal in
	 *         statement or -1 if it's not found
	 */
	private int findKeyword(String statement, String goal,
			int startPos)
	{
		String phrase = statement.trim().toLowerCase();
		goal = goal.toLowerCase();

		// The only change to incorporate the startPos is in
		// the line below
		int psn = phrase.indexOf(goal, startPos);

		// Refinement--make sure the goal isn't part of a
		// word
		while (psn >= 0)
		{
			// Find the string of length 1 before and after
			// the word
			String before = " ", after = " ";
			if (psn > 0)
			{
				before = phrase.substring(psn - 1, psn);
			}
			if (psn + goal.length() < phrase.length())
			{
				after = phrase.substring(
						psn + goal.length(),
						psn + goal.length() + 1);
			}

			// If before and after aren't letters, we've
			// found the word
			if (((before.compareTo("a") < 0) || (before
					.compareTo("z") > 0)) // before is not a
											// letter
					&& ((after.compareTo("a") < 0) || (after
							.compareTo("z") > 0)))
			{
				return psn;
			}

			// The last position didn't work, so let's find
			// the next, if there is one.
			psn = phrase.indexOf(goal, psn + 1);

		}

		return -1;
	}
	
	/**
	 * Search for one word in phrase.  The search is not case sensitive.
	 * This method will check that the given goal is not a substring of a longer string
	 * (so, for example, "I know" does not contain "no").  The search begins at the beginning of the string.  
	 * @param statement the string to search
	 * @param goal the string to search for
	 * @return the index of the first occurrence of goal in statement or -1 if it's not found
	 */
	private int findKeyword(String statement, String goal)
	{
		return findKeyword (statement, goal, 0);
	}
	
	/**
	 * Pick a default response to use if nothing else fits.
	 * @return a non-committal string
	 */
	private String getRandomResponse()
	{
		final int NUMBER_OF_RESPONSES = 4;
		double r = Math.random();
		int whichResponse = (int)(r * NUMBER_OF_RESPONSES);
		String response = "";
		
		if (whichResponse == 0)
		{
			response = "Interesting, tell me more.";
		}
		else if (whichResponse == 1)
		{
			response = "Hmmm.";
		}
		else if (whichResponse == 2)
		{
			response = "Do you really think so?";
		}
		else if (whichResponse == 3)
		{
			response = "You don't say.";
		}

		return response;
	}
	/**
	* Returns random nasty response
	* @param none --- because the input doens't matter
	* @return the String with the reponse
	*/
	private String getRandomNegativeAndFunnyResponse()
	{
		final int NUMBER_OF_NEGATIVE_RESPONSES = 6;
		double r = Math.random();
		int whichResponse = (int)(r* NUMBER_OF_NEGATIVE_RESPONSES);
		String response = "";
		if (whichResponse == 0){
			response = "Hell no.";
		}
		else if (whichResponse == 1){
			response = "No, are you crazy.";
		}
		else if (whichResponse == 2){
			response = "For God's sake no.";
		}
		else if (whichResponse == 3){
			response = "Nope";
		}
		else if (whichResponse == 4){
			response = "Nope.... actually, wait... maybe.... yeah, no, definitely not.";
		}
		else if(whichResponse == 5){
			response = "Disgusting, no!.... That's what she said! ;)";
		}
		return response;
	}

}
