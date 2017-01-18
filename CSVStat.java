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

    public static Comparable average(int col, CSVArray csv){
	return 0;
    }

    public static double standardDev(int col, CSVArray csv){
	return 0;
    }

    public static double correlation(Object function, CSVArray csv){
	return 0;
    }
}
