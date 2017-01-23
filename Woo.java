/**
 * The class CSVTool parses arguments from the command line to determine which
 * method to use. The action is then performed on the CSV, and any information
 * that results from the method is printed to the console.
 */

import java.util.ArrayList;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.File;

public class Woo{
    
    /**
     * Returns a string message that details which flag to use for which method.
     *
     * @return  string containing help data
     */
    public static String help() {
	String helpStr = "";
	helpStr += "Syntax: java Woo <filename> <command> <args...> <flag>\n";
	helpStr += "Possible <command> <args...>\n";
	helpStr += "--help\n";
	helpStr += "--getCell <col#> <row#>\n";
	helpStr += "--getRow <row#>\n";
	helpStr += "--getCol <column#>\n";
	helpStr += "--setCell <col#> <row#> <value>\n";
	helpStr += "--setRow <fileName> <position>\n";
	helpStr += "--setCol <fileName> <position>\n";
	helpStr += "--addRow <filename>\n";
	helpStr += "--addRow <filename> <position>\n";
	helpStr += "--addCol <filename>\n";
	helpStr += "--addCol <filename> <position>\n";
	helpStr += "--deleteCell <col#> <row#>\n";
	helpStr += "--deleteRow <row#>\n";
	helpStr += "--deleteCol <col#>\n";
	helpStr += "--sort <col#>\n";
	helpStr += "--searchCell <target phrase>\n";
	helpStr += "--searchRow <target phrase>\n";
	helpStr += "--searchCol <target phrase>\n";
	helpStr += "--sum <col#>\n";
	helpStr += "--add <col1#> <col2#>\n";
	helpStr += "--subtract <col1#> <col2#>\n";
	helpStr += "--multiply <col1#> <col2#>\n";
	helpStr += "--divide <col1#> <col2#>\n";
	helpStr += "--min <col#>\n";
	helpStr += "--max <col#>\n";	
	helpStr += "--median <col#>\n";
	helpStr += "--firstQ <col#>\n";
	helpStr += "--thirdQ <col#>\n";
	helpStr += "--statSummary <col#>\n";
	helpStr += "--standardDev <col#>\n";
	helpStr += "--average <col#>\n";
	helpStr += "--correlation <col1#> <col2#>\n";
	helpStr += "--prettyPrint\n";
	helpStr += "\nFlags:\n";
	helpStr += "-h : For a specific description of a method, --<method> -h\n";
	helpStr += "-w : Writes the output of the program directly to the csv file provided. Cannot be used with -l\n";
	helpStr += "-l : Does not include the header/label row in performing the command. Cannot be used with -w";
	return helpStr;
    }

