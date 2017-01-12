/**
 * The class CSV reads in a CSV file, converting it into a 2d ArrayList of 
 * Objects for use in the CSVTool class.
 */

import java.util.ArrayList;
import java.util.Scanner;
    
public class CSVArray{

    // ******* INSTANCE VARS *******
    public ArrayList _data;
    private String _filename;
    
    // *****************************

    
    /**
     * Overloaded constructor for CSVArray. The filename argument must specify
     * a relative file path. The instance of CSVArray is populated with data
     * after this constructor is called.
     *
     * @param  filename  a relative file path pointing to a .csv file
     */
    public CSVArray(String filename){

	_filename = filename;

	// creating new File instance to reference file
	File csv = new File(_filename);

	// creating new Scanner instance to read file
	Scanner s = new Scanner(csv);

	// reading data from file
	int lineNum = 1;
	while (s.hasNextLine()) {

	    // parsing and adding data
	    ArrayList row = new ArrayList();
	    String line = s.nextLine();
	    
	    while (line.length() > 0) {
		
		int i = 0;
		if (line.substring(i,i+1).equals(",")) {
		    String cell = line.substring(0,i);
		    row.add( typePicker(cell) );
		    line = line.substring(i+1);
		    i = 0;
		} else {
		    i++;
		}
		
	    }

	    // add row to _data
	    _data.add(row);
	    
	}
    }


    /**
     * Returns the ArrayList containing the CSV data.
     *
     * @return  ArrayList containing data
     */
    public ArrayList get(){
	return _data;
    }


    /**
     * Sets the CSV data to the input arr.
     *
     * @param  arr  an ArrayList containing CSV data
     * @return  the old CSV data
     */
    public ArrayList set(ArrayList arr){
	ArrayList oldArr = _data;
	_data = arr;
	return oldArr;
    }

    
    /**
     * Overridden toString() method. Converts data to CSV format.
     *
     * @return  string containing data represented in CSV format
     */
    public String toString(){
	
    }

    /**
     * Writes data contained in CSVArray to the file specified by the user.
     * Assumes that the constructor has already been called.
     */
    public void write(){
	
    }


    /**
     * Returns an Object representation of data from its String representation. 
     * The returned Object can be an Integer, Double, or String. The most
     * specific classification will be used, in the order above.
     *
     * @param  foo  any generic String
     * @return      Object representation of foo
     */
    public Object typePicker(String foo){

	// creating object to hold foo
	Object conv;

	// sorts foo
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
