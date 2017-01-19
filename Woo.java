/**
 * The class CSVTool parses arguments from the command line to determine which
 * method to use. The action is then performed on the CSV, and any information
 * that results from the method is printed to the console.
 */

import java.util.ArrayList;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Woo{
    

    /**
     * Returns a string message that details which flag to use for which method.
     *
     * @return  string containing help data
     */
    public static String help() {
	String helpStr = "";
	helpStr += "Syntax: java Woo <filename> <command> <args...>\n";
	helpStr += "Possible <command> <args...>\n";
	helpStr += "--help\n";
	helpStr += "--getCell <row#> <column#>\n";
	helpStr += "--getRow <row#>\n";
	helpStr += "--getCol <column#>\n";
	helpStr += "--setCell <row#> <column#> <value>\n";
	helpStr += "--setRow <row#> <filename>\n";
	helpStr += "--setCol <column#> <position> <filename>\n";
	helpStr += "--addRow <filename>\n";
	helpStr += "--addRow <filename> <position>\n";
	helpStr += "--addCol <filename>\n";
	helpStr += "--addCol <filename> <position>\n";
	helpStr += "--delCell <row#> <column#>\n";
	helpStr += "--delRow <row#>\n";
	helpStr += "--delCol <column#>\n";
	helpStr += "--min <column#>\n";
	helpStr += "--max <column#>\n";
	helpStr += "--prettyPrint";
	return helpStr;
    }

	
    /**
     * Runs the Terminal CSV Editor. Uses args to take in arguments from the
     * terminal.
     */
    public static void main(String[] args)throws FileNotFoundException{
	boolean writeToFile = false;
	// if there are arguments
	if (args.length != 0) {
	
	    //checks for the write to file flag
	    writeToFile = (args[args.length-1]).equals("-w");

	    //checks for the case where --help is the first arg and not the filename
	    if (args[0].equals("--help")){
		System.out.println(help());
		return;
	    }
	    
	    // if a command is present
	    CSVArray csv = new CSVArray(args[0]); //create CSVArray with filename
	    if (args.length != 1) {
		
		String command = args[1];
		Object result = null;
	    
		if (command.equals("--getCell")){
		    result = csv.getCell(Integer.parseInt(args[2]), Integer.parseInt(args[3]));
		}

		if (command.equals("--getRow")){
		    result = csv.getRow(Integer.parseInt(args[2]));
		}

		if (command.equals("--getCol")){
		    result = csv.getCol(Integer.parseInt(args[2]));
		}

		if (command.equals("--setCell")){
		    result = csv.setCell(Integer.parseInt(args[2]), Integer.parseInt(args[3]), CSVArray.typePicker(args[4]));
		}

		if (command.equals("--setRow")){
		    CSVArray second = new CSVArray(args[3]);
		    result = csv.setRow(Integer.parseInt(args[2]), second._data.get(0));
		}
	
		if (command.equals("--setCol")){
		    CSVArray second = new CSVArray(args[3]);
		    ArrayList col = new ArrayList();
		    for (ArrayList i: second._data){
			col.add(i.get(0));
		    }
		    result = csv.setCol(Integer.parseInt(args[2]), col);
		}

		if (command.equals("--addCol")){
		    if (args.length == 5){
		        result = csv.addCol(new CSVArray(args[2]), Integer.parseInt(args[3]));
		    }
		    else{
			result = csv.addCol(new CSVArray(args[2]));
		    }
		}
	
		if (command.equals("--addRow")){
		    if (args.length == 5){
		        result = csv.addRow(new CSVArray(args[2]), Integer.parseInt(args[3]));
		    }
		    else{
			result = csv.addRow(new CSVArray(args[2]));
		    }
		}

		if (command.equals("--deleteCell")){
		    result = csv.deleteCell(Integer.parseInt(args[2]), Integer.parseInt(args[3]));
		}

		if (command.equals("--deleteRow")){
		    result = csv.deleteRow(Integer.parseInt(args[2]));
		}

		if (command.equals("--deleteCol")){
		    result = csv.deleteCol(Integer.parseInt(args[2]));
		}

		if (command.equals("--prettyPrint")){
		    result = CSVGeneral.prettyPrint(csv);
		}

		if (command.equals("--min")){
		    result = CSVStat.min(Integer.parseInt(args[2]),csv);
		}

		if (command.equals("--max")){
		    result = CSVStat.max(Integer.parseInt(args[2]),csv);
		}

		if (command.equals("--sum")){
			result = CSVMath.sum(Integer.parseInt(args[2]),csv);
		}

		if (command.equals("--add")){
		    result = CSVMath.add(Integer.parseInt(args[2]),Integer.parseInt(args[3]),csv);
		}

		if (command.equals("--subtract")){
		    result = CSVMath.subtract(Integer.parseInt(args[2]),Integer.parseInt(args[3]),csv);
		}

		if (command.equals("--multiply")){
		    result = CSVMath.multiply(Integer.parseInt(args[2]),Integer.parseInt(args[3]),csv);
		}

		if (command.equals("--divide")){
		    result = CSVMath.divide(Integer.parseInt(args[2]),Integer.parseInt(args[3]),csv);
		}
		
		if (result != null) {
		    if (result instanceof CSVArray && writeToFile) {
			try {
			    csv.write();
			} catch (IOException e) {
			    System.out.println("Write error");
			}
		    }
		    System.out.println(result);
		    return;
		}
	
		System.out.println("Invalid argument(s). Please use the --help flag for a list of commands.");
	    }

	    else {
		System.out.println(CSVGeneral.prettyPrint(csv));
		return;
	    }
	}
    
	//no args -> print help
	else {
	    System.out.println( help() );
	}
    }
}
