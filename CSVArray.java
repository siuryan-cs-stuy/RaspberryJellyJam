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
	    BufferedWriter bw = new BufferedWriter(new FileWriter(this._filename));
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
    public static Object typePicker(String foo){

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

    /*=======================================================
      Accessor Methods
      =====================================================*/
    /**
     * Returns the data of a specified coordinate.
     * @param  int  within range of rows
     * @param  int  within range of columns
     * @return      Object representation of data
     */
    public Object getCell(int x, int y){
        return _data.get(y-1).get(x-1);
    }

     /**
     * Returns a csv's row represented by an ArrayList of Objects
     * @param  int within range of rows
     * @return      row represented by ArrayList of Objects
     */
    public ArrayList<Object> getRow(int row){
	return _data.get(row-1);
    }

     /**
     * Returns a csv's column represented by an ArrayList of Objects
     * @param  int within range of columns
     * @return      column represented by ArrayList of Objects
     */
    public ArrayList<Object> getCol(int col){
        ArrayList<Object> column = new ArrayList<Object>();
	for (ArrayList<Object> row : _data){
	    column.add(row.get(col-1));
	}
	return column;
    }

    /*=======================================================
      Set Methods
      =====================================================*/
     /**
     * Sets a specified cell to a given value
     * @param  int  within range of rows
     * @param  int  within range of columns
     * @param  Object  any Object
     * @return      String representation of CSVArray
     */
    public CSVArray setCell(int x, int y, Object value){
	_data.get(y-1).set(x-1,value);
	return this;
    }
     /**
     * Sets a specified row to a given ArrayList
     * @param  int  within range of rows
     * @param  ArrayList  containing Objects
     * @return      String representation of CSVArray
     */
    public CSVArray setRow(int rowPos, ArrayList rowVal){
	_data.set(rowPos, rowVal);
	return this;
    }

    /**
     * Sets a specified column to a given ArrayList
     * @param  int  within range of columns
     * @param  ArrayList  containing Objects
     * @return      String representation of CSVArray
     */
    public CSVArray setCol(int colPos, ArrayList colVal){
        int index = 0;
	for (ArrayList<Object> row : _data){
	    row.set(colPos,colVal.get(index));
	    index++;
	}
	return this;
    }

    /*=======================================================
      Add Methods
      =====================================================*/
     /**
     * Appends the data of a CSVArray, given that it only
     * has one row, to this CSVArray as a column
     * @param  CSVArray  with only one row
     * @return      String representation of CSVArray
     */
    public CSVArray addCol(CSVArray col){
	int index = 0;
	for (ArrayList<Object> row : _data){
	    row.add(col._data.get(0).get(index));
	    index++;}
	return this;
    }

    /**
     * Adds the data of a CSVArray, given that it only
     * has one row, to a specified position of this CSVArray
     * as a column
     * @param  CSVArray  with only one row
     * @param  int  within range of columns
     * @return      String representation of CSVArray
     */
    public CSVArray addCol(CSVArray col, int pos){
 	int index = 0;
 	for (ArrayList<Object> row : _data){
 	    row.add(pos-1,col._data.get(0).get(index));
 	    index++;
 	}
 	return this;
    }

    /**
     * Appends the data of a CSVArray, given that it only
     * has one row, to this CSVArray as a row
     * @param  CSVArray  with only one row
     * @return      String representation of CSVArray
     */
    public CSVArray addRow(CSVArray row){
 	int index = 0;
 	ArrayList<Object> temp = new ArrayList();
 	for (Object o : row._data.get(0)){
 	    temp.add(row._data.get(0).get(index));
 	    index++;
	}
	_data.add(temp);
 	return this;
    }

    /**
     * Adds the data of a CSVArray, given that it only
     * has one row, to a specified position of this CSVArray
     * as a row
     * @param  CSVArray  with only one row
     * @param  int  within range of rows
     * @return      String representation of CSVArray
     */
    public CSVArray addRow(CSVArray row, int pos){
 	int index = 0;
 	ArrayList<Object> temp = new ArrayList();
 	for (Object o : row._data.get(0)){
 	    temp.add(row._data.get(0).get(index));
 	    index++;
 	}
 	_data.add(pos-1,temp);
 	return this;
    }

  /*=======================================================
      Delete Methods
      =====================================================*/
    /**
     * Sets the value of a specified cell to null
     * @param  int  within range of rows
     * @param  int  within range of columns
     * @return      String representation of CSVArray
     */
    public CSVArray deleteCell(int x, int y){
 	ArrayList temp = _data.get(y-1);
 	temp.set(x-1, null);
 	_data.set(y-1, temp);
 	return this;
    }

    /**
     * Removes a specified row and shifts following rows up
     * @param  int  within range of rows
     * @return      String representation of CSVArray
     */
    public CSVArray deleteRow(int row){
 	_data.remove(row-1);
 	return this;
    }

    /**
     * Removes a specified column and shifts following columns left
     * @param  int  within range of columns
     * @return      String representation of CSVArray
     */
    public CSVArray deleteCol(int col){
 	for (ArrayList<Object> row : _data){
 	    row.remove(col-1);
	}
	return this;
    }
}
