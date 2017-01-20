import java.util.ArrayList;

public class CSVMath{
    /*=======================================================
      Mathematical Operations
      =====================================================*/
    public static Comparable sum(int col, CSVArray csv){
        Double s = 0.;
	Integer x = 0;
	for (ArrayList<Object> row : csv._data){
	    if (row.get(col-1) instanceof Integer){
		x = (Integer) row.get(col-1);
		s += x.doubleValue();}
	    else if (row.get(col-1) instanceof Double){
		s += (Double) row.get(col-1);}
	}
	return (Comparable)s;
    }
	
    public static ArrayList add(int col1, int col2, CSVArray csv){
	ArrayList<Double> temp = new ArrayList();
	Double s = 0.;
	Integer x = 0;
	Integer y = 0;
	for (ArrayList<Object> row : csv._data){
	    s = 0.;
	    if (row.get(col1-1) instanceof Integer){
		x = (Integer) row.get(col1-1);
		s += x.doubleValue();
	    }
	    if (row.get(col2-1) instanceof Integer){
		y = (Integer) row.get(col2-1);
		s += y.doubleValue();
	    }
	    if (row.get(col1-1) instanceof Double){
		s += (Double) row.get(col1-1);
	    }
	    if (row.get(col2-1) instanceof Double){
		s += (Double) row.get(col2-1);
	    }
	    temp.add(s);
	}
	return temp;
    }
	
    public static ArrayList subtract(int col1, int col2, CSVArray csv){
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
		s -= y.doubleValue();
	    }
	    if (row.get(col2-1) instanceof Double){
		s -= (Double) row.get(col2-1);
	    }
	    temp.add(s);
	}
	return temp;
    }

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
