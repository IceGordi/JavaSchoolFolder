public class SparseArray{
	 public int getValueAt(int row, int col){
	 	for(int i=0;i<entries.size();i++)
	 	{
	 		if(i.getRow()==row&&i.getCol()==col)
	 			return i.getValue();
	 	}
	 	return 0;
	 } 

	  public void removeColumn(int col){
	  	int value;
	  	int row;
	  	int columnl
	  	for(int i=0;i<entries.size();i++){
	  		if(i.getCol==col)
	  		{
	  			entries.remove(i);
	  			continue;
	  		}
	  		if(i.getCol<col)
	  		{
	  			value = i.getValue;
	  			row = i.getRow;
	  			column = i.getCol;
	  			boolean lol = entries.remove(i);
	  			boolean lol = entries.add(new SparseArrayEntry(row,column,value));
	  		}
	  	}
	  	numCols--;
	  } 
}