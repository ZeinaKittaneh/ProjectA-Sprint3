import java.io.File;
import java.io.IOException;

public interface IAdmin {
	/**
	 * A method to parse the command line arguments array
	 * @param args[] command line arguments array
	 * @return boolean, true: valid arguments, false: invalid arguments
	 * @throws IOException
	 */
	boolean parseOptionsArgs(String args[]) throws IOException;
	
	/**
	 * A method to check if the argument is an option then enable it and disable the other options 
	 * @param arg : an argument
	 * @return true if arg is a valid option, false otherwise
	 */
	boolean checkOptions(String arg);

	/**
	 * A method to check if arguments array is empty
	 * @param args
	 * @return true if args length = 0, false otherwise
	 */
	boolean checkEmptyArgs(String [] args);
	
	/**
	 * A method to return the valid list of files entered by user
	 * @return String[] files List
	 */
	String [] getFilesList();
}
