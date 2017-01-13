/**
 * The class CSVTool parses arguments from the command line to determine which
 * method to use. The action is then performed on the CSV, and any information
 * that results from the method is printed to the console.
 */

public class CSVTool{
    

    /**
     * Returns a string message that details which flag to use for which method.
     *
     * @return  string containing help data
     */
    public String help() {

    }


    /*
     * Calls a method depending on the command.
     */
    private CSVArray callMethod(String command) {
	switch (command) {
	case "getCell": 
	}
    }
    
	
    /**
     * Runs the Terminal CSV Editor. Uses args to take in arguments from the
     * terminal.
     */
    public static void main(String[] args){

	// if there are arguments
	if (args.length != 0) {

	    // if there is a flag present
	    if (args[1].startsWith("--")) {

		// gets the filename
		String filename = args[0];

		// gets the command part of the flag
		String command = args[1].substring(2);

		CSVArray arr = new CSVArray(filename);
	        
		
	    } else {
		System.out.println("Invalid argument(s). Please use the --help flag for a list of commands.");
	    }
	    
	} else {
	    System.out.println( help() );
	}
	
    }

}
