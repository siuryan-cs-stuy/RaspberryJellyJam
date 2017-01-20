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
	return 0;
    }
}
