/**
 * The class CSVGeneral contains all the methods for general CSV file editing.
 */


public class CSVGeneral{
    
    /*=======================================================
     Accessor Methods
      =====================================================*/
    
    public Object getCell(int x, int y){
        _data.get(x).get(y);
    }

    public ArrayList getRow(int row){
	return _data.get(row);
    }

    public ArrayList getCol(int col){
        ArrayList column = new ArrayList();
	for (ArrayList<Object> row : _data){
	    column.add(row.get(col));
	}
    }

    /*=======================================================
     Set Methods
      =====================================================*/
    public CSVArray setCell(int x, int y, Object value){
	_data.get(x).set(y,value);
    }

    public CSVArray setRow(int rowPos, ArrayList rowVal){
	_data.set(rowPos, rowVal);
    }

    public CSVArray setCol(int colPos, ArrayList colVal){
        int index = 0;
	for (ArrayList<Object> row : _data){
	    row.set(colPos,colVal.get(index);
	    index++
		}
    }

    /*=======================================================
      Add Methods
      =====================================================*/
    public CSVArray addCol(CSVArray col){
	int index = 0;
	for (ArrayList<Object> row : _data){
	    row.add(col._data.get(index));}
	return this;
    }

    public CSVArray addCol(CSVArray col, int pos){
	int index = 0;
	for (ArrayList<Object> row : _data){
	    row.add(pos,_data.get(index));
	}
	return this;
    }

    public CSVArray addRow(CSVArray row){
	_data.add(row);
	return this;
    }

    public CSVArray addRow(CSVArray row, int pos){
	_data.add(pos,row);
	return this;
    }
    
    /*=======================================================
     Delete Methods
      =====================================================*/
    public CSVArray deleteCell(int x, int y){
    }

    public CSVArray deleteRow(int row){
	_data.remove(row);
	return this;
    }

    public CSVArray deleteCol(int col){
	for (ArrayList<Object> row : _data){
	    row.remove(col);
	}
	return this;
    }
    
}
