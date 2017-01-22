import java.util.ArrayList;

public class CSVStat{
    
    /*=======================================================
      Statistics Methods
      =====================================================*/
    public static Comparable min(int col, CSVArray csv){
	ArrayList<Object> arr = csv.getCol(col);
	Comparable min = (Comparable) arr.get(0);
	for (int i = 1; i < arr.size(); i++) {
	    if (((Comparable)arr.get(i)).compareTo( min ) < 0) {
		min = (Comparable) arr.get(i);
	    }
	}
	return min;
    }

    public static Comparable firstQ(int col, CSVArray csv){
	return 0;
    }

    public static Comparable median(int col, CSVArray csv){
	return 0;
    }
    
    public static Comparable thirdQ(int col, CSVArray csv){
	return 0;
    }

    public static Comparable max(int col, CSVArray csv){
        ArrayList<Object> arr = csv.getCol(col);
	Comparable max = (Comparable) arr.get(0);
	for (int i = 1; i < arr.size(); i++) {
	    if (((Comparable)arr.get(i)).compareTo( max ) > 0) {
		max = (Comparable) arr.get(i);
	    }
	}
	return max;
    }

    public static void statSummary(int col, CSVArray csv){
    }

    public static String boxAndWhisker(int col, CSVArray csv){
	return "";
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
	    if (colValues.get(i) instanceof Integer) {
		variance += Math.pow(((int)colValues.get(i) - average), 2);
	    } else {
		variance += Math.pow(((double)colValues.get(i) - average), 2);
	    }
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
