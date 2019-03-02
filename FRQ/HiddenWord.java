public class HiddenWord{
	private String hiddenWord;
	public HiddenWord (String word)
		{
		hiddenWord = word;
		}
	public String getHint(String hint)
		{
			String result = "";
			String result2 = "";
			int counter = 0;
			for(int hi=0;hi<hint.length();hi++)
			{
				for(int hd=0;hd<hint.length();hd++)
				{
					if(hint.charAt(hi) == hiddenWord.charAt(hd)){
						result+=hint.charAt(hd);
						break;
					}
					else
					{
						result+="-";
					}	
				}
			}
			boolean state = false;
			for(int re=0;re<hint.length();re++)
			{
				if(result.charAt(re)=='-'){
					for(int re2=0;re2<hint.length();re2++)
					{
						if(hint.charAt(re) == hiddenWord.charAt(re2)&&re!=re2)
						{
							state=true;
						}
					}
					if(state)
						result2 += '+';
					else
						result2 += '*';
				}
				else if(result.charAt(re)!='-')
				{
					result2+=result.charAt(re);
				}
			}
			return result2;
		}	
}