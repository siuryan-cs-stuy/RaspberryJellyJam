import java.util.ArrayList;

public class CSVStat{
    
    /*=======================================================
      Statistics Methods
      =====================================================*/
    public static double min(int col, CSVArray csv){
	ArrayList<Object> arr = csv.getCol(col);
	double min = Double.parseDouble( arr.get(0).toString() );
	for (int i = 1; i < arr.size(); i++) {
	    if ((Double.parseDouble(arr.get(i).toString())) < min) {
		min = Double.parseDouble(arr.get(i).toString());
	    }
	}
	return min;
    }

    public static double firstQ(int col, CSVArray csv){
	ArrayList<Object> arr = csv.sort(col);
	for (int i = arr.size()/2; i < arr.size(); i++) {
	    arr.remove(i);
	}
	return median(arr);
    }

    private static double median(ArrayList<Object> arr){
	double val1 = Double.parseDouble(arr.get( arr.size()/2 ).toString());
	if (arr.size() % 2 == 0) {
	    double val2 = Double.parseDouble(arr.get( arr.size()/2 + 1 ).toString());
	    return (val1 + val2) / 2.0;
	} else {
	    return val1;
	}
    }

    public static double median(int col, CSVArray csv){
	ArrayList<Object> arr = csv.sort(col);
	return median(arr);
	
    }
    
    public static double thirdQ(int col, CSVArray csv){
	ArrayList<Object> arr = csv.sort(col);
	for (int i = 0; i < arr.size()/2; i++) {
	    arr.remove(i);
	}
	return median(arr);
    }

    public static double max(int col, CSVArray csv){
        ArrayList<Object> arr = csv.getCol(col);
	double max = Double.parseDouble( arr.get(0).toString() );
	for (int i = 1; i < arr.size(); i++) {
	    if ((Double.parseDouble(arr.get(i).toString())) > max) {
		max = Double.parseDouble(arr.get(i).toString());
	    }
	}
	return max;
    }

    public static void statSummary(int col, CSVArray csv){
	System.out.println( "Min: " + min(col,csv) + "\n" +
			    "1Q : " + firstQ(col,csv) + "\n" +
			    "Med: " + median(col,csv) + "\n" +
			    "3Q : " + thirdQ(col,csv) + "\n" +
			    "Max: " + max(col,csv) + "\n" );
    }

    public static double average(int col, CSVArray csv){
	double sum = CSVMath.sum(col,csv);
	return sum / csv.getCol(col).size();
    }

    
    public static double standardDev(int col, CSVArray csv){
	double average = average(col,csv);
	double variance = 0;
	ArrayList<Object> colValues = csv.getCol(col);
	for (int i = 0; i < colValues.size(); i++) {
	    double val = Double.parseDouble(colValues.get(i).toString());
	    variance += Math.pow((val - average), 2);
	}
	variance /= colValues.size();
	return Math.sqrt(variance);
    }

    public static double correlation(int col1, int col2, CSVArray csv){
	double average1 = average(col1,csv);
	double average2 = average(col2,csv);
	double variance1 = Math.pow(standardDev(col1, csv), 2);
	double variance2 = Math.pow(standardDev(col2, csv), 2);
	double sum = 0;

	ArrayList<Object> col1Values = csv.getCol(col1);
	ArrayList<Object> col2Values = csv.getCol(col2);
	for (int i = 0; i < col1Values.size(); i++) {
	    double val1 = Double.parseDouble(col1Values.get(i).toString());
	    double val2 = Double.parseDouble(col2Values.get(i).toString());
	    sum += (val1 - average1) * (val2 - average2);
	}

        double r = sum / Math.sqrt(variance1 * variance2 * col1Values.size() * col2Values.size());
	return r;
	
    }
}
