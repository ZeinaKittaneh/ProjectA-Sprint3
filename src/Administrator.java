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
//				if(isValidArgs(args)) {//Check number of arguments
					for(int i = 0; i < args.length; i++) { //loop all arguments, check if it is an option or a file 
						if (checkOptions(args[i]));
						else if(fileChecker.fileExists(args[i], this)); //make process in a separate file
						else
							return false;			
					}
					//print option based on last user option choice -- move it to wcoo
//					if(help.isEnaled())
//						System.out.println(proUsage);
//					else if(banner.isEnaled())
//						System.out.println(proBanner);
//					else if(Option.verboseEnabled && getFilesList().length == 0) { //if user didn't specify an option or a file
//						System.out.println("Please specify a source file!");
//						return false;
//					}
					return true;			
//				}
//				else {
//					System.out.println("not valid");
//					return false;
//					
//				}
//			}
//			else 
//				return false;
		}
		else {
//			proUsage.get(programName);
//			System.out.println("empty args!");
			return false;
		}
	}

	/**
	 * A method to check the validity of a program name
	 * @param programName
	 * @return true if programName is valid, false otherwise
	 */
//	public boolean checkProgramName(String programName) {
//		if(proBanner.contains(programName)) {
//			this.programName= programName; 
//			return true;
//		}
//		else {
//			System.out.println("invalid program name!");
//			return false;
//		}
//	}
	
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
	 * A method to check the validity of the number of arguments
	 * @param args[]
	 * @return true if args length >= 2, false otherwise
	 */
//	public boolean isValidArgs(String args[]) {
//		if (args.length < 1){
//			//proUsage.get(programName);
//			return false;
//		}
//		return true;
//	}
	
	/**
	 * A method to check if a file exists
	 * @param srcFilename
	 * @return true if file exists, false otherwise
	 * @throws IOException
	 */
//	public boolean fileExist(String srcFilename) throws IOException{
//		if (srcFilename != null) { // Check <src>
//			//System.out.println("Counting Characters in: srcFilename = '" + srcFilename + "'");
//			srcFile = new File(srcFilename);
//			if (!srcFile.canRead()) {
//				System.out.println("Cannot open File '" + srcFilename + "'");
//				return false;
//			}
//			else {
//				System.out.println(srcFilename);
//				filesList.add(srcFilename);
//				System.out.println("[OK] Filename = '" + srcFilename + "'");
//				return true;
//			}
//		}
//		return false;
//	}
	
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
