
public interface IBanner {
	
	/**
	 * A method to print the banner info
	 * @return String
	 */
	public String toString();
	
	public String getProgramName();
	
	public void setProgramName(String programName);
	
	public String getVersion();
	
	public void setVersion(String version);
	
	public String getYear();
	
	public void setYear(String year);
	
	public String getWriter();
	
	public void setWriter(String writer);
}
