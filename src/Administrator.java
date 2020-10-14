import java.io.*;
import java.util.*;

//A class used to parse arguments and options entered in the command line programs
public class Administrator implements IAdmin{
	//Define the valid options: help, verbose and banner options
    public static final Option help = new Option("-h", "-help", "List a summary of all options and their arguments.");
    public static final Option verbose = new Option("-v", "-verbose", "Enable verbose output.");
    public static final Option banner =  new Option("-b" , "-banner", "Print the application's banner.");
	public static File srcFile = null;
	protected String srcFilename;
	private String args[];
    public List<String> filesList = new ArrayList<String>(); //A list of all valid files entered by the user

	/**
	 * Administrator constructor
	 * @param args[] command line arguments array
	 */
	public Administrator(String[] args) {
		this.args = args;
	}
	
	/**
	 * A method to parse the command line arguments array
	 * @param args[] command line arguments array
	 * @return boolean, true: valid arguments, false: invalid arguments
	 */
	public boolean parseOptionsArgs(String args[]) throws IOException {
		FileCheck fileChecker = new FileCheck();
		if(!checkEmptyArgs(args)) { //Check if user has entered arguments
			for(int i = 0; i < args.length; i++) { //loop all arguments, check if it is an option or a file 
				if (checkOptions(args[i]));
				else if(fileChecker.fileExists(args[i], this)); //make process in a separate file
				else
					return false;			
			}
			return true;			
		}
		else 
			return false;
	}

	/**
	 * A method to check if the argument is an option then enable it and disable the other options 
	 * @param arg : an argument
	 * @return true if arg is a valid option, false otherwise
	 */
	public boolean checkOptions(String arg) {
		if(help.getOptionVersions().contains(arg)) {
			help.setStatus("enabled");
			Option.verboseEnabled = false;
			banner.setStatus("disabled");
			return true;
		}
		else if(verbose.getOptionVersions().contains(arg)) {
			help.setStatus("disabled");
			Option.verboseEnabled = true;
			banner.setStatus("disabled");
			return true;
		}
		else if(banner.getOptionVersions().contains(arg)) {
			help.setStatus("disabled");
			Option.verboseEnabled = false;
			banner.setStatus("enabled");
			return true;
		}
		return false;
	}
	
	/**
	 * A method to check if arguments array is empty
	 * @param args
	 * @return true if args length = 0, false otherwise
	 */
	public boolean checkEmptyArgs(String [] args) {
		return args.length == 0;
	}
	
	/**
	 * A method to return the valid list of files entered by user
	 * @return String[] files List
	 */
	public String [] getFilesList() {
		return filesList.toArray(new String[filesList.size()]);
	}
	
}