    /**
     * Returns a string message that gives a description of a specified method.
     *
     * @return  string containing method description
     */
    public static String specificHelp(String method){
	if (method.equals("--getCell")){
	    return "returns the value of a specified row";}
	if (method.equals("--getRow")){
	    return "returns the specified row";}
	if (method.equals("--getCol")){
	    return "returns the specified column";}
	if (method.equals("--setCell")){
	    return "returns how a csv's data would look like after a specified cell is set to a value";}
	if (method.equals("--setRow")){
	    return "returns how a csv's data would look like after a specified row is set to the data of another csv, assuming that csv only has one row";}
	if (method.equals("--setCol")){
	    return "returns how a csv's data would look like after a specified column is set to the data of another csv, assuming that csv only has one row";}
	if (method.equals("--addRow")){
	    return "returns how a csv's data would look like after another csv's data, which only has one row, is added as a row to the end or a specified location of this csv's data";}
	if (method.equals("--addCol")){
	    return "returns how a csv's data would look like after another csv's data, which only has one row, is added as a column to the end or a specified location of this csv's data";}
	if (method.equals("--deleteCell")){
	    return "returns how a csv's data would look like after nullifying a specified cell ";}
	if (method.equals("--deleteRow")){
	    return "returns how a csv's data would look like after deleting a specified row";}
	if (method.equals("--deleteCol")){
	    return "returns how a csv's data would look like after deleting a specified column";}
	if (method.equals("--sort")){
	    return "returns the elements of a column in an ascending order";}
	if (method.equals("--searchCell")){
	    return "returns the coordinates of the first occurrence of a phrase";}
	if (method.equals("--searchRow")){
	    return"returns the number of the row in which a specified phrase first occurs";}
	if (method.equals("--searchCol")){
	    return "returns the number of the column in which a specified phrase first occurs";}
	if (method.equals("--sum")){
	    return "returns the sum of a column";}
	if (method.equals("--add")){
	    return "returns the sums across both columns";}
	if (method.equals("--subtract")){
	    return "returns the differences across both columns";}
	if (method.equals("--divide")){
	    return"returns the quotients across both columns";}
	if (method.equals("--multiply")){
	    return"returns the products across both columns";}
	if (method.equals("--min")){
	    return "returns the minimum value of a column";}
	if (method.equals("--max")){
	    return"returns the maximum value of a column";}
	if (method.equals("--median")){
	    return"returns the medium value of a column";}
	if (method.equals("--firstQ")){
	    return"returns the first quartile value of a column";}
	if (method.equals("--thirdQ")){
	    return"returns the third quartile value of a column";}
	if (method.equals("--statSummary")){
	    return"prints the five number summary of a column";}
	if (method.equals("--average")){
	    return"returns the average of a column";}
	if (method.equals("--standardDev")){
	    return"returns the population standard deviation of a column";}
	if (method.equals("--correlation")){
	    return"returns the correlation between two columns";}
	if (method.equals("--prettyPrint")){
	    return"returns a representation of a csv's data";}
	else{return "Invalid method. Please use --help for a list of commands.";}
    }   

    //takes in a filename and decides whether it is a real csv file in the system
    public static boolean invalidFile(String fileName){
	File f = new File(fileName);
	//If the file doesn't exist or it is a directory or the filename isn't long enough to be a csv file or it is not a csv file
	return !(f.exists() && !f.isDirectory() && (fileName.length() > 4) &&  fileName.substring(fileName.length()-4).equals(".csv"));
    }

    //turns an arraylist into a csv row
    public static String rowString(ArrayList arr){
	String retStr = "";
	for (Object elem: arr){
	    retStr += elem + ",";
	}
	return retStr.substring(0, retStr.length()-1);
    }

    //turns an arraylist into a csv column
    public static String colString(ArrayList arr){
	String retStr = "";
	for(Object elem: arr){
	    retStr += elem + "\n";
	}
	return retStr;
    }

    //ensures that the method takes exactly as many as were given
    public static void catchOOB(int numArgs, int argLen, boolean writeFlag){
	if ((numArgs > argLen - 3) && writeFlag ||((numArgs > argLen-2) && !writeFlag)){
	    System.out.println( "Error: Not enough arguments supplied. Please consult --help for argument information");
	    System.exit(0);
	}
	else if(((numArgs < argLen - 3) && writeFlag) || (numArgs < argLen-2 && !writeFlag)){
	    System.out.println("Error: Too many arguments/flags supplied. Please consult --help for argument information");
	    System.exit(0);
	}
    }

    //ensures that the user's selection doesnt go out of the CSVArray's bounds
    public static void catchRange(int col, int row, CSVArray csv){
	if (col > csv.numCols() || col < 1){
	    System.out.println("Error: Column index out of range");
	    System.exit(0);
	}
	else if(row > csv.numRows() || row < 1){
	    System.out.println("Error: row index out of range");
	    System.exit(0);
	}
    }


    public static void catchStringMath(int col, CSVArray csv){
	for(Object o:csv.getCol(col)){
	    if(o instanceof String){
		System.out.println("Error: Unable to perform mathematical operations on non numberical column");
		System.exit(0);
	    }
	}
    }
	
