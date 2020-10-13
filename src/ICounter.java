import java.io.*;

public interface ICounter {		
	static int EOF = -1; //End of file
	
	/**
	 * A method to read a file
	 * @param srcFilename
	 * @throws IOException
	 */
	public void readFile(String srcFilename) throws IOException;
	
	/**
	 * A method that combines all counting steps by applying template design pattern
	 * @param file
	 * @throws IOException
	 */
	public void countingProcess(String file) throws IOException;
	
	/**
	 * A method to start the counting process
	 * @throws IOException
	 */
	public void startCounting() throws IOException;
	
	
	/**
	 * A method for word counting calculations 
	 * @param c
	 * @param nWords
	 * @param inWord
	 * @return
	 */
	public int process(int c, int nWords, boolean inWord);
	
	
	/**
	 * A method for lines or characters counting calculations 
	 * @param c
	 * @param n
	 * @return
	 */
	public int process(int c, int n);
	
	/**
	 * A method to check if a character is empty
	 * @param c
	 * @return true if a character is empty, false otherwise
	 */
	public boolean isSpace(int c);
	
	/**
	 * A method that close a file input stream
	 * @param srcStream
	 * @throws IOException
	 */
	public static void closeSrcStream(FileInputStream srcStream) throws IOException{};
	
	/**
	 * A method that prints all counting results
	 * @param count
	 * @param type
	 */
	public void printCountingResults(int count, String type);
	
	public String getSrcFilename();
	
	public void setSrcFilename(String srcFilename);

}
