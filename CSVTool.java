public class CSVTool{
    
    /*=======================================================
     Accessor Methods
      =====================================================*/
    public static Object getCell(int x, int y){
    }

    public static ArrayList getRow(int row){
    }

    public static ArrayList getCol(int col){
    }

    /*=======================================================
     Set Methods
      =====================================================*/
    public CSVArray setCell(int x, int y){
    }

    public CSVArray setRow(int row){
    }

    public CSVArray setCol(int col){
    }

    /*=======================================================
      Add Methods
      =====================================================*/
    public CSVArray addCol(CSVArray col){
    }

    public CSVArray addCol(CSVArray col, int pos){
    }

    public CSVArray addRow(CSVArray row){
    }

    public CSVArray addRow(CSVArray row, int pos){
    }
    
    /*=======================================================
     Delete Methods
      =====================================================*/
    public CSVArray deleteCell(int x, int y){
    }

    public CSVArray deleteRow(int row){
    }

    public CSVArray deleteCol(int col){
    }

    /*=======================================================
      Sort Methods
      =====================================================*/
    public CSVArray sortRows(int col){
    }

    public CSVArray sortCols(int row){
    }

    /*=======================================================
      Join Methods
      =====================================================*/
    public CSVArray innerJoin(int col1, int col2){
    }

    public CSVArray outerJoin(int col1, int col2){
    }

    public static ArrayList search(Object target){
    }

    public static ArrayList searchCell(Object target){
    }

    /*=======================================================
      Mathematical Operations
      =====================================================*/
    public static double add(int col){
    }
    
    public static CSVArray add(int col1, int col2){
    }

    public static CSVArray subtract(int col1, int col2){
    }

    public static CSVArray multiply(int col1, int col2){
    }

    public static CSVArray divide(int col1, int col2){
    }

    /*=======================================================
      Statistics Methods
      =====================================================*/
    public static double min(int col){
    }

    public static double firstQ(int col){
    }

    public static double median(int col){
    }

    public static double thirdQ(int col){
    }

    public static double max(int col){
    }

    public static void stat5NumSummary(int col){
    }

    public static String boxAndWhisker(int col){
    }

    public static double average(int col){
    }

    public static double standardDev(int col){
    }

    public static double correlation(Object function){
    }

    /*=======================================================
      Pretty Printing
      =====================================================*/
    public static String prettyPrint(){
    }
    
    /*=======================================================
      Testing
      =====================================================*/
    public static void main(String[] args){
    }
}
