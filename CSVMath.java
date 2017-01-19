import java.util.ArrayList;

public class CSVMath{
    /*=======================================================
      Mathematical Operations
      =====================================================*/
    public static Comparable sum(int col, CSVArray csv){
        Integer s = 0;
	for (ArrayList<Object> row : csv._data){
	    s += (Integer) row.get(col-1);}
	return (Comparable)s;
    }
    
    public static CSVArray add(int col1, int col2, CSVArray csv){
	return csv;
    }

    public static CSVArray subtract(int col1, int col2, CSVArray csv){
	return csv;
    }

    public static CSVArray multiply(int col1, int col2, CSVArray csv){
	return csv;
    }

    public static CSVArray divide(int col1, int col2, CSVArray csv){
	return csv;
    }
}
