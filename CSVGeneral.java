/**
 * The class CSVGeneral contains all the methods for general CSV file editing.
 */

import java.util.ArrayList;

public class CSVGeneral{

    /*=======================================================
      Pretty print
      =====================================================*/
    public static String prettyPrint(CSVArray csv) {
	String retStr = "";
	int rowNum = 1;
	int[] maxSizes = new int[csv._data.get(0).size()];
	Integer numRows = ((Integer) csv._data.size()).toString().length();

	// Fills maxSizes with the length of the largest items in each row
	for (int i = 0; i < maxSizes.length; i++) {
	    maxSizes[i] = maxSize( csv.getCol(i+1) );
	}

	// Adds column number labels
	retStr += colLabel( maxSizes, numRows );
	
	// Adds table top
        String bar = tableBarrier( maxSizes, numRows );
	retStr += bar;

	// Adds data
        for (ArrayList<Object> row : csv._data) {
	    retStr += formatCell(rowNum,numRows);
	    for (int i = 0; i < row.size(); i++) {
		retStr += formatCell(row.get(i),maxSizes[i]);
	    }
	    retStr += "\n";
	    rowNum++;
	}

	// Adds table bottom
	retStr += bar;	

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

    // For columns
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

    // For rows
    private static int maxSize(int[] maxSizes, Integer numRows) {
	int size = 0;
	int cols = 0;
	for (int i : maxSizes) {
	    size += i;
	    cols++;
	}
	return size + cols + numRows + 1;
    }

    private static String tableBarrier(int[] maxSizes, Integer numRows) {
	String retStr = "";
	for (int i = 0; i < maxSize( maxSizes, numRows ); i++) {
	    retStr += "=";
	}
	return retStr + "\n";
    }

    private static String colLabel(int[] maxSizes, Integer numRows) {
	String retStr = "";
	for (int i = 0; i < numRows; i++) {
	    retStr += " ";
	}
	retStr += "|";
	for (int i = 0; i < maxSizes.length; i++) {
	    retStr += formatCell(i+1, maxSizes[i]);
	}
	return retStr + "\n";
    }
}
