import java.io.*;

abstract class Counter implements ICounter{
	protected File srcFile = null;
	protected String srcFilename = "<srcFilename>";
	protected static FileInputStream srcStream;
	static boolean inWord = false;
	
	//template method	
	public final void countingProcess(String srcFilename) throws IOException {
		readFile(srcFilename);
		startCounting();
	}
	
	public void readFile(String srcFilename) throws IOException{	
		this.srcStream = new FileInputStream(new File(srcFilename));
	}
	
	public void startCounting() throws IOException{};
	
	@Override
	public int process(int c, int nWords, boolean inWord) {
		return 0;
	}

	@Override
	public int process(int c, int n) {
		return 0;
	}
	
	public boolean isSpace(int c) {
		  return (c == ' ' || c == '\t' || c == '\n' || c == '\r');
	}
	
	public void closeSrcStream(FileInputStream srcStream) throws IOException{
		srcStream.close();
	}
	
	public void printCountingResults(int count, String type) {
		System.out.println(type + " count : done.");
		System.out.println("The file contains : " + count + " " + type);
	}
	
	public String getSrcFilename() {
		return srcFilename;
	}
	
	public void setSrcFilename(String srcFilename) {
		this.srcFilename = srcFilename;
	}

}

