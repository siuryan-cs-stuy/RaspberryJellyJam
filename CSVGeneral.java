/**
 * The class CSVGeneral contains all the methods for general CSV file editing.
 */


public class CSVGeneral{
    
    /*=======================================================
     Accessor Methods
      =====================================================*/
    
    public Object getCell(int x, int y){
	return _data[x][y];
    }

    public ArrayList getRow(int row){
	return _data[x];
    }

    public ArrayList getCol(int col){
	ArrayList column = new ArrayList();
	for (ArrayList<Object> row : _data){
	    column.add(row[col]);
	}
    }

    /*=======================================================
     Set Methods
      =====================================================*/
    public CSVArray setCell(int x, int y, Object value){
	_data[x][y] = value;
    }

    public CSVArray setRow(int rowPos, ArrayList rowVal){
	_data[rowPos] = rowVal;
    }

    public CSVArray setCol(int colPos, ArrayList colVal){
	int index = 0;
	for (ArrayList<Object> row : _data){
	    row[colPos] = colVal[index];
	    index++
		}
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

    public ArrayList search(Object target){
    }

    public ArrayList searchCell(Object target){
    }

     /*=======================================================
      Pretty Printing
      =====================================================*/
    public static String prettyPrint(){
    }

}