    /**
     * Runs the Terminal CSV Editor. Uses args to take in arguments from the
     * terminal.
     */
    public static void main(String[] args)throws FileNotFoundException{
	boolean writeToFile = false;
	boolean fileHeaders = false;
	
	// if there are arguments
	if (args.length != 0) {
	
	    //checks for the write to file flag
	    writeToFile = (args[args.length-1]).equals("-w");
	    fileHeaders = (args[args.length-1]).equals("-l");

	    //checks for the case where --help is the first arg and not the filename
	    if (args[0].equals("--help")){
		System.out.println(help());
		return;
	    }

	    //checks for the specific help flag
	    if (args.length > 1 && args[1].equals("-h")){
		catchOOB( 0, args.length, writeToFile || fileHeaders);
		System.out.println(specificHelp(args[0]));
		return;
	    }
     
	    CSVArray csv;
	    
	    //Ensures that the file argument is valid
	    if (invalidFile(args[0])){
		System.out.println("Invalid file type.\n Consult --help for argument structure.");
		return;
	    }
	    
	    if (args.length == 1) {
		csv = new CSVArray(args[0]);
		System.out.println(CSVGeneral.prettyPrint(csv));
		return;
	    }

	    if (args.length < 2 || args.length < 3 && writeToFile){
		System.out.println("Arguments not supplied.\n Consult --help for argument Structure.");
		return;
	    } 

	    //create CSVArray with filename
	    csv = new CSVArray(args[0]);
	    if (fileHeaders) {
		csv.deleteRow(1);
	    }

	    String command = args[1];
	    Object result = null;
	    
	    if (command.equals("--getCell")){
		catchOOB(2, args.length, writeToFile || fileHeaders);
		catchRange(Integer.parseInt(args[2]), Integer.parseInt(args[3]), csv);
		result = csv.getCell(Integer.parseInt(args[2]), Integer.parseInt(args[3]));
	    }

	    if (command.equals("--getRow")){
		catchOOB(1, args.length, writeToFile || fileHeaders);
		catchRange(1,Integer.parseInt(args[2]), csv);
		result = rowString(csv.getRow(Integer.parseInt(args[2])));
	    }

	    if (command.equals("--getCol")){
		catchOOB(1, args.length, writeToFile || fileHeaders);
		catchRange(Integer.parseInt(args[2]), 1, csv);
		result = colString(csv.getCol(Integer.parseInt(args[2])));
	    }

	    if (command.equals("--setCell")){
		catchOOB(3, args.length, writeToFile || fileHeaders);
		catchRange(Integer.parseInt(args[2]), Integer.parseInt(args[3]), csv);
		result = csv.setCell(Integer.parseInt(args[2]), Integer.parseInt(args[3]), CSVArray.typePicker(args[4]));
	    }

	    if (command.equals("--setRow")){
		catchOOB(2, args.length, writeToFile || fileHeaders);
		if (invalidFile(args[2])){
		    System.out.println("Error: Invalid file type for Row.");
		    return;
		}
		CSVArray second = new CSVArray(args[2]);
		catchRange(1,Integer.parseInt(args[3]), csv);
		result = csv.setRow(new CSVArray(args[2]), Integer.parseInt(args[3]));
	    }
	
	    if (command.equals("--setCol")){
		catchOOB(2, args.length, writeToFile || fileHeaders);
		catchRange(Integer.parseInt(args[3]), 1, csv);
	        if (invalidFile(args[2])){
		    System.out.println("Error: Invalid file type for Col.");
		    return;
		}
		result = csv.setCol(new CSVArray(args[2]), Integer.parseInt(args[3]));
	    }

	    if (command.equals("--addCol")){
		if (invalidFile(args[2])){
		    System.out.println("Error: Invalid file type for collumn.");
		    return;
		}
		CSVArray col = new CSVArray(args[2]);
		if (col.numCols() > 1 || col.numCols() < 1){
		    System.out.println("Error: Column CSV file is not a single column");
			return;
		}
		if (args.length > 3 && !(writeToFile || fileHeaders) || args.length > 4 && (writeToFile || fileHeaders)){
		    catchRange(Integer.parseInt(args[3]), 1, csv);
		    result = csv.addCol(col, Integer.parseInt(args[3]));
		}
		else{
		    catchOOB(1, args.length, writeToFile || fileHeaders);
		    result = csv.addCol(col);
		}
	    }
	
	    if (command.equals("--addRow")){
		if (invalidFile(args[0])){
		    System.out.println("Error: Invalid file type for row.");
		    return;
		}
		CSVArray row = new CSVArray(args[2]);
		if (row.numRows() > 1 || row.numRows() < 1){
		    System.out.println("Error: Row CSV file is not a single row");
			return;
		}
		if (args.length > 3 && !(writeToFile || fileHeaders) || args.length > 4 && (writeToFile || fileHeaders)){
		    catchRange(1, Integer.parseInt(args[3]), csv);
		    result = csv.addRow(new CSVArray(args[2]), Integer.parseInt(args[3]));
		}
		else{
		    catchOOB(1, args.length, writeToFile || fileHeaders);
		    result = csv.addRow(new CSVArray(args[2]));
		}
	    }

	    if (command.equals("--deleteCell")){
		catchOOB(2, args.length, writeToFile || fileHeaders);
		catchRange(Integer.parseInt(args[2]), Integer.parseInt(args[3]), csv);
		result = csv.deleteCell(Integer.parseInt(args[2]), Integer.parseInt(args[3]));
	    }

	    if (command.equals("--deleteRow")){
		catchOOB(1, args.length, writeToFile || fileHeaders);
		catchRange(1, Integer.parseInt(args[2]), csv);
		result = csv.deleteRow(Integer.parseInt(args[2]));
	    }

	    if (command.equals("--deleteCol")){
		catchOOB(1, args.length, writeToFile || fileHeaders);
		catchRange(Integer.parseInt(args[2]), 1, csv);
		result = csv.deleteCol(Integer.parseInt(args[2]));
	    }

	    if (command.equals("--sort")){
		catchOOB(1, args.length, writeToFile || fileHeaders);
		catchRange(Integer.parseInt(args[2]), 1, csv);
		result = colString(csv.sort(Integer.parseInt(args[2])));
	    }

	    if (command.equals("--searchCell")){
		catchOOB(1, args.length, writeToFile || fileHeaders);
		result = csv.searchCell(args[2]);
	    }

	    if (command.equals("--searchRow")){
		catchOOB(1, args.length, writeToFile || fileHeaders);
		result = csv.searchRow(args[2]);
	    }

	     if (command.equals("--searchCol")){
		 catchOOB(1, args.length, writeToFile || fileHeaders);
		 result = csv.searchCol(args[2]);
	    }

	    if (command.equals("--min")){
		catchOOB(1, args.length, writeToFile || fileHeaders);
		catchRange(Integer.parseInt(args[2]),1, csv);
		catchStringMath(Integer.parseInt(args[2]), csv);
		result = CSVStat.min(Integer.parseInt(args[2]),csv);
	    }

	    if (command.equals("--max")){
		catchOOB(1, args.length, writeToFile || fileHeaders);
		catchRange(Integer.parseInt(args[2]),1, csv);
		catchStringMath(Integer.parseInt(args[2]), csv);
		result = CSVStat.max(Integer.parseInt(args[2]),csv);
	    }

	    if (command.equals("--average")){
		catchOOB(1, args.length, writeToFile || fileHeaders);
		catchRange(Integer.parseInt(args[2]),1, csv);
		catchStringMath(Integer.parseInt(args[2]), csv);
		result = CSVStat.average(Integer.parseInt(args[2]),csv);
	    }

	    if (command.equals("--standardDev")){
		catchOOB(1, args.length, writeToFile || fileHeaders);
		catchRange(Integer.parseInt(args[2]),1, csv);
		catchStringMath(Integer.parseInt(args[2]), csv);
		result = CSVStat.standardDev(Integer.parseInt(args[2]),csv);
	    }

	    if (command.equals("--correlation")){
		catchOOB(2, args.length, writeToFile || fileHeaders);
		catchRange(Integer.parseInt(args[2]),1, csv);
		catchStringMath(Integer.parseInt(args[2]), csv);
		result = CSVStat.correlation(Integer.parseInt(args[2]),Integer.parseInt(args[3]),csv);
	    }

	    if (command.equals("--median")){
		catchOOB(1, args.length, writeToFile || fileHeaders);
		catchRange(Integer.parseInt(args[2]),1, csv);
		catchStringMath(Integer.parseInt(args[2]), csv);
		result = CSVStat.median(Integer.parseInt(args[2]),csv);
	    }

	    if (command.equals("--thirdQ")){
		catchOOB(1, args.length, writeToFile || fileHeaders);
		catchRange(Integer.parseInt(args[2]),1, csv);
		catchStringMath(Integer.parseInt(args[2]), csv);
		result = CSVStat.thirdQ(Integer.parseInt(args[2]),csv);
	    }

	    if (command.equals("--firstQ")){
		catchOOB(1, args.length, writeToFile || fileHeaders);
		catchRange(Integer.parseInt(args[2]),1, csv);
		catchStringMath(Integer.parseInt(args[2]), csv);
		result = CSVStat.firstQ(Integer.parseInt(args[2]),csv);
	    }

	    if (command.equals("--statSummary")){
		catchOOB(1, args.length, writeToFile || fileHeaders);
		catchRange(Integer.parseInt(args[2]),1, csv);
		catchStringMath(Integer.parseInt(args[2]), csv);
		CSVStat.statSummary(Integer.parseInt(args[2]),csv);
	        return;
	    }

	    if (command.equals("--sum")){
		catchOOB(1, args.length, writeToFile || fileHeaders);
		catchRange(Integer.parseInt(args[2]),1, csv);
		catchStringMath(Integer.parseInt(args[2]), csv);
		result = CSVMath.sum(Integer.parseInt(args[2]),csv);
	    }

	    if (command.equals("--add")){
		catchOOB(2, args.length, writeToFile || fileHeaders);
		catchRange(Integer.parseInt(args[2]),1, csv);
		catchRange(Integer.parseInt(args[3]),1, csv);
		catchStringMath(Integer.parseInt(args[2]), csv);
		catchStringMath(Integer.parseInt(args[3]), csv);
		result = colString(CSVMath.add(Integer.parseInt(args[2]),Integer.parseInt(args[3]),csv));
	    }

	    if (command.equals("--subtract")){
		catchOOB(2, args.length, writeToFile || fileHeaders);
		catchRange(Integer.parseInt(args[2]),1, csv);
		catchRange(Integer.parseInt(args[3]),1, csv);
		catchStringMath(Integer.parseInt(args[2]), csv);
		catchStringMath(Integer.parseInt(args[3]), csv);
		result = colString(CSVMath.subtract(Integer.parseInt(args[2]),Integer.parseInt(args[3]),csv));
	    }

	    if (command.equals("--multiply")){
		catchOOB(2, args.length, writeToFile || fileHeaders);
		catchRange(Integer.parseInt(args[2]),1, csv);
		catchRange(Integer.parseInt(args[3]),1, csv);
		catchStringMath(Integer.parseInt(args[2]), csv);
		catchStringMath(Integer.parseInt(args[3]), csv);
		result = colString(CSVMath.multiply(Integer.parseInt(args[2]),Integer.parseInt(args[3]),csv));
	    }

	    if (command.equals("--divide")){
		catchOOB(2, args.length, writeToFile || fileHeaders);
		catchRange(Integer.parseInt(args[2]),1, csv);
		catchRange(Integer.parseInt(args[3]),1, csv);
		catchStringMath(Integer.parseInt(args[2]), csv);
		catchStringMath(Integer.parseInt(args[3]), csv);
		result = colString(CSVMath.divide(Integer.parseInt(args[2]),Integer.parseInt(args[3]),csv));
	    }
	    
	    if (command.equals("--prettyPrint")){
		catchOOB(0, args.length, writeToFile || fileHeaders);
		System.out.println(CSVGeneral.prettyPrint(csv));
		return;
	    }
		
	    if (result != null) {
		if (result instanceof CSVArray && writeToFile) {
		    try {
			csv.write();
		    } catch (IOException e) {
			System.out.println("Error writing to file");
		    }
		}
		System.out.println(result);
		return;
	    }
	
	    System.out.println("Invalid argument(s). Please use the --help flag for a list of commands.");
	}
    
	//no args -> print help
	else {
	    System.out.println( help() );
	}
    }
}
