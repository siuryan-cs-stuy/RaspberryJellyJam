import java.util.ArrayList;

public class CSVMath{
    /*=======================================================
      Mathematical Operations
      =====================================================*/

    /**
     * Returns a Double that is equal to the sum of a column's data. 
     * If the data is a Integer, typecast it into a Integer. 
     * Then get its value as a double.
     * If an Object is a Double, typecast it into a Double.
     * Add the data to the sum.
     * @param   col  integer within column range
     * @param   csv  CSVArray
     * @return  Comparable representing sum of column's data
     */
    public static double sum(int col, CSVArray csv){
        double s = 0.;
	for (ArrayList<Object> row : csv._data){
	    if (row.get(col-1) instanceof Integer){
		s += (int) row.get(col-1);}
	    else if (row.get(col-1) instanceof Double){
		s += (double) row.get(col-1);}
	}
	return s;
    }

    /**
     * Returns an ArrayList of Doubles that contains the sum of two 
     * columns' data, added across rows. 
     * If an Object is a Integer, typecast it into an int.
     * If an Object is a Double, typecast it into a Double.
     * After typecasting both values, add them together.
     * Add the sum into the ArrayList of sums.
     * Repeat previous steps for each row.
     * @param   col  integer within column range
     * @param   col  integer within column range
     * @param   csv  CSVArray
     * @return  ArrayList containing Doubles that represent each row's sum
     */
    public static ArrayList add(int col1, int col2, CSVArray csv){
	ArrayList<Double> temp = new ArrayList();
	double s = 0.;
	for (ArrayList<Object> row : csv._data){
	    s = 0.;
	    if (row.get(col1-1) instanceof Integer){
		s += (int) row.get(col1-1);
	    }
	    if (row.get(col2-1) instanceof Integer){
		s += (int) row.get(col2-1);
	    }
	    if (row.get(col1-1) instanceof Double){
		s += (double) row.get(col1-1);
	    }
	    if (row.get(col2-1) instanceof Double){
		s += (double) row.get(col2-1);
	    }
	    temp.add(s);
	}
	return temp;
    }

    /**
     * Returns an ArrayList of Doubles that contains the differences of two 
     * columns' data, subtracted across rows. 
     * If the first column's data is an Integer, typecast it into an int.
     * Then get its value as a double.
     * If the first column's data is a Double, typecast it into a Double.
     * Set the first column's data as a variable.
     * Run through whether the second column's data is an Integer or a Double,
     * and typecast accordingly.
     * Subtract the second column's data from the first column's data.
     * Add that difference to the ArrayList of differences.
     * Repeat previous steps for each row.
     * @param   col  integer within column range
     * @param   col  integer within column range
     * @param   csv  CSVArray
     * @return  ArrayList containing Doubles that represent each row's difference
     */
    public static ArrayList subtract(int col1, int col2, CSVArray csv){
        ArrayList<Double> temp = new ArrayList();
	double s = 0.;
	for (ArrayList<Object> row : csv._data){
	    s = 0.;
	    if (row.get(col1-1) instanceof Integer){
		s = (int) row.get(col1-1);
	    }
	    if (row.get(col1-1) instanceof Double){
		s = (double) row.get(col1-1);
	    }
	    if (row.get(col2-1) instanceof Integer){
		s -= (int) row.get(col2-1);
	    }
	    if (row.get(col2-1) instanceof Double){
		s -= (double) row.get(col2-1);
	    }
	    temp.add(s);
	}
	return temp;
    }

    /**
     * Returns an ArrayList of Doubles that contains the products of two 
     * columns' data, multiplied across rows. 
     * If the first column's data is an Integer, typecast it into an Integer.
     * Then get its value as a double.
     * If the first column's data is a Double, typecast it into a Double.
     * Set the first column's data as a variable.
     * Run through whether the second column's data is an Integer or a Double,
     * and typecast accordingly.
     * Multiply the second column's data with the first column's data.
     * Add that product to the ArrayList of products.
     * Repeat previous steps for each row.
     * @param   col  integer within column range
     * @param   col  integer within column range
     * @param   csv  CSVArray
     * @return  ArrayList containing Doubles that represent each row's product
     */
    public static ArrayList multiply(int col1, int col2, CSVArray csv){
	ArrayList<Double> temp = new ArrayList();
	Double s = 0.;
	Integer x = 0;
	Integer y = 0;
	for (ArrayList<Object> row : csv._data){
	    s = 0.;
	    if (row.get(col1-1) instanceof Integer){
		x = (Integer) row.get(col1-1);
		s = x.doubleValue();
	    }
	    if (row.get(col1-1) instanceof Double){
		s = (Double) row.get(col1-1);
	    }
	    if (row.get(col2-1) instanceof Integer){
		y = (Integer) row.get(col2-1);
		s *= y.doubleValue();
	    }
	    if (row.get(col2-1) instanceof Double){
		s *= (Double) row.get(col2-1);
	    }
	    temp.add(s);
	}
	return temp;
    }

    /**
     * Returns an ArrayList of Doubles that contains the quotients of two 
     * columns' data, divided across rows. 
     * If the first column's data is an Integer, typecast it into an Integer.
     * Then get its value as a double.
     * If the first column's data is a Double, typecast it into a Double.
     * Set the first column's data as a variable.
     * Run through whether the second column's data is an Integer or a Double,
     * and typecast accordingly.
     * Divide the second column's data with the first column's data.
     * Add that quotient to the ArrayList of quotients.
     * Repeat previous steps for each row.
     * @param   col  integer within column range
     * @param   col  integer within column range
     * @param   csv  CSVArray
     * @return  ArrayList containing Doubles that represent each row's quotient
     */
    public static ArrayList divide(int col1, int col2, CSVArray csv){
	ArrayList<Double> temp = new ArrayList();
	Double s = 0.;
	Integer x = 0;
	Integer y = 0;
	for (ArrayList<Object> row : csv._data){
	    s = 0.;
	    if (row.get(col1-1) instanceof Integer){
		x = (Integer) row.get(col1-1);
		s = x.doubleValue();
	    }
	    if (row.get(col1-1) instanceof Double){
		s = (Double) row.get(col1-1);
	    }
	    if (row.get(col2-1) instanceof Integer){
		y = (Integer) row.get(col2-1);
		s /= y.doubleValue();
	    }
	    if (row.get(col2-1) instanceof Double){
		s /= (Double) row.get(col2-1);
	    }
	    temp.add(s);
	}
	return temp;
    }
}
