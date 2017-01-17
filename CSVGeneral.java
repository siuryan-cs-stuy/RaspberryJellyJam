/**
 * The class CSVGeneral contains all the methods for general CSV file editing.
 */

import java.util.ArrayList;

public class CSVGeneral{
    
    /*=======================================================
      Accessor Methods
      =====================================================*/
    
    public static Object getCell(int x, int y, CSVArray csv){
        return csv._data.get(y-1).get(x-1);
    }

    public static ArrayList<Object> getRow(int row, CSVArray csv){
	return csv._data.get(row-1);
    }

    public static ArrayList<Object> getCol(int col, CSVArray csv){
        ArrayList<Object> column = new ArrayList<Object>();
	for (ArrayList<Object> row : csv._data){
	    column.add(row.get(col-1));
	}
	return column;
    }

    /*=======================================================
      Set Methods
      =====================================================*/
    public static CSVArray setCell(int x, int y, Object value, CSVArray csv){
	csv._data.get(y-1).set(x-1,value);
	return csv;
    }

    public static CSVArray setRow(int rowPos, ArrayList rowVal, CSVArray csv){
	csv._data.set(rowPos, rowVal);
	return csv;
    }

    public static CSVArray setCol(int colPos, ArrayList colVal, CSVArray csv){
        int index = 0;
	for (ArrayList<Object> row : csv._data){
	    row.set(colPos,colVal.get(index));
	    index++;
	}
	return csv;
    }


    /*=======================================================
      Pretty print
      =====================================================*/
    public static String prettyPrint(CSVArray csv) {
	String retStr = "";
	int rowNum = 1;
	int[] maxSizes = new int[csv._data.get(0).size()];
	Integer numRows = ((Integer) csv._data.size()).toString().length();

	for (int i = 0; i < maxSizes.length; i++) {
	    maxSizes[i] = maxSize( getCol(i+1,csv) );
	}
	
        for (ArrayList<Object> row : csv._data) {
	    retStr += formatCell(rowNum,numRows);
	    for (int i = 0; i < row.size(); i++) {
		retStr += formatCell(row.get(i),maxSizes[i]);
	    }
	    retStr += "\n";
	    rowNum++;
	}
	return retStr;
    }

    private static String formatCell(Object cell, int maxSize){
	String retStr = cell.toString();
	for (int i = 0; i < maxSize - cell.toString().length(); i++) {
	    retStr += " ";
	}
	retStr += "|";
	return retStr;
    }

    private static int maxSize(ArrayList col) {
	int size = 0;
	for (int i = 0; i < col.size(); i++) {
	    int currentSize = col.get(i).toString().length();
	    if (currentSize > size) {
		size = currentSize;
	    }
	}
	return size;
    }
}
