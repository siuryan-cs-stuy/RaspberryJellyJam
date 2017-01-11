/**
 * The class CSV reads in a CSV file, converting it into a 2d ArrayList of 
 * Objects for use in the CSVTool class.
 */

import java.util.ArrayList;
    
public class CSVArray{

    // ******* INSTANCE VARS *******
    private ArrayList data;
    
    // *****************************

    
    /**
     * Overloaded constructor for CSVArray. The filename argument must specify
     * a relative file path. The instance of CSVArray is populated with data
     * after this constructor is called.
     *
     * @param  filename  a relative file path pointing to a .csv file
     */
    public CSVArray(String filename){
	
    }

    
    /**
     * Overridden toString() method. Converts data to CSV format.
     *
     * @return  string containing data represented in CSV format
     */
    public String toString(){
	
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
	
    }
    
}
