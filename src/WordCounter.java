import java.io.*;

public class WordCounter extends Counter{
//	public static boolean inWord = false;
//	public static final String USAGE = "The wordcount program is used to cound words in a source file"
//			+ "\nUsage: wordcount <option> <src file> ";
//	public static final Banner BANNER = new Banner("wordcount", "1.2", "2020-2021", "Zeina Kittaneh");

	/**
	 * WordCounter constructor
	 * @param srcFilename
	 */
	public WordCounter(String srcFilename) {
		this.srcFilename = srcFilename;
	}
	
	public void startCounting() throws IOException {
		int c;
		int nWords = 0;
		while ( (c = srcStream.read()) != EOF ) {//calls the calculation process until the end of file
			nWords = process(c, nWords, inWord);
		}
		// Close and flush all the files.
		closeSrcStream(srcStream);
		
		// Print the result.
		printCountingResults(nWords, "Words");
			
	}
	
	public int process(int c, int nWords, boolean inWord) {
		if (!isSpace(c)) {
			if (!inWord) {
				this.inWord = true;
				++nWords;
				if(Option.verboseEnabled) {//Print "w" if verbose is enabled
					System.out.println("w\n");
				}
			}
		} else {
			this.inWord = false;
		}
		return nWords;
	}	
}
