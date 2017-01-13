/**
 * The class CSVTool parses arguments from the command line to determine which
 * method to use. The action is then performed on the CSV, and any information
 * that results from the method is printed to the console.
 */

import java.io.FileNotFoundException;

public class CSVTool{
    

    /**
     * Returns a string message that details which flag to use for which method.
     *
     * @return  string containing help data
     */
    public static String help() {
	return "help";
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
