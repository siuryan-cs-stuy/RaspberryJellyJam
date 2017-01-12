/**
 * The class CSVGeneral contains all the methods for general CSV file editing.
 */


public class CSVGeneral{
    
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
    public static CSVArray setCell(int x, int y, Object value){
    }

    public static CSVArray setRow(int rowPos, ArrayList rowVal){
    }

    public static CSVArray setCol(int colPos, ArrayList colVal){
    }

    /*=======================================================
      Add Methods
      =====================================================*/
    public static CSVArray addCol(CSVArray col){
    }

    public static CSVArray addCol(CSVArray col, int pos){
    }

    public static CSVArray addRow(CSVArray row){
    }

    public static CSVArray addRow(CSVArray row, int pos){
    }
    
    /*=======================================================
     Delete Methods
      =====================================================*/
    public static CSVArray deleteCell(int x, int y){
    }

    public static CSVArray deleteRow(int row){
    }

    public static CSVArray deleteCol(int col){
    }

    /*=======================================================
      Sort Methods
      =====================================================*/
    public static CSVArray sortRows(int col){
    }

    public static CSVArray sortCols(int row){
    }

    /*=======================================================
      Join Methods
      =====================================================*/
    public static CSVArray innerJoin(int col1, int col2){
    }

    public static CSVArray outerJoin(int col1, int col2){
    }

    public static ArrayList search(Object target){
    }

    public static ArrayList searchCell(Object target){
    }

     /*=======================================================
      Pretty Printing
      =====================================================*/
    public static String prettyPrint(){
    }

}
