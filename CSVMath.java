import java.util.ArrayList;

public class CSVMath{
    /*=======================================================
      Mathematical Operations
      =====================================================*/

    /**
     * Returns a double that is equal to the sum of a column's data. 
     * Add the data to the sum.
     * @param   col  integer within column range
     * @param   csv  CSVArray
     * @return  Comparable representing sum of column's data
     */
    public static double sum(int col, CSVArray csv){
        double s = 0.;
	for (ArrayList<Object> row : csv._data){
	    s += (double) row.get(col-1);
	}
	return s;
    }

    /**
     * Returns an ArrayList of Doubles that contains the sum of two 
     * columns' data, added across rows. 
     * After typecasting both values, add them together.
     * Add the sum into the ArrayList of sums.
     * Repeat previous steps for each row.
     * @param   col1  integer within column range
     * @param   col2  integer within column range
     * @param   csv   CSVArray
     * @return  ArrayList containing Doubles that represent each row's sum
     */
    public static ArrayList add(int col1, int col2, CSVArray csv){
	ArrayList<Double> temp = new ArrayList();
	double s = 0.;
	for (ArrayList<Object> row : csv._data){
	    s = 0.;
	    s += (double) row.get(col1-1);
	    s += (double) row.get(col2-1);
	    temp.add(s);
	}
	return temp;
    }

    /**
     * Returns an ArrayList of Doubles that contains the differences of two 
     * columns' data, subtracted across rows. 
     * Typecast the first column data into a double.
     * Set the first column's data as a variable.
     * Typecast the second column data into a double.
     * Subtract the second column's data from the first column's data.
     * Add that difference to the ArrayList of differences.
     * Repeat previous steps for each row.
     * @param   col1  integer within column range
     * @param   col2  integer within column range
     * @param   csv   CSVArray
     * @return  ArrayList containing Doubles that represent each row's difference
     */
    public static ArrayList subtract(int col1, int col2, CSVArray csv){
        ArrayList<Double> temp = new ArrayList();
	double s = 0.;
	for (ArrayList<Object> row : csv._data){
	    s = 0.;
	    s = (double) row.get(col1-1);
	    s -= (double) row.get(col2-1);
	    temp.add(s);
	}
	return temp;
    }

    /**
     * Returns an ArrayList of Doubles that contains the products of two 
     * columns' data, multiplied across rows. 
     * Typecast the first column data into a double.
     * Set the first column's data as a variable.
     * Typecast the second column data into a double.
     * Multiply the second column's data with the first column's data.
     * Add that product to the ArrayList of products.
     * Repeat previous steps for each row.
     * @param   col1  integer within column range
     * @param   col2  integer within column range
     * @param   csv   CSVArray
     * @return  ArrayList containing Doubles that represent each row's product
     */
    public static ArrayList multiply(int col1, int col2, CSVArray csv){
	ArrayList<Double> temp = new ArrayList();
	double s = 0.;
	for (ArrayList<Object> row : csv._data){
	    s = 0.;
	    s = (double) row.get(col1-1);
	    s *= (double) row.get(col2-1);
	    temp.add(s);
	}
	return temp;
    }

    /**
     * Returns an ArrayList of Doubles that contains the products of two 
     * columns' data, divided across rows. 
     * Typecast the first column data into a double.
     * Set the first column's data as a variable.
     * Typecast the second column data into a double.
     * Divide the second column's data with the first column's data.
     * Add that product to the ArrayList of products.
     * Repeat previous steps for each row.
     * @param   col1  integer within column range
     * @param   col2  integer within column range
     * @param   csv   CSVArray
     * @return  ArrayList containing Doubles that represent each row's quotient
     */
    public static ArrayList divide(int col1, int col2, CSVArray csv){
	ArrayList<Double> temp = new ArrayList();
	double s = 0.;
	for (ArrayList<Object> row : csv._data){
	    s = 0.;
	    s = (double) row.get(col1-1);
	    s /= (double) row.get(col2-1);
	    temp.add(s);
	}
	return temp;
    }
}
