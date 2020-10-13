
public class Banner implements IBanner{
	private String programName;
	private String version;
	private String year;
	private String writer;
	
	/**
	 * Banner constructor
	 * @param programName
	 * @param version
	 * @param year
	 * @param writer
	 */
	public Banner(String programName, String version, String year, String writer) {
		this.programName = programName;
		this.version = version;
		this.year = year;
		this.writer = writer;
	}
	
	@Override
	public String toString() {
		return " " + programName + ", Version " + version + "\n(c)" + year + ", " + writer + ". All Rights Reserved.";
	}
	
	public String getProgramName() {
		return programName;
	}
	public void setProgramName(String programName) {
		this.programName = programName;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
}
