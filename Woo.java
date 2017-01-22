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
	helpStr += "Syntax: java Woo <filename> <command> <args...>\n";
	helpStr += "Possible <command> <args...>\n";
	helpStr += "--help\n";
	helpStr += "for a specific description of a method, <method> -h\n";
	helpStr += "--getCell <row#> <col#>\n";
	helpStr += "--getRow <row#>\n";
	helpStr += "--getCol <column#>\n";
	helpStr += "--setCell <row#> <col#> <value>\n";
	helpStr += "--setRow <fileName> <position>\n";
	helpStr += "--setCol <fileName> <position>\n";
	helpStr += "--addRow <filename>\n";
	helpStr += "--addRow <filename> <position>\n";
	helpStr += "--addCol <filename>\n";
	helpStr += "--addCol <filename> <position>\n";
	helpStr += "--deleteCell <row#> <col#>\n";
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
	helpStr += "--standardDev <col#>\n";
	helpStr += "--average <col#>\n";
	helpStr += "--correlation <col1#> <col2#>\n";
	helpStr += "--prettyPrint\n";	
	return helpStr;
    }
    
    public static String specificHelp(String method){
	if (method.equals("getCell")){
	    return "returns the value of a specified row";}
	if (method.equals("getRow")){
	    return "returns the specified row";}
	if (method.equals("getCol")){
	    return "returns the specified column";}
	if (method.equals("setCell")){
	    return "returns how a csv's data would look like after a specified cell is set to a value";}
	if (method.equals("setRow")){
	    return "returns how a csv's data would look like after a specified row is set to the data of another csv, assuming that csv only has one row";}
	if (method.equals("setCol")){
	    return "returns how a csv's data would look like after a specified column is set to the data of another csv, assuming that csv only has one row";}
	if (method.equals("addRow")){
	    return "returns how a csv's data would look like after another csv's data, which only has one row, is added as a row to the end or a specified location of this csv's data";}
	if (method.equals("addCol")){
	    return "returns how a csv's data would look like after another csv's data, which only has one row, is added as a column to the end or a specified location of this csv's data";}
	if (method.equals("deleteCell")){
	    return "returns how a csv's data would look like after nullifying a specified cell ";}
	if (method.equals("deleteRow")){
	    return "returns how a csv's data would look like after deleting a specified row";}
	if (method.equals("deleteCol")){
	    return "returns how a csv's data would look like after deleting a specified column";}
	if (method.equals("sort")){
	    return "returns the elements of a column in an ascending order";}
	if (method.equals("searchCell")){
	    return "returns the coordinates of the first occurrence of a phrase";}
	if (method.equals("searchRow")){
	    return"returns the coordinates of the first occurrence of a phrase in a specified row";}
	if (method.equals("searchCol")){
	    return "returns the coordinates of the first occurrence of a phrase in a specified column";}
	if (method.equals("sum")){
	    return "returns the sum of a column";}
	if (method.equals("add")){
	    return "returns the sums across both columns";}
	if (method.equals("subtract")){
	    return "returns the differences across both columns";}
	if (method.equals("divide")){
	    return"returns the quotients across both columns";}
	if (method.equals("multiply")){
	    return"returns the products across both columns";}
	if (method.equals("min")){
	    return "returns the minimum value of a column";}
	if (method.equals("max")){
	    return"returns the maximum value of a column";}
	if (method.equals("median")){
	    return"returns the medium value of a column";}
	if (method.equals("firstQ")){
	    return"returns the first quartile value of a column";}
	if (method.equals("thirdQ")){
	    return"returns the third quartile value of a column";}
	if (method.equals("average")){
	    return"returns the average of a column";}
	if (method.equals("standardDev")){
	    return"returns the population standard deviation of a column";}
	if (method.equals("correlation")){
	    return"returns the correlation between two columns";}
	if (method.equals("prettyPrint")){
	    return"returns a representation of a csv's data";}
	else{return "Invalid method. Please use --help for a list of commands.";}
    }   
	    
    public static boolean invalidFile(String fileName){
	File f = new File(fileName);
	//If the file doesn't exist or it is a directory or the filename isn't long enough to be a csv file or it is not a csv file
	return !(f.exists() && !f.isDirectory() && (fileName.length() > 4) &&  fileName.substring(fileName.length()-4).equals(".csv"));
    }

    public static String rowString(ArrayList arr){
	String retStr = "";
	for (Object elem: arr){
	    retStr += elem + ",";
	}
	return retStr.substring(0, retStr.length()-1);
    }

    public static String colString(ArrayList arr){
	String retStr = "";
	for(Object elem: arr){
	    retStr += elem + "\n";
	}
	return retStr;
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

	    //checks for the specific help flag
	    if (args[1].equals("-h")){
		System.out.println(specificHelp(args[0]));
		return;
	    }
		
	    CSVArray csv;
	    
	    //Ensures that the file argument is valid
	    if (invalidFile(args[0])){
		System.out.println("Invalid file type.\n Consult --help for argument structure.");
		return;
	    } else if (args.length == 1) {
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

	    String command = args[1];
	    Object result = null;
	    
	    if (command.equals("--getCell")){
		result = csv.getCell(Integer.parseInt(args[2]), Integer.parseInt(args[3]));
	    }

	    if (command.equals("--getRow")){
		result = rowString(csv.getRow(Integer.parseInt(args[2])));
	    }

	    if (command.equals("--getCol")){
		result = colString(csv.getCol(Integer.parseInt(args[2])));
	    }

	    if (command.equals("--setCell")){
		result = csv.setCell(Integer.parseInt(args[2]), Integer.parseInt(args[3]), CSVArray.typePicker(args[4]));
	    }

	    if (command.equals("--setRow")){
		CSVArray second = new CSVArray(args[3]);
		result = csv.setRow(new CSVArray(args[2]), Integer.parseInt(args[3]));
	    }
	
	    if (command.equals("--setCol")){
		CSVArray second = new CSVArray(args[3]);
		result = csv.setCol(new CSVArray(args[2]), Integer.parseInt(args[3]));
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

	    if (command.equals("--sort")){
		result = colString(csv.sort(Integer.parseInt(args[2])));
	    }

	    if (command.equals("--searchCell")){
		result = csv.searchCell(args[2]);
	    }

	    if (command.equals("--searchRow")){
		 result = rowString(csv.searchRow(args[2]));
	    }

	     if (command.equals("--searchCol")){
		 result = colString(csv.searchCol(args[2]));
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

	    if (command.equals("--average")){
		result = CSVStat.average(Integer.parseInt(args[2]),csv);
	    }

	    if (command.equals("--standardDev")){
		result = CSVStat.standardDev(Integer.parseInt(args[2]),csv);
	    }

	    if (command.equals("--correlation")){
		result = CSVStat.correlation(Integer.parseInt(args[2]),Integer.parseInt(args[3]),csv);
	    }

	    if (command.equals("--median")){
		result = CSVStat.median(Integer.parseInt(args[2]),csv);
	    }

	    if (command.equals("--thirdQ")){
		result = CSVStat.thirdQ(Integer.parseInt(args[2]),csv);
	    }

	    if (command.equals("--firstQ")){
		result = CSVStat.firstQ(Integer.parseInt(args[2]),csv);
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
	    if (command.equals("--prettyPrint")){
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
