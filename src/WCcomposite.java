import java.io.IOException;

//This class is used for executing the counting process for the wc counter
public class WCcomposite extends Counter{
	int	totalLines = 0, totalWords = 0, totalChars = 0; //used to save results of different counting processes
	boolean inWord = false;

	public void countingAll(String [] args, CounterFactory cf) throws IOException {
		for(int j = 0; j < args.length; j++) {
			ICounter [] counters = cf.createCounter(args[j]); // create counters for each file
			counters[0].readFile(args[j]);
			// Execute the word,line,character count.
			int  c;
			int  nChars = 0, nLines = 0, nWords = 0;
			inWord = false;
			while((c = srcStream.read()) != EOF ) {
				nChars = counters[0].process(c, nChars);
				nWords = counters[1].process(c, nWords, inWord);
				inWord = WordCounter.inWord;
				nLines = counters[2].process(c, nLines);
			}
			// Close and flush the opened file.
			closeSrcStream(srcStream);
			
			// Print the result of the source file.
			System.out.println(srcFilename + " : " + nLines +" lines, " + nWords + " words, " + nChars + " chars\n");
			totalLines += nLines;
			totalWords += nWords;
			totalChars += nChars;

		}
		//	Print the total if more than one source file.
		if (args.length > 1) {
			System.out.println("**Total: " + totalLines + " lines, " + totalWords + " words, " + totalChars + " chars\n");
		}
		
	}
}
