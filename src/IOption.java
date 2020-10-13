import java.util.Arrays;
import java.util.List;

public interface IOption {
	
	public String getShortVersion();

	public void setShortVersion(String shortVersion);

	public String getLongVersion();

	public void setLongVersion(String longVersion);

	public String getDescription();

	public void setDescription(String description);
	
	/**
	 * @return a list of short and long versions of available options
	 */
	public List<String> getOptionVersions();
	
	/**
	 * A method to change the status of an option
	 * @param status
	 */
	public void setStatus(String status) ;
	
	/**
	 * @return true if option is enabled, false otherwise
	 */
	public boolean isEnaled();
}
