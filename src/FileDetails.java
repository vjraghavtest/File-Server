
public class FileDetails {
	private String name,checksum;

	public FileDetails(String name, String checksum) {
		this.name = name;
		this.checksum = checksum;
	}

	public String getName() {
		return name;
	}

	public String getChecksum() {
		return checksum;
	}
	
}
