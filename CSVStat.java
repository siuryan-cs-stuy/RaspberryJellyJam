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

    public static double firstQ(int col, CSVArray csv){
	return 0;
    }

    public static double median(int col, CSVArray csv){
	return 0;
    }

    public static double thirdQ(int col, CSVArray csv){
	return 0;
    }

    public static double max(int col, CSVArray csv){
	return 0;
    }

    public static void statSummary(int col, CSVArray csv){
    }

    public static String boxAndWhisker(int col, CSVArray csv){
	return "";
    }

    public static double average(int col, CSVArray csv){
	return 0;
    }

    public static double standardDev(int col, CSVArray csv){
	return 0;
    }

    public static double correlation(Object function, CSVArray csv){
	return 0;
    }
}
