import java.util.Arrays;
import java.util.List;

public class Option implements IOption{
	private String shortVersion;
	private String longVersion;
	private String description;
	private String optionStatus = "disabled";
	public static boolean verboseEnabled = false;
			
	public Option(String shortVersion, String longVersion, String description) {
		this.shortVersion = shortVersion;
		this.longVersion = longVersion;
		this.description = description;
	}

	public String getShortVersion() {
		return shortVersion;
	}

	public void setShortVersion(String shortVersion) {
		this.shortVersion = shortVersion;
	}

	public String getLongVersion() {
		return longVersion;
	}

	public void setLongVersion(String longVersion) {
		this.longVersion = longVersion;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	/**
	 * @return a list of short and long versions of available options
	 */
	public List<String> getOptionVersions() {
		String[] verArray = {this.getShortVersion(), this.getLongVersion()};
		return Arrays.asList(verArray);
	}
	
	public void setStatus(String status) {
		this.optionStatus = status;		
	}
	
	public boolean isEnaled() {
		return this.optionStatus == "enabled";
	}

}
