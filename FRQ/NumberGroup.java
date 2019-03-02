public interface NumberGroup{
	List<Integer> numberGroup;
	public boolean contains(int num)
	{
		for(int i=0;i<numberGroup.size();i++){
			if(numberGroup.contains(num))
				return true;
		}
		return false;
	}
}

public class Range implements NumberGroup{
	 int[] range;
	public Range(int min,int max)
	{
		range = fill(min,max);
	}
	public int[] fill(int min,int max){
		int[] array = new int[max-min+1];
		for(int i=0;i<=array.length;i++){
			array[i] = min+i;
		}
		return array;
	}
}

public class MultipleGroups implements NumberGroup{
	private List<NumberGroup> groupList;
	@Override
	public boolean contains(int num){
		for(int i=0; i<groupList.size();i++)
		{
			for(int j=0;j<numberGroup.get(i).size();j++)
			{
				if(numberGroup.get(i).get(j)==num)
					return true;
			}
		}
		return false;
	}
}