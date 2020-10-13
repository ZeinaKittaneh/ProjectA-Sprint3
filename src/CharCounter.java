import java.io.FileInputStream;
import java.io.IOException;

public class CharCounter extends Counter{
//	public static final String USAGE = "The charcount program is used to cound characters in a source file"
//			+ "\nUsage: charcount <option> <src file> ";
//	public static final Banner BANNER = new Banner("charcount", "1.1", "2020-2021", "Zeina Kittaneh");

	/**
	 * CharCounter constructor
	 * @param srcFilename
	 */
	public CharCounter(String srcFilename) {
		this.srcFilename = srcFilename;
	}
	
	public void startCounting() throws IOException {
		int c;
		int nChars = 0;
		while ( (c = srcStream.read()) != EOF ) {//call the calculation process until the end of file
			nChars = process(c, nChars); 
		}
		// Close and flush all the files.
		closeSrcStream(srcStream);
		
		// Print the result.
		printCountingResults(nChars, "Characters");

	}
	public int process(int c, int nChars) {
		if(!isSpace(c)) {
			nChars++;
			if(Option.verboseEnabled) {//Print "c" if verbose is enabled
				System.out.println("c\n");
			}
		}
		return nChars;
	}

}
