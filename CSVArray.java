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
		String line = s.nextLine();//get string representation of line
		String[] rowElems = line.split(",", -1);//split the string to get parts between commas even if it is emtpy space
		ArrayList row = new ArrayList();
		for(int i = 0; i < rowElems.length;i++){
		    row.add(typePicker(rowElems[i]));//access each element of rowElems, run it through typePicker and add it to the row
		}
	    
		// add row to _data
		_data.add(row);
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
	    conv = Double.parseDouble(foo);
	} catch (NumberFormatException e2) {
	    conv = foo;
	}
	return conv;
    }


    /*=======================================================
      Size Increase Methods
      =====================================================*/
    /**
     * Adds a given amount of empty columns to the _data.
     * @param  moreCols  number of empty columns wanted
     */
    public void increaseCols(int moreCols){
	for (int i=0; i < moreCols; i++){
	    for (ArrayList row: _data){
		row.add("");
	    }
	}
    }

    /**
     * Adds a given amount of empty rows to _data.
     * @param  moreRows  number of empty rows wanted
     */
    public void increaseRows(int moreRows){
	ArrayList row = new ArrayList(numCols());
	    for (int i = 0; i < numCols(); i++){
		row.add("");
	    }
	for (int i = 0; i< moreRows; i++){
	    _data.add(row);
	}
    }
    
    /*=======================================================
      Length Methods
      =====================================================*/
    /**
     * @return  Number of rows in the CSV
     */
    public int numRows(){
	return _data.size();
    }

    /**
     * @return  Number of columns in the csv
     */
    public int numCols(){
	return _data.get(0).size();
    }
    
    /*=======================================================
      Accessor Methods
      =====================================================*/
    /**
     * Returns the data of a specified coordinate.
     * @param  x  row number
     * @param  y  column number
     * @return    Object representation of data
     */
    public Object getCell(int x, int y){
        return _data.get(y-1).get(x-1);
    }

     /**
     * Returns a csv's row represented by an ArrayList of Objects.
     * @param  row  row number
     * @return      row represented by ArrayList of Objects
     */
    public ArrayList getRow(int row){
	return _data.get(row-1);
    }

     /**
     * Returns a csv's column represented by an ArrayList of Objects.
     * @param  col  column number
     * @return      column represented by ArrayList of Objects
     */
    public ArrayList getCol(int col){
        ArrayList column = new ArrayList();
	for (ArrayList row : _data){
	    column.add(row.get(col-1));
	}
	return column;
    }

    /*=======================================================
      Set Methods
      =====================================================*/
     /**
     * Sets a specified cell to a given value.
     * @param  x      row number
     * @param  y      column number
     * @param  value  any Object
     * @return        String representation of CSVArray
     */
    public CSVArray setCell(int x, int y, Object value){
	_data.get(y-1).set(x-1,value);
	return this;
    }
     /**
     * Sets a specified row to a given ArrayList.
     * @param  rowPos   row number
     * @param  rowVal   ArrayList containing Objects
     * @return      String representation of CSVArray
     */
    public CSVArray setRow(CSVArray rowVal, int rowPos){
	if(rowVal.numCols() > this.numCols()){
	    this.increaseCols(rowVal.numCols()-this.numCols());
	}
	_data.set(rowPos-1, rowVal._data.get(0));
	return this;
    }

    /**
     * Sets a specified column to a given ArrayList.
     * @param  colPos   column number
     * @param  colVal   ArrayList containing Objects
     * @return      String representation of CSVArray
     */
    public CSVArray setCol(CSVArray colVal, int colPos){
	if (colVal.numRows() > this.numRows()){
	    this.increaseRows(colVal.numRows()-this.numRows());
	}
	ArrayList col = colVal.getCol(1);
	for (int i = 0; i < colVal._data.size();i++){
	    _data.get(i).set(colPos-1, col.get(i));
	}
	return this;
    }
    

    /*=======================================================
      Add Methods
      =====================================================*/
     /**
     * Appends the data of a CSVArray, given that it only
     * has one row, to this CSVArray as a column.
     * @param  col  CSVArray with only one row
     * @return      String representation of CSVArray
     */
    public CSVArray addCol(CSVArray col){
	int index = 0;
	for (ArrayList<Object> row : _data){
	    row.add(col._data.get(index).get(0));
	    index++;}
	
	return this;
    }

    /**
     * Adds the data of a CSVArray, given that it only
     * has one row, to a specified position of this CSVArray
     * as a column.
     * @param  col  CSVArraywith only one row
     * @param  pos  column number
     * @return      String representation of CSVArray
     */
    public CSVArray addCol(CSVArray col, int pos){
 	int index = 0;
	if (pos >= numCols()){
	    for (ArrayList<Object> row : _data){
		for (int i = numCols(); i < pos - 2; i++){
		    row.add("");}
	    }
	}
 	for (ArrayList<Object> row : _data){
 	    row.add(pos-1,col._data.get(index).get(0));
 	    index++;
 	}
 	return this;
    }

    /**
     * Appends the data of a CSVArray, given that it only
     * has one row, to this CSVArray as a row.
     * @param  row  CSVArray with only one row
     * @return      String representation of CSVArray
     */
    public CSVArray addRow(CSVArray row){
 	int index = 0;
	if(row.numCols() > this.numCols()){
	    this.increaseCols(row.numCols()-this.numCols());
	}
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
     * as a row.
     * @param  row  CSVArray with only one row
     * @param  int  row number
     * @return      String representation of CSVArray
     */
    public CSVArray addRow(CSVArray row, int pos){
 	int index = 0;
	if(row.numCols() > this.numCols()){
	    this.increaseCols(row.numCols()-this.numCols());
	}
	if (pos >= numRows()){
	    ArrayList<Object> emptyRow = new ArrayList();
	    for (int i = 0; i < numCols(); i++){
		emptyRow.add("");}
	    for (int i = numRows() - 1; i < pos - 2; i++){
		_data.add(emptyRow);}
	}
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
     * Sets the value of a specified cell to null.
     * @param  x  row number
     * @param  y  column number
     * @return    String representation of CSVArray
     */
    public CSVArray deleteCell(int x, int y){
 	setCell(x,y,"");
 	return this;
    }

    /**
     * Removes a specified row and shifts following rows up.
     * @param  row  row number
     * @return      String representation of CSVArray
     */
    public CSVArray deleteRow(int row){
 	_data.remove(row-1);
 	return this;
    }

    /**
     * Removes a specified column and shifts following columns left.
     * @param  col  column number
     * @return      String representation of CSVArray
     */
    public CSVArray deleteCol(int col){
 	for (ArrayList<Object> row : _data){
 	    row.remove(col-1);
	}
	return this;
    }

    /*=======================================================
      Sort Methods
      =====================================================*/
    // Bubble sort method
    public ArrayList bubbleSort(ArrayList<Double> data ){
	for( int passCtr = 1; passCtr < data.size(); passCtr++ ){
            for( int i = 0; i < data.size()-1; i++ ) {
                if (data.get(i) > data.get(i+1)){ 
                    data.set( i, data.set(i+1,data.get(i)) );   
		}
	    }
	}
	return data;
    }

    /**
     * Sorts a given column of integers
     * @param   col        position of column to be sorted
     * @return  ArrayList representation of sorted column
     */
    public ArrayList sort(int col){
	return bubbleSort(getCol(col));
    }
    
    /*=======================================================
      Search Method
      =====================================================*/

     /**
     * Searches for a given String and returns the first cell coordinates of 
     * which the instances are found.
     * @param  String  search phrase
     * @return CSVArray representation of coordinates, or empty ArrayList if phrase is not found
     */
    public ArrayList searchCell(String target){
	Object targetTrue = typePicker(target);
	ArrayList coordinates = new ArrayList(2);
	for (int row = 1; row < numRows()+1; row++){
	    for(int col = 1; col < numCols()+1; col++){
		if(getCell(col, row).equals(targetTrue)){
		    coordinates.add(col);
		    coordinates.add(row);
		    return coordinates;
		}
	    }
	}
	return coordinates;
    }
    
    /**
     * Searches for a given String and returns the row number of which the first instance is found
     * @param  target  search phrase
     * @return Row number of target, or -1 if not found
     */
    public int searchRow(String target){
	ArrayList coords = searchCell(target);
	if (coords.size() == 0){
	    return -1;
	}
	else{
	    return (Integer)coords.get(1);
	}
    }

    /**
     * Searches for a given String and returns the column of which the first instance is found
     * @param  target  search phrase
     * @return Column number of target, or -1 if not found
     */
    public int searchCol(String target){
	ArrayList coords = searchCell(target);
	if (coords.size() == 0){
	    return -1;
	}
	else{
	    return (Integer)coords.get(0);
	}
    }
}

