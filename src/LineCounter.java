import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;

public class LineCounter extends Counter{
//	public static final String USAGE = "The linecount program is used to cound lines in a source file"
//			+ "\nUsage: linecount <option> <src file> ";
//	public static final Banner BANNER = new Banner("linecount", "1.3", "2020-2021", "Zeina Kittaneh");

	/**
	 * LineCounter constructor
	 * @param srcFilename
	 */
	public LineCounter(String srcFilename) {
		this.srcFilename = srcFilename;
	}
	
	public void startCounting() throws IOException {
		// Execute the line count.	
		int c = 0;
		int nLines = 0;

		while ((c = srcStream.read()) != EOF) {//calls the calculation process until the end of file
			nLines = process(c, nLines);
		}
		// Close and flush all the files.
		closeSrcStream(srcStream);
		
		// Print the result.
		printCountingResults(nLines, "Lines");
	}
	
	public int process(int c, int nLines) {
		if (c == '\n') {
			nLines++;
			if(Option.verboseEnabled) { //Print "l" if verbose is enabled
				System.out.println("l\n");
			}
		}
		return nLines;
	}
	

}
