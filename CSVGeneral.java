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
    public CSVArray setCell(int x, int y, Object value){
    }

    public CSVArray setRow(int rowPos, ArrayList rowVal){
    }

    public CSVArray setCol(int colPos, ArrayList colVal){
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
      Pretty Printing
      =====================================================*/
    public static String prettyPrint(){
    }

}
