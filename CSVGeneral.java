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

    public static ArrayList getRow(int row, CSVArray csv){
	return csv._data.get(row-1);
    }

    public static ArrayList getCol(int col, CSVArray csv){
        ArrayList column = new ArrayList();
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
      Add Methods
      =====================================================*/
    public static CSVArray addCol(CSVArray col, CSVArray csv){
	int index = 0;
	for (ArrayList<Object> row : csv._data){
	    row.add(col._data.get(index));}
	return csv;
    }

    public static CSVArray addCol(CSVArray col, int pos, CSVArray csv){
	int index = 0;
	for (ArrayList<Object> row : csv._data){
	    row.add(pos,csv._data.get(index));
	}
	return csv;
    }

    public static CSVArray addRow(CSVArray row, CSVArray csv){
	csv._data.add(row._data);
	return csv;
    }

    public static CSVArray addRow(CSVArray row, int pos, CSVArray csv){
	csv._data.add(pos,row._data);
	return csv;
    }
    
    /*=======================================================
      Delete Methods
      =====================================================*/
    public static CSVArray deleteCell(int x, int y, CSVArray csv){
	ArrayList temp = csv._data.get(y-1);
	temp.set(x-1, null);
	csv._data.set(y-1, temp);
	return csv;
    }

    public static CSVArray deleteRow(int row, CSVArray csv){
	csv._data.remove(row-1);
	return csv;
    }

    public static CSVArray deleteCol(int col, CSVArray csv){
	for (ArrayList<Object> row : csv._data){
	    row.remove(col-1);
	}
	return csv;
    }  
}
