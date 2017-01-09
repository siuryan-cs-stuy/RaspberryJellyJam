/*
The class CSV reads in a csv file, converting it into a 2d ArrayList of Objects for use in the CSVTool class
 */

import java.util.ArrayList;
    
public class CSVArray{
    private ArrayList data;
    
    public CSV(String filename){
    }

    public String toString(){
    }

    public static Object typePicker(String foo){
	Object conv;
	try {
	    conv = Integer.parseInt(foo);
	} catch (NumberFormatException e1) {
	    try {
		conv = Double.parseDouble(foo);
	    } catch (NumberFormatException e2) {
		conv = foo;
	    }
	}
	return conv;
    }
    
}
