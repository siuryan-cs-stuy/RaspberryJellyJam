/**
 * The class CSV reads in a CSV file, converting it into a 2d ArrayList of 
 * Objects for use in the CSVTool class.
 */

import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
    
public class CSVArray{

    // ******* INSTANCE VARS *******
    public ArrayList<ArrayList> _data;
    private String _filename;
    
    // *****************************

    
    /**
     * Overloaded constructor for CSVArray. The filename argument must specify
     * a relative file path. The instance of CSVArray is populated with data
     * after this constructor is called.
     *
     * @param  filename  a relative file path pointing to a .csv file
     */
    public CSVArray(String filename) throws FileNotFoundException{
	_data = new ArrayList();
	_filename = filename;

	// creating new File instance to reference file
	try{
	    File csv = new File(_filename);          

	// creating new Scanner instance to read file
	Scanner s = new Scanner(csv);

	// reading data from file
	while (s.hasNextLine()) {
	    Scanner line = new Scanner(s.nextLine()); //create scanner to go through each row

	    //Set delimiter to , to divide csv elements
	    line.useDelimiter(",");

	    ArrayList row = new ArrayList();
	    while(line.hasNext()){
		row.add(typePicker(line.next()));
	    }
	    
	    // add row to _data
	    _data.add(row);
	    
	    line.close();
	}
	s.close();
	} catch(FileNotFoundException e){
	    e.printStackTrace();
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
	String retStr = "";
	for(ArrayList list: _data){
	    String row = "";
	    int lastElem = list.size()-1;
	    for(int i = 0; i < lastElem; i++){
	       row += list.get(i) + ",";
	    }
	    row += list.get(lastElem)+"\n";
	    retStr += row;
	}
	return retStr;
    }

    /**
     * Writes data contained in CSVArray to the file specified by the user.
     * Assumes that the constructor has already been called.
     */
    public void write() throws IOException{
	try {
	    BufferedWriter bw = new BufferedWriter(new FileWriter(_filename));
	    bw.write(this.toString());
	    bw.close();
	} catch (IOException e) {
	    e.printStackTrace();
	}
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
