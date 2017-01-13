/**
 * The class Woo parses arguments from the command line to determine which
 * method to use. The action is then performed on the CSV, and any information
 * that results from the method is printed to the console.
 */

import java.io.FileNotFoundException;

public class Woo{
    

    /**
     * Returns a string message that details which flag to use for which method.
     *
     * @return  string containing help data
     */
    public static String help() {
        String s = "Possible Commands:\n\nGet Methods\njava Woo file.csv --get_cell 2 3\nReturns the value at a cell given input coordinates\njava Woo file.csv --get_col 5\nReturns a column of a csv\njava Woo file.csv --get_row 5\nReturns the row of a csv\n\nSet Methods:\njava Woo file.csv --set 2 3 String \nChanges the value at a cell given input coordinates and the new value\njava Woo file --setRow 3 1,2,3\nSets the row at a given row number to a new row provided that the new column is in csv format\njava Woo file --setCol 0 jello,herro,2\nSets the column at a given column number to a new column provided that the new column is in csv format\n\nAdd Methods\njava Woo file --addRow 3,hello,2\nAccepts a CSV row and adds it to the end of a given CSV file and outputs the new CSV\njava Woo file --addRow 5 well,then,0\nAccepts a CSV row and adds it to a given position of a CSV file\njava Woo file --addCol 0,2,word\nAccepts a CSV row and adds it as a column to the end of a given CSV file\njava Woo file --addCol 6 dog,cat,rain\nAccepts a CSV row and adds it to a given position as a column of a given CSV file\n\nDelete Methods\njava Woo file --deleteCell 1,2\ndeletes a cell at a given coordinate\njava Woo file --deleteRow 3\ndeletes a specified row\njava Woo file --deleteCol 2\ndeletes a specified column";
	return s;
    }

 
    /*
     * Calls a method depending on the command.
     */
    //   private CSVArray callMethod(String command) {
    //	switch (command) {
    //	case "getCell": 
    //	}
    //}
    
	
    /**
     * Runs the Terminal CSV Editor. Uses args to take in arguments from the
     * terminal.
     */
    public static void main(String[] args)throws FileNotFoundException{

	// if there are arguments
	if (args.length != 0) {

	    if (args[0].equals("--help")){
		System.out.println(help());
		return;
	    }
	    // if there is a flag present
	    CSVArray csv = new CSVArray(args[0]);
	    String command = args[1];
	    
	    if (command.startsWith("--")) {
		
		if (command.equals("--getCell")){
		    System.out.println(CSVGeneral.getCell(Integer.parseInt(args[2]), Integer.parseInt(args[3]), csv));
		}
		
	    } else {
		System.out.println("Invalid argument(s). Please use the --help flag for a list of commands.");
	    }
	    
	} else {
	    System.out.println( help() );
	}
	
    }

}
